package tomoBay.model.sql.queries.factories.update;

import tomoBay.model.sql.queries.AbstractDBQuery;
import tomoBay.model.sql.queries.AbstractQueryFactory;
import tomoBay.model.sql.queries.concreteQueries.update.UpdateItemNote;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class UpdateItemNoteFactory implements AbstractQueryFactory
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
	public AbstractDBQuery make()
	{
		return new UpdateItemNote();
	}

}
