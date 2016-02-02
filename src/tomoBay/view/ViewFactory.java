package tomoBay.view;
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
import tomoBay.presenters.admin.AdminPresenter;
import tomoBay.presenters.error.ErrorPresenter;
import tomoBay.presenters.orderDetails.OrderDetailsPresenter;
import tomoBay.presenters.root.RootPresenter;
import tomoBay.presenters.sales.OutOfHoursPresenter;
import tomoBay.presenters.sales.SalesHistoryPresenter;
import tomoBay.presenters.sales.SalesOrderPresenter;
import tomoBay.presenters.warehouse.WarehouseOrderPresenter;
import tomoBay.view.views.AdminServiceView;
import tomoBay.view.views.ErrorView;
import tomoBay.view.views.OrderView;
import tomoBay.view.views.OutOfHoursView;
import tomoBay.view.views.RootView;
import tomoBay.view.views.SalesHistoryView;
import tomoBay.view.views.SalesOrderView;
import tomoBay.view.views.WarehouseOrderView;
/**
 * This class is the visitor in a visitor/double dispatch type setup where the AbstractPresenter
 * concrete classes are the visitables and contain the corresponding accept() methods. This 
 * visitor acts as a view factory allowing the presenters to be responsible for the creation of
 * their own views.
 * 
 * @author Jan P.C. Hanson
 *
 */
public class ViewFactory
{
	/**
	 * factory method for ErrorView
	 * @param presenter a valid ErrorPresenter
	 * @return ErrorView
	 */
	public AbstractView visit(ErrorPresenter presenter)
	{return new ErrorView();}
	
	/**
	 * factory method for the RootView
	 * @param presenter a valid RootPresenter
	 * @return RootView
	 */
	public AbstractView visit(RootPresenter presenter)
	{return new RootView();}
	
	/**
	 * factory method for the SalesHistoryView
	 * @param presenter a valid SalesHistoryPresenter
	 * @return SalesHistoryView
	 */
	public AbstractView visit(SalesHistoryPresenter presenter)
	{return new SalesHistoryView();}
	
	/**
	 * factory method for the SalesOrderView
	 * @param presenter a valid SalesOrderPresenter
	 * @return SalesOrderView
	 */
	public AbstractView visit(SalesOrderPresenter presenter)
	{return new SalesOrderView();}
	
	/**
	 * factory method for the SalesOrderView
	 * @param presenter a valid WarehouseOrderPresenter
	 * @return WarehouseOrderView
	 */
	public AbstractView visit(WarehouseOrderPresenter presenter)
	{return new WarehouseOrderView();}

	/**
	 * @param orderDetailsPresenter
	 * @return
	 */
	public AbstractView visit(OrderDetailsPresenter orderDetailsPresenter)
	{return new OrderView();}
	
	/**
	 * 
	 * @param adminPresenter
	 * @return
	 */
	public AbstractView visit(AdminPresenter adminPresenter)
	{return new AdminServiceView();}
	
	/**
	 * 
	 * @param outOfHoursPresenter
	 * @return
	 */
	public AbstractView visit(OutOfHoursPresenter outOfHoursPresenter)
	{return new OutOfHoursView();}

}