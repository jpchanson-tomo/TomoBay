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
import java.net.MalformedURLException;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.resource.Resource;
/**
 * 
 * @author Jan P.C. Hanson
 *
 */
public class HttpServer
{
	/**
	 * default ctor
	 */
	public HttpServer()
	{super();}
	
	/**
	 * 
	 * @param port
	 * @return
	 * @throws MalformedURLException 
	 */
	public void start(int port) throws MalformedURLException
    {
		Server server = new Server();
		ServerConnector connector = new ServerConnector(server);
		connector.setPort(port);
		//set up context handlers
		ContextHandler context0 = setUpServletHandler();
		ContextHandler context1 = setUpGuiHandler();
		//add handlers to collection
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new Handler[] { context1, context0});
		//give handler collection to server
		server.setHandler(contexts);
		server.setConnectors(new Connector[] {connector});
		
        try
        {
        	server.start();
        	server.join();
        }
        catch(InterruptedException ie)
        {
        	ie.printStackTrace();
        }
        
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
	
	/**
     * do setup for the servlet handler
     * @return ContextHandler for the servlet
     */
    private static ContextHandler setUpServletHandler()
    {
    	ContextHandler context0 = new ContextHandler();
		context0.setContextPath("/");        
		ServletContextHandler serv = new ServletContextHandler();
		serv.addServlet(UIServlet.class, "/*");
		context0.setHandler(serv);
		return context0;
    }
    
    /**
     * do setup for the static resource handler
     * @return ContextHandler for the static resource handler
     */
    private static ContextHandler setUpGuiHandler() throws MalformedURLException
    {
    	ContextHandler context1 = new ContextHandler();
		context1.setContextPath("/res");        
		ResourceHandler res = new ResourceHandler();
		res.setBaseResource(Resource.newResource("./res/"));
		context1.setHandler(res);
		return context1;
    }
}
