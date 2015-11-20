package tomoBay.model.sql.queries.factories;

import tomoBay.model.sql.queries.AbstractDBQuery;
import tomoBay.model.sql.queries.AbstractQueryFactory;
import tomoBay.model.sql.queries.concreteQueries.SelectEbayItems;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class SelectEbayItemsFactory implements AbstractQueryFactory
{
	/**
	 * default ctor
	 */
	public SelectEbayItemsFactory()
	{super();}
	
	/**
	 * make the query
	 * @return the query
	 */
	public AbstractDBQuery make()
	{return new SelectEbayItems();}
}
