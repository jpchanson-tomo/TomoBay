package openDMS.model.sql.queries.factories;

import openDMS.model.sql.queries.AbstractDBQuery;
import openDMS.model.sql.queries.AbstractQueryFactory;
import openDMS.model.sql.queries.concreteQueries.InsertEbayItems;

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