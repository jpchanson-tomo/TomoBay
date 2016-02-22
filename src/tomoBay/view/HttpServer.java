package tomoBay.view;
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
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.ssl.SslContextFactory;
/**
 * This class defines the setup of the Jetty embedded http server, servlets, resources, security
 * and many other features can be introduced from here.
 * 
 * the server operates on a port specified as a command line argument.
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
	 * This starts the http servlet with 2 context handler: 1 is a resource handler that is 
	 * responsible for providing access to the static html and the other is the DataServlet 
	 * which is what can be queried by the WebApp for specific presenters.
	 * @param port the port to run the server on
	 * @throws MalformedURLException 
	 */
	public void start(int port) throws MalformedURLException
    {
		Server server = new Server();
		
		//set up context handlers
		ContextHandler dataServlet = setUpDataServletHandler();
		ContextHandler guiHandler = setUpGuiHandler();
		ServerConnector connector = sslConnector(server, port);
		//add handlers to collection
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new Handler[] { guiHandler, dataServlet});
		//give handler collection to server
		server.setHandler(contexts);
		server.setConnectors(new Connector[] {connector});
		
        try{server.start();/**server.join();**/}
        
        catch(InterruptedException ie){ie.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
    }
	
	/**
	 * set up the ssl server connector
	 * @param server the server that this connector should connect to
	 * @param port the port that this connector should listen on
	 * @return ServerConnector the server connector
	 */
	private static ServerConnector sslConnector(Server server, int port)
	{
		HttpConfiguration https = new HttpConfiguration();
		https.addCustomizer(new SecureRequestCustomizer());
		https.setSendServerVersion(false);
		https.setSendXPoweredBy(false);
		SslContextFactory sslContextFactory = new SslContextFactory();
		sslContextFactory.setKeyStorePath("./keystore/keystore.jks");
		sslContextFactory.setKeyStorePassword("h4l1but3.14159_+-=");
		sslContextFactory.setKeyManagerPassword("h4l1but3.14159_+-=");
		ServerConnector sslConnector = new ServerConnector(server,
										new SslConnectionFactory(sslContextFactory, "http/1.1"),
										new HttpConnectionFactory(https));
		sslConnector.setPort(port);
		return sslConnector;
	}
	
	/**
     * do setup for the servlet handler
     * @return ContextHandler for the servlet
     */
    private static ContextHandler setUpDataServletHandler()
    {
    	ContextHandler context0 = new ContextHandler();
		context0.setContextPath("/");
		ServletContextHandler serv = new ServletContextHandler();
		serv.addServlet(DataServlet.class, "/res/*");
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
		context1.setContextPath("/");
		ResourceHandler res = new ResourceHandler();
		res.setBaseResource(Resource.newResource("./views/"));
		context1.setHandler(res);
		return context1;
    }
}
