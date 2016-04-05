package tomoBay.presenters.helpers.pickeability;
/** Copyright(C) 2015 Jan P.C. Hanson & Tomo Motor Parts Limited
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import tomoBay.model.dataTypes.conditionalStatement.Condition;
import tomoBay.model.dataTypes.conditionalStatement.Conditional;
import tomoBay.model.dataTypes.conditionalStatement.False;
import tomoBay.model.dataTypes.conditionalStatement.Result;
import tomoBay.model.dataTypes.conditionalStatement.True;

import java.util.Set;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class AllPickeableResult extends Result<PickeableStatus>
{
	private final Set<Boolean> itemStatus_M;
	private final String orderNo_M;
	private final Conditional<PickeableStatus> nextHandler_M;
	
	public AllPickeableResult(Set<Boolean> itemStatus, String orderNo, Conditional<PickeableStatus> nextHandler)
	{
		super();
		this.itemStatus_M=itemStatus;
		this.orderNo_M = orderNo;
		this.nextHandler_M = nextHandler;
	}
	
	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.conditionalStatement.Result#result(tomoBay.model.dataTypes.conditionalStatement.True)
	 */
	@Override
	public PickeableStatus result(True yes)
	{return PickeableStatus.PICKEABLE;}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.conditionalStatement.Result#result(tomoBay.model.dataTypes.conditionalStatement.False)
	 */
	@Override
	public PickeableStatus result(False no)
	{
		Condition nextCondition = new UnPickeable(this.itemStatus_M);
		Result<PickeableStatus> nextResult = new UnPickeableResult(this.itemStatus_M, 
																						this.orderNo_M, 
																						this.nextHandler_M);
		return this.nextHandler_M.evaluate(nextCondition, nextResult);
	}

}
