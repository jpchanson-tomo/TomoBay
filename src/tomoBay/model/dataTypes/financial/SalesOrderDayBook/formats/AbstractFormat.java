package tomoBay.model.dataTypes.financial.SalesOrderDayBook.formats;

import tomoBay.model.dataTypes.DualList;
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
import tomoBay.model.dataTypes.financial.SalesOrderDayBook.AbstractSalesDayBookLine;
import tomoBay.model.winstock.payloads.PayloadType;

/**
 * This class represents the abstract base class for a family of objects that format an 
 * AbstractSalesDayBookLine into a form that can be used in a variety of situations
 * 
 * @author Jan P.C. Hanson
 *
 */
public abstract class AbstractFormat
{
	/**
	 * default ctor
	 */
	public AbstractFormat()
	{super();}
	
	public abstract DualList<String ,PayloadType> format(AbstractSalesDayBookLine line);
}
