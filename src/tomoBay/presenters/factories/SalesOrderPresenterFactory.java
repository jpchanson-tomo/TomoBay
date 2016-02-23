package tomoBay.presenters.factories;
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
import tomoBay.presenters.AbstractPresenter;
import tomoBay.presenters.sales.SalesOrderPresenter;
/**
 * This class is creates an SalesOrderPresenter object
 * @see {@link tomoBay.presenters.sales.SalesOrderPresenter}
 * @author Jan P.C. Hanson
 *
 */
public final class SalesOrderPresenterFactory implements AbstractPresenterFactory
{
	/**
	 * default constructor
	 */
	public SalesOrderPresenterFactory()
	{super();}
	/* (non-Javadoc)
	 * @see openDMS.presenters.factories.AbstractEbayPresenterFactory#make()
	 */
	@Override
	public AbstractPresenter make()
	{return new SalesOrderPresenter();}
}