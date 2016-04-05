package tomoBay.model.dataTypes.conditionalStatement;

import gnu.trove.map.hash.THashMap;

import java.util.Map;
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
public abstract class Condition
{
	/**truth table map, mapping boolean true/false values to AbstractTruth True/False objects**/
	private static final Map<Boolean, AbstractTruth> TRUTH_TABLE 
																				= new THashMap<Boolean, AbstractTruth>()
	{{
		put(true, new True());
		put(false, new False());
	}};
	
	/**
	 * default ctor
	 */
	public Condition()
	{super();}
	
	/**
	 * evaluate this condition and provide an AbstractTruth result
	 * @return AbstractTruth representing a true or false.
	 */
	public AbstractTruth evaluate() 
	{return Condition.TRUTH_TABLE.get(this.expression());}
	
	/**
	 * the expression to be evaluated (Implemented by child objects)
	 * @return boolean (used by evaluate() method)
	 */
	protected abstract boolean expression();
}
