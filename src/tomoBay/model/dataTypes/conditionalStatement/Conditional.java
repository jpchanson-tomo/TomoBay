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
import tomoBay.helpers.NoImports;
/**
 * This class attempts to represent conditional statements in an object oriented manner. A Condition
 * object is evaluated and depending on whether the Condition evaluates to true or false the appropriate
 * code in the Result object is invoked (using double dispatch).
 * 
 * Two evaluate methods are defined here: evaluate() and evaluate(Condition condition, Result<T> result);
 * which is to be used depends on how you wish to use these constructs. The parameterless evaluate()
 * method is provided in the case where you need to define a particular start condition and chain 
 * conditional statements, much like a nested if-then-else statement. The evaluate(Condition condition, Result<T> result)
 * is provided in the case where a simple if-else statement is needed.
 * 
 * @see tomoBay.model.dataTypes.conditionalStatement
 * 
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public abstract class Conditional<T>
{
	/**
	 * default ctor
	 */
	public Conditional()
	{super();}
	
	/**
	 * Evaluate the start condition inherent to this conditional (if it exists).
	 * @return
	 */
	public T evaluate()
	{return this.startCondition().evaluate().dispatch(this.startResult());}
	
	/**
	 * evaluate this conditional based on the Condition and Result objects passed as parameters to 
	 * this method
	 * @param condition the Condition object that should be evaluated.
	 * @param result the Result object that contains the behaviour to invoke for this conditional.
	 * @return T as defined when instantiating this Conditional object.
	 */
	public T evaluate(Condition condition, Result<T> result)
	{return condition.evaluate().dispatch(result);}
	
	/**
	 * This method can be used by derived classes to define a start condition in the event that a 
	 * 'chain of responsibility' style conditional is needed (analogous to a nested if-then-else)
	 * @return Condition object representing the start condition (first handler)
	 */
	public abstract Condition startCondition();
	
	/**
	 * This method can be used by derived classes to define the behaviour that the start condition 
	 * should invoke.
	 * @return Result object representing the startCondition behaviours (dependant on the evaluation
	 * of the Condition object).
	 */
	public abstract Result<T> startResult();
}
