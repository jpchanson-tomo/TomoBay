package tomoBay.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tomoBay.presenters.AbstractPresenter;
import tomoBay.presenters.PresenterFactory;
/**
 * This class represents the Data servlet that the webApp can query for a particular presenter
 * which will in turn provide dynamic data specific to the particular presenter requested i.e.
 * for a specific area of the app.
 * @author Jan P.C. Hanson
 *
 */
public class DataServlet extends HttpServlet
{	
	/**needed to avoid warnings**/
	private static final long serialVersionUID = -417534770555839323L;
	
	/**
	 * default ctor
	 */
	public DataServlet()
	{super();}

	/**
	 * service method, this controls how the servlet responds to particular URL query strings
	 * @param request the http request to the servlet
	 * @param response the http response to the servlet
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		System.out.println(request.getHeader("referer"));
		Cookie c = new Cookie("test", "testing 123");
		c.setMaxAge(60*60);
		c.setHttpOnly(true);
		c.setSecure(true);
		response.addCookie(c);
		
		
		PrintWriter out = response.getWriter();
		String data = request.getParameter("data");
		String type = request.getParameter("type");
		String page = request.getParameter("page");
		ViewFactory viewFactory = new ViewFactory();
		
		AbstractPresenter presenter = PresenterFactory.make(page);
		AbstractView view = presenter.accept(viewFactory);
		
		out.print(presenter.present(view, type, data));
		
		out.close();
	}
}
