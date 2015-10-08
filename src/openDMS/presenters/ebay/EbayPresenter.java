package openDMS.presenters.ebay;
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
import openDMS.presenters.AbstractPresenter;
import openDMS.view.views.AbstractView;
import openDMS.view.views.EbayView;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class EbayPresenter implements AbstractPresenter
{
	
	/* (non-Javadoc)
	 * @see openDMS.presenters.AbstractPresenter#present(openDMS.view.views.AbstractView)
	 */
	@Override
	public String present(AbstractView view)
	{
		String output = "";
		
		output += view.make(EbayView.Part.HEADER);
		output += this.doStuff();
		output += view.make(EbayView.Part.FOOTER);
		
		return output;
	}

	private String doStuff() {return "stuff";}
}
