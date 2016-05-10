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
 * This class is the abstract base for the True and False objects. These derived AbstractTruth objects
 * perform the double dispatch necessary to chose the code to execute dependant on the outcome of the
 * Condition evaluation.
 * 
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
interface AbstractTruth
{
	/**
	 * dispatch method allows the use of double dispatch to chose the code to execute dependent on the
	 * outcome of the Condition evaluation. 
	 * Derived types use \code result.result(this) \endcode to perform this dispatch
	 * @param result Parameterised result object
	 * @return T the result value of type T defined in the parameterised Result object.
	 */
	<T> T dispatch(Result<T> result);
}
