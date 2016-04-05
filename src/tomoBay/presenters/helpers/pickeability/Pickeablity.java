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
import java.util.Set;

import tomoBay.model.dataTypes.conditionalStatement.Condition;
import tomoBay.model.dataTypes.conditionalStatement.Conditional;
import tomoBay.model.dataTypes.conditionalStatement.Result;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class Pickeablity extends Conditional<PickeableStatus>
{
	private final Set<Boolean> itemStatus_M;
	private final String orderNo_M;
	
	/**
	 * default ctor
	 */
	public Pickeablity(String orderNo)
	{
		super();
		this.orderNo_M = orderNo;
		this.itemStatus_M = ItemStockLevel.check(orderNo);
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.conditionalStatement.Conditional#startCondition()
	 */
	@Override
	public Condition startCondition()
	{return new Error(this.itemStatus_M);}

	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.conditionalStatement.Conditional#startResult()
	 */
	@Override
	public Result<PickeableStatus> startResult()
	{return new ErrorResult(this.itemStatus_M, this.orderNo_M, this);}
}