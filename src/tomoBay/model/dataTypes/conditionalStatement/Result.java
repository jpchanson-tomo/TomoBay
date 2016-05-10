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
 * This class defines the Abstract Base class for all derived Result classes. By implementing this 
 * class the user can define the true and false behaviours by encapsulating them within the appropriate
 * methods(provided), the calling class (Conditional) will then invoke the correct behaviour when the
 * Condition object gets evaluated.
 *  
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public abstract class Result<T>
{
	
	/**
	 * default ctor
	 */
	public Result()
	{super();}
	
	/**
	 * This method defines the behaviour to invoke if the Condition object evaluates to True.
	 * @param yes
	 */
	public abstract T result(True yes);
	
	/**
	 * This method defines the behaviour to invoke if the Condition object evaluates to False.
	 * @param no
	 */
	public abstract T result(False no);
}
