package tomoBay.presenters.presenterActions.concreteActions;
/** Copyright(C) 2015 Jan P.C. Hanson & Tomo Motor Parts Limited
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.exceptions.PresenterActionException;
import tomoBay.helpers.BrandToCode;
import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.royalMail.RoyalMailCSV;
import tomoBay.model.royalMail.RoyalMailCSVGenerator;
import tomoBay.model.sql.framework.SelectQueryInvoker;
import tomoBay.model.sql.framework.SelectQueryInvoker.SelectQueryTypeParams;
import tomoBay.model.sql.schema.accountsTable.AccountsTable;
import tomoBay.model.sql.schema.buyerTable.BuyerTable;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.model.winstock.Stock;
import tomoBay.presenters.presenterActions.AbstractPresenterAction;
/**
 * This class represents a presenter action that will generate a CSV file in a format compatible
 * with the Royal Mail DMO, and will generate it in a place that is accessibe to the frontend.
 * 
 * The format of the input to this PresenterAction is:
 * "Account-SalesRecNo-Service-Service Enhancement-format|Account-SalesRecNo-Service-Service Enhancement-format|....."
 *
 * @author Jan P.C. Hanson
 *
 */
public final class GenerateRoyalMailCSV implements AbstractPresenterAction
{
	/**defines where the Account info is within the input data**/
	private static final int ACCOUNT = 0;
	/**defines where the sales record number is within the input data**/
	private static final int SALES_REC_NO = 1;
	/**defines where the Service info is within the input data**/
	private static final int SERVICE = 2;
	/**defines where the service enhancement info is within the input data**/
	private static final int SERVICE_ENHANCEMENT = 3;
	/**defines where the format info is within the input data**/
	private static final int FORMAT = 4;
	/**holder for the model object RoyalMailCSVGenerator**/
	private final RoyalMailCSVGenerator csvGen_M;
	
	/**
	 * default ctor
	 */
	public GenerateRoyalMailCSV()
	{
		super();
		this.csvGen_M = new RoyalMailCSVGenerator();
	}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.presenterActions.AbstractPresenterAction#execute(java.lang.String)
	 */
	@Override
	public String execute(String data)
	{
		try
		{
			String[][] initialData = this.processInput(data);
			String[][] result = this.formatInitialData(initialData);
			//grab DB info
			result = this.grabAndProcessDBData(result, initialData);
			//must grab invoice weight after DB call otherwise no invoiceNo exists
			result = this.getInvoiceWeight(result, initialData);
			//add the account letter to the front of the invoice number
			result = this.formatReferenceFields(result, initialData);
			return this.createCSV(result);
		}
		catch(PresenterActionException pae)
		{return pae.getMessage();}
		catch(NumberFormatException nfe)
		{return "you forgot to enter a part number for an entry";}
		catch(ArrayIndexOutOfBoundsException aioobe)
		{return "you forgot to enter information for an entry or you have not added an entry";}
	}

	/**
	 * takes the input string and makes it accessible as an array, the public static finals define the
	 * indices that the data is stored at.
	 * @param input String of the form 
	 * "Account-SalesRecNo-Service-Service Enhancement-format|Account-SalesRecNo-Service-Service Enhancement-format|....."
	 * @return String[][] containing the intial data
	 * 
	 */
	private String[][] processInput(String input)
	{
		//splits the String into rows
		String[] halfProcessed = input.replaceAll(" ", "").split("[|]");
		
		String[][] fullyProcessed = new String[halfProcessed.length][];
		//splits each String in halfProcessed into an array
		for(int i = 0 ; i < halfProcessed.length ; ++i)
		{
			fullyProcessed[i] = halfProcessed[i].replace(' ', '\u0000').split("-");
		}
		return fullyProcessed;
	}
	
