package tomoBay.presenters.presenterActions;
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
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import org.apache.log4j.Logger;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public class LogFileViewer implements AbstractPresenterAction
{
	static Logger log = Logger.getLogger(LogFileViewer.class.getName());
	
	/**
	 * 
	 */
	public LogFileViewer()
	{super();}
	
	/**
	 * 
	 */
	public String execute(String data)
	{
		try{return this.removeLastComma(new String(Files.readAllBytes(Paths.get("logs/tomoBay.log"))));} 
		catch (IOException e){log.error("could not process log file", e);}
		return "could not process log file";
	}
	
	/**
	 * 
	 * @param string
	 * @return
	 */
	private String removeLastComma(String string)
	{
		int index = string.lastIndexOf(",");
		if (index == -1){return string;}
		return string.substring(0, index) + ""+ string.substring(index+",".length());
	}
}
