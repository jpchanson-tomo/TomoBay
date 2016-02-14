package tomoBay.presenters.presenterActions;

import java.util.HashSet;
import java.util.Set;
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
public class AllowedPresenterActions
{
	/**the set of allowed actions that can be performed**/
	private Set<PresenterActionFactory.PresenterActions> allowedActions_M;
	
	/**
	 * constructor, initialised the AllowedActions
	 */
	public AllowedPresenterActions()
	{
		super();
		allowedActions_M = new HashSet<PresenterActionFactory.PresenterActions>();
	}

	/**
	 * add an AbstractPresenterAction to the set of allowed actions.
	 * @param action the PresenterActionFactory.PresenterActions representing an 
	 * AbstractPresenterAction
	 * @return true iff action was not already in set, false if action IS already in set.
	 */
	public boolean add(PresenterActionFactory.PresenterActions action)
	{
		if(this.allowedActions_M.contains(action)==true) {return false;}
		else 
		{
			this.allowedActions_M.add(action);
			return true;
		}
	}
	
	/**
	 * tells the user of this class whether the action provided via arguments is in the set of
	 * allowed actions or not
	 * @param action the PresenterActionFactory.PresenterActions representing an 
	 * AbstractPresenterAction
	 * @return true iff action is in list, false if it is not.
	 */
	public boolean isAllowed(PresenterActionFactory.PresenterActions action)
	{return this.allowedActions_M.contains(action);}
}
