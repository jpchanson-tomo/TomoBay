package tomoBay.model.sql.framework.queryFactories;

import tomoBay.model.sql.framework.queryTypes.select.AbstractSelectQuery;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractSelectQueryFactory extends AbstractQueryFactory
{

	@Override
	public AbstractSelectQuery make();

}
