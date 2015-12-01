package tomoBay.presenters.sales;

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
	public String present(AbstractView view)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#accept(tomoBay.view.ViewFactory)
	 */
	@Override
	public AbstractView accept(ViewFactory viewFactory)
	{return viewFactory.visit(this);}

}
