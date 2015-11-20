package tomoBay.model.sql.queries.factories;

import tomoBay.model.sql.queries.AbstractDBQuery;
import tomoBay.model.sql.queries.AbstractQueryFactory;
import tomoBay.model.sql.queries.concreteQueries.InsertEbayItems;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class InsertEbayItemsFactory implements AbstractQueryFactory
{
	/**
	 * default ctor
	 */
	public InsertEbayItemsFactory()
	{super();}
	
	/**
	 * make the query
	 * @return the query
	 */
	public AbstractDBQuery make()
	{return new InsertEbayItems();}
}