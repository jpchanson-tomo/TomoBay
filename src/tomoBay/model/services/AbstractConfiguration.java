package tomoBay.model.services;
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
import tomoBay.helpers.NoImports;
/**
 * This interface defines the form that every configuration object used to provide information
 * to particular services should conform to.<br>
 * 
 * ***Using a Configuration Object***<br>
 * 
 * 
 * 
 * ***Writing a Configuration Object***<br>
 *
 *
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public interface AbstractConfiguration<T>
{
	/**
	 * used to set the configuration information for the service.
	 * @param value
	 */
	public AbstractConfiguration<T> configure(T value);
	
	/**
	 * used by the service to retrieve the information necessary for the service to configure
	 * itself.
	 * @return
	 */
	public T configure();
}