	/**
	 * formats the initial data passed in to the execute method by the frontend and puts data into the
	 * relevant columns for the CSV.
	 * @param initialData the String containing the input data
	 * @return String[][] containing as many elements as there are entries inputted into the frontend
	 * each of these elements is an array containing 13 data points with the data taken from the input
	 * put in the right places.
	 */
	private String[][] formatInitialData(String[][] initialData)
	{
		String[][] output = new String[initialData.length][csvGen_M.size()];
		for(int i = 0 ; i < initialData.length ; ++i)
		{
			output[i][RoyalMailCSV.SERVICE] = initialData[i][GenerateRoyalMailCSV.SERVICE];
			output[i][RoyalMailCSV.SERVICE_ENHANCEMENT] = initialData[i][GenerateRoyalMailCSV.SERVICE_ENHANCEMENT];
			output[i][RoyalMailCSV.SERVICE_FORMAT] = initialData[i][GenerateRoyalMailCSV.FORMAT];
			output[i][RoyalMailCSV.SERVICE_REF] = "SR1";
			output[i][RoyalMailCSV.COUNTRY_CODE] = "GB";
			output[i][RoyalMailCSV.ITEMS] = "1";
		}
		return output;
	}
	
	
	/**
	 * grabs the rest of the data necessary for the RoyalMailCSVGenerator to create a CSV file
	 * @param inputData the processed input data that acts as a key to grab the rest of the data from
	 * the database.
	 * @param initialData String[][] containing the intial data passed in from the frontend
	 * @return String[][] containing the data passed in with DB data inserted into relevant columns
	 */
	private String[][] grabAndProcessDBData(String[][] inputData, String[][] initialData)
	{
		HeteroFieldContainer dbaseContainer = new HeteroFieldContainer();
		
		for(int i = 0 ; i < inputData.length ; ++i)
		{
//			prepare query and grab data from database
			dbaseContainer.clear();
			dbaseContainer.add(AccountsTable.ACCOUNT_NAME, initialData[i][GenerateRoyalMailCSV.ACCOUNT]);
			dbaseContainer.add(OrdersTable.SALES_REC_NO, Integer.parseInt(initialData[i][GenerateRoyalMailCSV.SALES_REC_NO]));
		
			final List<HeteroFieldContainer> result = 
				SelectQueryInvoker.execute(SelectQueryTypeParams.SELECT_EBAY_BUYER_BY_ACCOUNT_AND_SRN, dbaseContainer);
			
			//format data
			if(result.size() != 0)
			{
				inputData[i][RoyalMailCSV.RECIPIENT] = result.get(0).get(BuyerTable.NAME, ClassRef.STRING);
				inputData[i][RoyalMailCSV.ADDRESS_LINE_1] = result.get(0).get(BuyerTable.STREET1, ClassRef.STRING);
				inputData[i][RoyalMailCSV.ADDRESS_LINE_2] = result.get(0).get(BuyerTable.STREET2, ClassRef.STRING);
				inputData[i][RoyalMailCSV.POSTCODE] = result.get(0).get(BuyerTable.POSTCODE, ClassRef.STRING).toUpperCase();
				inputData[i][RoyalMailCSV.POST_TOWN] = result.get(0).get(BuyerTable.CITY, ClassRef.STRING);
				inputData[i][RoyalMailCSV.REFERENCE] 
						= result.get(0).get(OrdersTable.INVOICED, ClassRef.INTEGER).toString();
			}
			else 
			{
				throw new PresenterActionException(
																"invalid sales record number or account: ["
																+initialData[i][GenerateRoyalMailCSV.SALES_REC_NO]
																+":"+initialData[i][GenerateRoyalMailCSV.ACCOUNT]+"]"
															);
			}
		}	
		return inputData;
	}
	
	/**
	 * queries winstock for the weight associated with the invoice number provided as an argument.
	 * @param inputData the String[][] to insert the weight into.
	 * @param initialData String[][] containing the initial data passed in from the frontend
	 * @return String[][] containing the data passed in with the weight inserted into the appropriate
	 * column.
	 */
	private String[][] getInvoiceWeight(String[][] inputData, String[][] initialData)
	{
		Stock winstock = new Stock();
		for(int i = 0 ; i < inputData.length ; ++i)
		{
			final int invoiceNo = Integer.parseInt(inputData[i][RoyalMailCSV.REFERENCE]);
			final int brandCode = BrandToCode.convertToWinstockInt(initialData[i][GenerateRoyalMailCSV.ACCOUNT]);
			final String weight = String.valueOf(winstock.requestInvoiceWeight(invoiceNo, brandCode));
			if(weight.equals("0")) {inputData[i][RoyalMailCSV.WEIGHT]= "1";}
			else {inputData[i][RoyalMailCSV.WEIGHT]= weight;}
		}
		return inputData;
	}
	
	/**
	 * adds the account letter to the front of the invoice number in the reference field of the CSV
	 * @param inputData the data after all extra information has been inserted
	 * @param initialData the initial data taken from the frontend
	 * @return String[][] completely formatted data ready to pass to the createCSV method.
	 */
	private String[][] formatReferenceFields(String[][] inputData, String[][] initialData)
	{
		for(int i = 0 ; i < inputData.length ; ++i)
		{
			inputData[i][RoyalMailCSV.REFERENCE] = BrandToCode.convert(initialData[i][GenerateRoyalMailCSV.ACCOUNT])
																+ inputData[i][RoyalMailCSV.REFERENCE];
		}
		return inputData;
	}
	
	/**
	 * use the information provided to create a CSV file that the frontend can access.
	 * @param csvData the data to include in the CSV file
	 * @return String containing the CSV formatted data
	 */
	private String createCSV(String[][] csvData)
	{
		List<String[]> dataToSend = new ArrayList<String[]>();
		//convert string[][] to List<String[]>
		for(int i = 0 ; i < csvData.length ; ++i)
		{dataToSend.add(csvData[i]);}
		//
		this.csvGen_M.addBatch(dataToSend);
		try
		{
			this.csvGen_M.generate("RoyalMail.csv", "./views/resources/", "UTF-8");
			return this.csvGen_M.toString();
		} 
		catch (IOException e)
		{return "Could Not Create File";}
	}
}
