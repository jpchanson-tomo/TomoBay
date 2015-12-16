package tomoBay.model.services.individualItemRefreshService;
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
import tomoBay.model.services.AbstractConfiguration;
/**
 * This class defines an object that is passed to the IndividualItemRefreshService setConfig
 * method. it provides the information necessary for the service to perform its task. in this
 * case the listing id.
 * @author Jan P.C. Hanson
 *
 *
 */
public class IndividualItemRefreshConfig implements AbstractConfiguration<Long>
{
	private long listingID_M;
	
	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractConfiguration#configure(java.lang.Object)
	 */
	@Override
	public AbstractConfiguration<Long> configure(Long value)
	{
		this.listingID_M = value;
		return this;
	}

	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractConfiguration#configure()
	 */
	@Override
	public Long configure()
	{
		return this.listingID_M;
	}
}
