package tomoBay.presenters.error;

import tomoBay.presenters.AbstractPresenter;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ErrorPresenter implements AbstractPresenter
{

	/* (non-Javadoc)
	 * @see openDMS.presenters.AbstractPresenter#present()
	 */
	@Override
	public String present()
	{
		return "<h1>You have requested data that doesnt exist</h1>"
				+ "<p>check the spelling of your query string parameter</p>";
	}

}
