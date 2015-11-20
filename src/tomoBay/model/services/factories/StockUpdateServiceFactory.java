package tomoBay.model.services.factories;
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
import tomoBay.model.services.AbstractService;
import tomoBay.model.services.stockUpdate.StockUpdateService;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class StockUpdateServiceFactory implements AbstractServiceFactory
{
	/**
	 * default ctor
	 */
	public StockUpdateServiceFactory()
	{super();}

	/* (non-Javadoc)
	 * @see openDMS.model.services.factories.AbstractServiceFactory#make()
	 */
	@Override
	public AbstractService make()
	{return new StockUpdateService();}
}
