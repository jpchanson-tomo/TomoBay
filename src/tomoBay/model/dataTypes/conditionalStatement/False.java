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
 * This class represents a False outcome to a Condition object, its dispatch() method calls the 
 * appropriate code in the Result object.
 * 
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public final class False implements AbstractTruth
{
	/**
	 * default ctor
	 */
	public False()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.conditionalStatement.AbstractTruth#dispatch(tomoBay.model.dataTypes.conditionalStatement.Result)
	 */
	public <T> T dispatch(Result<T> result)
	{return result.result(this);}
}
