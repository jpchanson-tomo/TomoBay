package tomoBay.model.sql.queries.factories.update;

import tomoBay.model.sql.queries.AbstractModifyQuery;
import tomoBay.model.sql.queries.AbstractModifyQueryFactory;
import tomoBay.model.sql.queries.concreteQueries.update.UpdateItemNote;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class UpdateItemNoteFactory implements AbstractModifyQueryFactory
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
	public AbstractModifyQuery make()
	{
		return new UpdateItemNote();
	}

}
