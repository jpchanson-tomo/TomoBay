package tomoBay.model.dataTypes.invoice;
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

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class InvoiceLine
{
	private String partNo_M;
	
	private String description_M;
	
	private int quantity_M;
	
	private int price_M;
	
	/**
	 * creates an invoice line using the parameters passed in.
	 * @param partNo the part number if the part in question
	 * @param description a description of the part in question
	 * @param qty the quantity of the part in question
	 * @param price the price of the part in question
	 */
	public InvoiceLine(String partNo, String description, int qty, int price)
	{	
		super();
		this.partNo_M = partNo;
		this.description_M = description;
		this.quantity_M = qty;
		this.price_M = price;
	}

	/**
	 * retrieve the partNo
	 * @return String partNo
	 */
	public String partNo() {return this.partNo_M;}
	
	/**
	 * retrieve the description for this part
	 * @return String description
	 */
	public String description() {return this.description_M;}
	
	/**
	 * retrieve the quantity of this part
	 * @return int quantity
	 */
	public int quantity() {return this.quantity_M;}
	
	/**
	 * retreive the unit price for this part
	 * @return int price for one unit of this part
	 */
	public int price() {return this.price_M;}
	
}
