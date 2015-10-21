package openDMS.presenters.factories;
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
import openDMS.presenters.error.ErrorPresenter;
import openDMS.presenters.AbstractPresenter;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ErrorPresenterFactory implements AbstractPresenterFactory
{
	/**
	 * default constructor
	 */
	public ErrorPresenterFactory()
	{super();}
	/* (non-Javadoc)
	 * @see openDMS.presenters.factories.AbstractPresenterFactory#make()
	 */
	@Override
	public AbstractPresenter make()
	{
		return new ErrorPresenter();
	}

}
