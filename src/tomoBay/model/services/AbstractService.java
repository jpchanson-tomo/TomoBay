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

/**
 * Convienience interface, allows the system to only accept runnable's that implement this
 * interface rather than all runnables.
 * @author Jan P.C. Hanson
 *
 */
public interface AbstractService extends Runnable
{
	/**
	 * The individual services equivalent of main
	 */
	public void run();
	
	/**
	 * sets the configuration for this service. Not all services require configuration, see the
	 * documentation for individual services.
	 * @param config the AbstractConfiguration concrete object applicable to the concrete service.
	 */
	public <E> void setConfig(AbstractConfiguration<E> config);
}
