package tomoBay.model.sql.framework.queryFactories;

import tomoBay.model.sql.framework.queryTypes.select.AbstractSelectParamsQuery;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractSelectParamsQueryFactory extends AbstractQueryFactory
{

	@Override
	public AbstractSelectParamsQuery make();

}
