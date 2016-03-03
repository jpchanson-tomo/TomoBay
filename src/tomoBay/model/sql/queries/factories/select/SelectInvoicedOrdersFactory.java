package tomoBay.model.sql.queries.factories.select;

import tomoBay.model.sql.queries.AbstractDBQuery;
import tomoBay.model.sql.queries.AbstractQueryFactory;
import tomoBay.model.sql.queries.concreteQueries.select.SelectInvoicedOrders;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class SelectInvoicedOrdersFactory implements AbstractQueryFactory
{

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.queries.AbstractQueryFactory#make()
	 */
	@Override
	public AbstractDBQuery make()
	{
		return new SelectInvoicedOrders();
	}

}
