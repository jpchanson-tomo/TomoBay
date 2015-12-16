package tomoBay.model.services.factories;

import tomoBay.model.services.AbstractService;
import tomoBay.model.services.checkErrorsService.CheckErrorsService;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class CheckErrorsFactory implements AbstractServiceFactory
{
	/**
	 * default ctor
	 */
	public CheckErrorsFactory()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.factories.AbstractServiceFactory#make()
	 */
	@Override
	public AbstractService make()
	{
		return new CheckErrorsService();
	}

}
