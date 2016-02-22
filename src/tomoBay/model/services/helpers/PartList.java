package tomoBay.model.services.helpers;
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
import java.util.Arrays;
/**
 * converts a list of parts in the form of a string containing part numbers and quantities
 * into a unordered 2-tuple list of part numbers and their associated quantities.
 * @author Jan P.C. Hanson
 *
 */
public final class PartList
{
	/**internal holder for part numbers**/
	private String[] partNos_M;
	/**internal holder for part quantities**/
	private int[] partQty_M;
	
	/**
	 * creates a part list with the partNoString provided.
	 * @param partNoString a list of part numbers and quantities. acceptable formats are:
	 * 1234 or 1234(1)567(2)8910(3) or 1234(1)567(2)8910 [if 8910 has qty 1] or 1234 567 [if
	 * both 1234 AND 567 have qty 1
	 */
	public PartList(String partNoString)
	{
		super();
		this.convert(partNoString);
	}
	
	/**
	 * get the part number at position i in the list
	 * @param i the index of the partNumber you wish to get
	 * @return String part number stored at index i
	 */
	public String getPartNumber(int i)
	{return this.partNos_M[i];}
	
	/**
	 * get the part numbers as a whole
	 * @return String[] where the elements correspond to the part numbers as ordered in the 
	 * argument passed to the constructor.
	 */
	public String[] getPartNumbers()
	{return this.partNos_M;}
	/**
	 * get the quantity of the part number at position i in the list
	 * @param i the index of the part number you wish to query the quantity of.
	 * @return int the quantity of the part number at index i
	 */
	public int getPartQty(int i)
	{return this.partQty_M[i];}
	
	/**
	 * get the par quantities as a whole.
	 * @return int[] with each element containing the quantity of the part associated with the
	 * same index.
	 */
	public int[] getPartQtys()
	{return this.partQty_M;}
	
	/**
	 * the size of the part list.
	 * @return the size of the part list.
	 */
	public int size()
	{return this.partNos_M.length;}
	
	/**
	 * de- allocate internal data.
	 */
	public void destroy()
	{
		this.partNos_M = null;
		this.partQty_M = null;
	}
	//if string contains brackets and no spaces 
	//if string contains spaces and no brackets 
	//if string contains no brackets no spaces 
	//if string contains brackets and spaces 
	/**
	 * orchestrates the conversion of the composite part number as provided in the constructor
	 * to individual part numbers. depending on the format of the composite part number i.e. 
	 * does it contain brackets and/or spaces etc. 
	 * @param partNoString
	 */
	private void convert(String partNoString)
	{
		if (partNoString.endsWith(")")==false && 
				(partNoString.contains("(")==true && partNoString.contains(" ")==false ||
				partNoString.contains("(")==true && partNoString.contains(" ")==true))
		{bracketsNSpacesTrunc(partNoString);}
		else if(partNoString.contains("(")==true && partNoString.contains(" ")==false ||
				partNoString.contains("(")==true && partNoString.contains(" ")==true)
		{bracketsNSpaces(partNoString);}
		else if (partNoString.contains("(")==false && partNoString.contains(" ")==true)
		{spacesNoBrackets(partNoString);}
		else if (partNoString.contains("(")==false && partNoString.contains(" ")==false)
		{noBracketsNoSpaces(partNoString);}
		else{error(partNoString);}
	}
	
	
	/**
	 * convert a composite part number containing brackets and spaces i.e. there is more than 
	 * one part number or a quantity larger than 1. uses regex W00t :)
	 * @param input the composite part number
	 */
	private void bracketsNSpaces(String input)
	{
		//match anything that starts with a ( then contains any number of digits and ends with
		//a closing )
		String quantity = "\\([0-9]*\\)( ?)*+";
		//match anything that starts with any number of digits case insensitive letters and 
		// forward slashes followed by the above.
		String partNoAndQty = "([0-9a-zA-Z/]*)\\(([0-9]*)\\)( ?)*";
		
		//split the 'input' string using 'pattern'
		this.partNos_M = input.split(quantity);
		//in 'input' replace all 'pattern2' matches with group 2 matches of 'pattern2' plus a 
		//space, then split the resulting string at every space.
		String[] tmp = input.replaceAll(partNoAndQty, "$2 ").split(" ");
		this.partQty_M = new int[this.partNos_M.length];
		for(int i = 0; i < tmp.length ; ++i) 
		{
			try
			{this.partQty_M[i] = Integer.parseInt(tmp[i]);}
			catch(NumberFormatException nfe)
			{this.partQty_M[i]=-8008135; this.partNos_M[i] = "ERROR: "+nfe.getMessage();}
		}
	}
	
	/**
	 * does the conversion for an input string that contains brackets and spaces but where the 
	 * last part number has no brackets i.e. quantity of 1 on last entry.
	 * @param input the composite part number
	 */
	private void bracketsNSpacesTrunc(String input)
	{
		this.bracketsNSpaces(input);
		this.partQty_M[this.partQty_M.length-1] = 1;
	}
	/**
	 * does the conversion for a composite part number where the composite contains spaces but
	 * no brackets i.e. all part numbers have quantity 1.
	 * @param input the composite part number
	 */
	private void spacesNoBrackets(String input)
	{
		this.partNos_M = input.split(" ");
		this.partQty_M = new int[this.partNos_M.length];
		Arrays.fill(this.partQty_M, 1);
	}
	
	/**
	 * does the conversion for a composite part number where the input contains no brackets or 
	 * spaces i.e. the composite part number contains only one part number and it has a quantity
	 * of 1.
	 * @param input the composite part number
	 */
	private void noBracketsNoSpaces(String input)
	{
		this.partNos_M = new String[] {input};
		this.partQty_M = new int[] {1};
	}
	
	/**
	 * if the part number is not convertible as defined by the rules of the convert method this
	 * method is triggered. It provides an easily recognisable error code. 
	 * @param input the composite part number.
	 */
	private void error(String input)
	{
		this.partNos_M = new String[] {"invalid part numbers: " + input};
		this.partQty_M = new int[] {-8008135};
	}
}