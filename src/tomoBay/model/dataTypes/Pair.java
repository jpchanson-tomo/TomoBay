package tomoBay.model.dataTypes;
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
 * This class represents a pair of values of type <X,Y> 
 * @author Jan P.C. Hanson
 *
 */
public class Pair<X,Y>
{
	/**the x-value of this pair**/
	private X xValue_M;
	/**the y-value of this pair**/
	private Y yValue_M;
	
	/**
	 * Instantiates the pair with the x and y values provided, where x is of type <X> and y is of 
	 * type <Y>
	 * @param xVal <X> the x-value of this pair
	 * @param yVal <Y> the y-value of this pair
	 */
	public Pair(X xVal, Y yVal)
	{
		super();
		this.xValue_M = xVal;
		this.yValue_M = yVal;
	}

	/**
	 * retrieve the x-value
	 * @return <X> the value of x
	 */
	public X xVal() {return this.xValue_M;}
	
	/**
	 * set the x-value
	 * @param value <X> representing the value to set
	 */
	public void xVal(X value) {this.xValue_M = value;}
	
	/**
	 * retrieve the y-value
	 * @return <Y> the value of y
	 */
	public Y yVal() {return this.yValue_M;}
	
	/**
	 * set the y-value
	 * @param value <Y> representing the value to set  
	 */
	public void yVal(Y value) {this.yValue_M = value;}
	
}
