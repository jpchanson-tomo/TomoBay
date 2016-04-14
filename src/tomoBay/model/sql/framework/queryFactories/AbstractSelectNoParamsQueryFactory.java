package tomoBay.model.sql.framework.queryFactories;

import tomoBay.model.sql.framework.queryTypes.select.AbstractSelectNoParamsQuery;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractSelectNoParamsQueryFactory extends AbstractSelectQueryFactory
{

	@Override
	public AbstractSelectNoParamsQuery make();

}
