package tomoBay.helpers;
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
/**
 * This Enum defines the hierarchy of shipping types.
 * @author Jan P.C. Hanson
 *
 */
public enum ShippingPriority
{
	UK_RoyalMailTracked(1),
	UK_OtherCourier24(2),
	UK_RoyalMail24(3),
	UK_RoyalMailFirstClassStandard(4),
	UK_RoyalMailSecondClassRecorded(5),
	UK_myHermesDoorToDoorService(6),
	UK_RoyalMailSecondClassStandard(7),
	UK_RoyalMail48(8),
	ShippingMethodStandard(9),
	UK_Parcelforce24(10),
	UK_Parcelforce48(11),
	UK_RoyalMailInternationalSignedFor(12),
	UK_RoyalMailAirsureInternational(13),
	UK_RoyalMailSurfaceMailInternational(14),
	InternationalPriorityShippingUK(15),
	OTHER(16);

	/**local holder for initialised **/
	private int priority;

	/**size of the enum**/
	private static final int size = ShippingPriority.values().length;
	
	/**
	 * private ctor so enum can hold int values
	 */
	private ShippingPriority(int priority)
	{this.priority = priority;}
	
	/**
	 * method to return the value held by enum.
	 * @return
	 */
	public int getPriority()
	{return this.priority;}
	
	/**
	 * gets the number of constants held in this enum
	 * @return integer denoting the size of the enum
	 */
	public static int size()
	{return ShippingPriority.size;}
}
