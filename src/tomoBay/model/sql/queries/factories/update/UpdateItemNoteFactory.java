package tomoBay.model.sql.queries.factories.update;

import tomoBay.model.sql.framework.queryFactories.AbstractModifyQueryParamsFactory;
import tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams;
import tomoBay.model.sql.queries.concreteQueries.update.UpdateItemNote;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class UpdateItemNoteFactory implements AbstractModifyQueryParamsFactory
{
	/**
	 * default ctor
	 */
	public UpdateItemNoteFactory()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.queries.AbstractQueryFactory#make()
	 */
	@Override
	public AbstractModifyQueryParams make()
	{
		return new UpdateItemNote();
	}

}
