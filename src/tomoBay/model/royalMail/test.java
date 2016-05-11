package tomoBay.model.royalMail;

import java.io.IOException;

import tomoBay.helpers.Config;
import tomoBay.helpers.ConfigReader;

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
 *
 * @author Jan P.C. Hanson
 *
 */
public class test
{
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		RoyalMailCSVGenerator rm = new RoyalMailCSVGenerator();
		rm.addRow(new String[] 
						{
							"SR1",
							"48",
							" jan bob hanson-baloon",
							"2 lexington apartements",
							"Railway terrace",
							"sl2 5gq",
							"Slough",
							"GB",
							"C123456",
							"1",
							"300",
							"SF",
							"P"
						}
					);
		rm.addRow(new String[] 
				{
					"SR1",
					"48",
					" jan bob hanson-baloon",
					"2 lexington apartements",
					"",
					"sl2 5gq",
					"Slough",
					"GB",
					"C123456",
					"1",
					"300",
					"",
					"L"
				}
			);
		rm.addRow(new String[] 
				{
					"SR1",
					"48",
					" jan bob hanson-baloon",
					"2 lexington apartements",
					"Railway terrace",
					"sl2 5gq",
					"Slough",
					"GB",
					"C123456",
					"1",
					"300",
					"SF",
					"P"
				}
			);
		System.out.println(rm.toString());
		rm.generate("RoyalMail.CSV", "./logs/", "UTF-8");
	}

}
