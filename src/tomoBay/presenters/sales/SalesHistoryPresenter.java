package tomoBay.presenters.sales;

import java.util.List;

import tomoBay.helpers.SortOrders;
import tomoBay.model.sql.queries.QueryInvoker;
import tomoBay.presenters.AbstractPresenter;
import tomoBay.view.AbstractView;
import tomoBay.view.ViewFactory;
/**
 * This class represents the History presenter of the Sales area of the WebApp.
 * @author Jan P.C. Hanson
 *
 */
public class SalesHistoryPresenter implements AbstractPresenter
{
	/**
	 * default ctor
	 */
	public SalesHistoryPresenter()
	{super();}

	/* (non-Javadoc)
	 * @see openDMS.presenters.AbstractPresenter#present()
	 */
	@Override
	public String present(AbstractView view, String type, String data)
	{
		String output = "";
		List<String[]> rows = QueryInvoker.execute
				(QueryInvoker.QueryType.SELECT_INVOICED_ORDERS,new String[] {""});
		
		output += view.format(rows);
		
		return output;
	}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#accept(tomoBay.view.ViewFactory)
	 */
	@Override
	public AbstractView accept(ViewFactory viewFactory)
	{return viewFactory.visit(this);}

}
