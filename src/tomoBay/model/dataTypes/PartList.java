package tomoBay.model.dataTypes;
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
 *
 * @author Jan P.C. Hanson
 *
 */
public class PartList
{
	/**internal holder for part numbers**/
	private String[] partNos_M;
	/**internal holder for part quantities**/
	private int[] partQty_M;
	
	private static final String singlequant = "(?<=[0-9])\\s+(?=[^()]\\w)";
	/**
	 * creates an empty PartList
	 */
	public PartList()
	{
		super();
		this.partNos_M = new String[0];
		this.partQty_M = new int[0];
	}
	
	/**
	 * creates a part list with the partNoString provided.
	 * @param partNoString a list of part numbers and quantities. acceptable formats are:
	 * 1234 or 1234(1)567(2)8910(3) or 1234(1)567(2)8910 [if 8910 has qty 1] or 1234 567 [if
	 * both 1234 AND 567 have qty 1
	 */
	public PartList(String compositePartNo)
	{
		super();
		this.partNos_M = new String[0];
		this.partQty_M = new int[0];
		this.convert(compositePartNo);
	}
	
	/**
	 * add a part number to the PartList with a given quantity
	 * @param partNo the partNumber
	 * @param quantity the quantity of the part.
	 */
	public void add(String partNo, int quantity)
	{
		this.partNos_M = Arrays.copyOf(this.partNos_M, this.partNos_M.length+1);
		this.partQty_M = Arrays.copyOf(this.partQty_M, this.partQty_M.length+1);
		this.partNos_M[this.partNos_M.length-1] = partNo;
		this.partQty_M[this.partQty_M.length-1] = quantity;
	}
	
	/**
	 * 
	 * @param index
	 */
	public void remove(int index)
	{
		String[] tmpVal1 = new String[this.size()-1];
		String[] tmpVal2 = new String[this.size()-1];
		
		System.arraycopy(this.partNos_M, 0, tmpVal1, 0, index-1);
		System.arraycopy(this.partNos_M, index+1, tmpVal1, index+1, this.size()-index-1);
		
		System.arraycopy(this.partQty_M, 0, tmpVal2, 0, index-1);
		System.arraycopy(this.partQty_M, index+1, tmpVal2, index+1, this.size()-index-1);
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
	 * @throws Throwable 
	 */
	public void finalize() throws Throwable
	{
		this.partNos_M = null;
		this.partQty_M = null;
		super.finalize();
	}
	
	/**
	 * @param compositePartNo
	 */
	private void convert(String compositePartNo)
	{
		compositePartNo = compositePartNo.replaceAll(singlequant, "(1)").replace(" ", "");
		String[] res = compositePartNo.split("\\)");
		String partNo;
		int partQty;
		for(int i = 0 ; i < res.length ; ++i)
		{
			try
			{
				partNo = res[i].split("\\(")[0];
				partQty = Short.parseShort(res[i].split("\\(")[1]);
				this.add(partNo, partQty);
			}
			catch(Exception e)
			{
				partNo = "ERROR in partNo or Qty ("+res[i]+"))";
				partQty = -8008135;
				this.add(partNo, partQty);
			}
		}
	}
}