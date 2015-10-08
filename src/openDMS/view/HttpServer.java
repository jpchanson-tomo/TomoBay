package openDMS.view;
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
import java.util.Map;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
/**
 * 
 * @author Jan P.C. Hanson
 *
 */
public class HttpServer
{
	public static void main( String[] args ) throws Exception
    {
        Server server = new Server(Integer.parseInt(args[0]));
 
        ServletContextHandler context = new ServletContextHandler();
        server.setHandler(context);

        UIViews uiViews = new UIViews();
        Map<String, String> views = uiViews.createViews();
        UIServlet dataServlet = new UIServlet(views);
        
        // Add default servlet
        context.addServlet(new ServletHolder(dataServlet), "/*");

        server.start();
        server.join();
    }
}
