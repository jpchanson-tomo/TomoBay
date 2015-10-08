package openDMS.helpers.viewPresenterFactory;
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
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class ViewPresenterFactory
{
	/**Singleton instance variable**/
	private static final ViewPresenterFactory instance_M = new ViewPresenterFactory();
	/**enum to use for factory creation options**/
	public enum Select {ROOT, EBAY}
	/**map of enum constants to concrete factories**/
	Map<Select, AbstractViewPresenterFactory> factory_M;
	
	/**
	 * default constructor
	 */
	private ViewPresenterFactory()
	{
		super();
		factory_M = new HashMap<Select, AbstractViewPresenterFactory>();
		this.populateMap();
	}
	
	/**
	 * singleton instance method, returns an instance of this object.
	 * @return ViewPresenterFactory the singleton instance.
	 */
	public static ViewPresenterFactory instance()
	{return ViewPresenterFactory.instance_M;}
	
	/**
	 * creates a specific factory based on the string provided.
	 * @param factory string that is compared to enum values.
	 * @return AbstractViewPresenterFactory a concrete viewPresenterFactory
	 */
	public AbstractViewPresenterFactory getFactory(String factory)
	{return this.factory_M.get(ViewPresenterFactory.Select.valueOf(factory));}
	
	/**
	 * check to see if a factory type exists by comparing the string provided to the
	 * internal enum 'Select'
	 * @param factory the string to compare to the internal enum
	 * @return boolean true if the factory is a valid type, false otherwise.
	 */
	public boolean hasFactory(String factory)
	{
		if (factory == null) {return false;}
		else if (Select.valueOf(factory) != null) {return true;}
		else {return false;}
	}
	
	/**
	 * populate the internal map with viewPresenterFactories.
	 */
	private void populateMap()
	{
		this.factory_M.put(ViewPresenterFactory.Select.ROOT, new RootFactory());
		this.factory_M.put(ViewPresenterFactory.Select.EBAY, new EbayFactory());
	}
}
