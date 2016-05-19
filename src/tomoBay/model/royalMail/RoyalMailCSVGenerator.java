package tomoBay.model.royalMail;
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
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import tomoBay.helpers.Config;
import tomoBay.helpers.ConfigReader;

/**
 * This class represents an object that generates CSV files in a format that the Royal Mail Dispatch
 * Manager Online can accept.
 * 
 * The Columns in this CSV are laid out as follows:
 * 
 * |Field Name				|Order|Format|Notes																|
 * |:------------------:|:---:|:----:|:--------------------------------------------------:|
 * |Service Reference	|	0	|	n/a |	SR1																|
 * |Service					|	1	|	n/a |	available options: 24/48/SD500/SD1000/SD2500			|
 * |Recipient				|	2	|	n/a | recipients name												|
 * |Address Line 1		|	3	|	n/a | first address line											|
 * |Address Line 2		|	4	|`	n/a | second address line											|
 * |PostCode				|	5	|	n/a | recipients post code (must match with post town)	|
 * |Post Town				|	6	|	n/a | recipients town must match with postcode				|
 * |Country Code			|	7	|	n/a | GB																	|
 * |Reference				|	8	|	n/a | (C or F or P) followed by invoice#						|
 * |Items					|	9	|`	n/a | always 1															|
 * |Weight					|	10	|12000 | the weight in grams of the invoice						|
 * |Service Enhancement |	11	|	n/a | SF (if signed for) OR leave blank						|
 * |Service Format		|	12	|	n/a | L (for letter) or P(for parcel)							|
 *
 * @author Jan P.C. Hanson
 *
 */
public final class RoyalMailCSVGenerator implements CSVGenerator
{
	private final String[] columnNames_M;
	private final String[] columnValidations_M;
	private char separator_M = ',';
	private char entryIndicator_M='"';
	private List<String[]> result_M;
	
	/**
	 * ctor, creates an empty CSV of the format:
	 * "Service Reference","Service","Recipient","Address Line 1","Address Line 2","PostCode","Post Town",
	 * "Country Code","Reference","Items","Weight","Service Enhancement","Service Format",
	 */
	public RoyalMailCSVGenerator()
	{
		super();
		this.columnNames_M = ConfigReader.getConfs(Config.CSV_FIELD_NAME);
		this.columnValidations_M = ConfigReader.getConfs(Config.CSV_FIELD_VALID);
		this.result_M = new ArrayList<String[]>();
	}
	
	/**
	 * This method allows you to set different separators than the default values, it is recommended
	 * to leave the defaults active unless you have a good reason not to. 
	 * @param separator defaults to a comma ,
	 * @param entryIndicator defaults to double quotes ""
	 */
	@Override
	public void setseparators(char separator, char entryIndicator)
	{
		this.separator_M = separator;
		this.entryIndicator_M = entryIndicator;
	}

	/**
	 *  Adds a row of data to the CSV and checks the validity of the data against the specification
	 *  defined in the config file (tomoBay.conf)
	 * @param row String[] of data to be inserted into the CSV
	 * @throws ArrayIndexOutOfBoundsException if the data array is longer than is specified by this CSV
	 * (see tomoBay.conf)
	 * @throws ArrayStoreException if the data is not valid data for a particular column (see tomobay.conf)
	 */
	@Override
	public void addRow(String[] row) throws ArrayIndexOutOfBoundsException, ArrayStoreException
	{
		RoyalMailCSVGenerator.checkSize(row, this.columnNames_M);
		RoyalMailCSVGenerator.validate(row, this.columnValidations_M);
		this.result_M.add(row);
	}
	
	/**
	 * adds a whole batch of data to the end of the CSV
	 * @param batch List<String[]> containing the batch information
	 * @throws ArrayIndexOutOfBoundsException if the data array is longer than is specified by this CSV
	 * (see tomoBay.conf)
	 * @throws ArrayStoreException if the data is not valid data for a particular column (see tomobay.conf)
	 */
	public void addBatch(List<String[]> batch) throws ArrayIndexOutOfBoundsException
	{this.result_M.addAll(batch);}

	/**
	 * Generated the actual CSV file, it will overwrite any file already at that path with the name
	 * specified.
	 * @param fileName the name of the file to create
	 * @param filePath the path of the file to create
	 * @param encoding the encoding to use on creation of the file
	 * @throws IOException 
	 */
	@Override
	public void generate(String fileName, String filePath, String encoding) throws IOException
	{
		List<String> output = new ArrayList<String>();
		Path fPath = Paths.get(filePath, fileName);
		Files.deleteIfExists(fPath);
		
		for(int i = 0 ; i < this.result_M.size() ; ++i)
		{
			String line = "";
			for (int j = 0 ; j < this.result_M.get(i).length ; ++j)
			{
				line += this.entryIndicator_M +this.result_M.get(i)[j] + this.entryIndicator_M +this.separator_M;
			}
			output.add(line);
		}
		
		Files.write(fPath, output, Charset.forName(encoding));
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.royalMail.CSVGenerator#size()
	 */
	@Override
	public int size()
	{return this.columnNames_M.length;}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String result = "";
		for(int i = 0 ; i < this.result_M.size() ; ++i)
		{
			for(int j = 0 ; j < this.result_M.get(i).length ; ++j)
			{
				result += this.entryIndicator_M +this.result_M.get(i)[j] + this.entryIndicator_M +this.separator_M;
			}
			result += "\n";
		}
		return result;
	}
	
	/**
	 * make sure that the two arrays are the same length
	 * @param row the String[] containing the data
	 * @param columnNames String[] containing the column names
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private static void checkSize(String[] row, String[] columnNames) throws ArrayIndexOutOfBoundsException
	{
		if(row.length != columnNames.length) 
		{throw new ArrayIndexOutOfBoundsException("The array provided has a length of "+row.length
																+ " but should have a length of "+columnNames.length);}
	}
	
	/**
	 * Use the validation data pulled from the config file at construction time and make sure that the
	 * data entries are valid.
	 * @param row Data to be validated
	 * @param columnValidations the regular expressions used to validate the data
	 * @throws ArrayStoreException thrown if any of the expressions do not find matches.
	 */
	private static void validate(String[] row, String[] columnValidations) throws ArrayStoreException
	{
		for(int i = 0 ; i < row.length ; ++i)
		{
			if(row[i].matches(columnValidations[i])==false)
			{throw new ArrayStoreException("column "+ i+" does not match specification(see tomoBay.conf)");}
		}
	}
}
