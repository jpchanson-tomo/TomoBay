package tomoBay.model.dataTypes.conditionalStatement;
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
 * This class attempts to represent conditional statements in an object oriented manner. A Condition
 * object is evaluated and depending on whether the Condition evaluates to true or false the Result
 * object invokes the appropriate code
 * @author Jan P.C. Hanson
 *
 */
public abstract class Conditional<T>
{
	/**
	 * default ctor
	 */
	public Conditional()
	{super();}
	
	/**
	 * 
	 * @return
	 */
	public T evaluate()
	{return this.startCondition().evaluate().dispatch(this.startResult());}
	
	/**
	 * 
	 * @param condition
	 * @param result
	 * @return
	 */
	public T evaluate(Condition condition, Result<T> result)
	{return condition.evaluate().dispatch(result);}
	
	/**
	 * @return
	 */
	public abstract Condition startCondition();
	
	/**
	 * @return
	 */
	public abstract Result<T> startResult();
}
