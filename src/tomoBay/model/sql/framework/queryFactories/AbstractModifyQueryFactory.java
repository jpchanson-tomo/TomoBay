package tomoBay.model.sql.framework.queryFactories;

import tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQuery;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractModifyQueryFactory extends AbstractQueryFactory
{
	/* (non-Javadoc)
	 * @see tomoBay.model.sql.framework.queryFactories.AbstractQueryFactory#make()
	 */
	@Override
	public AbstractModifyQuery make();
}
