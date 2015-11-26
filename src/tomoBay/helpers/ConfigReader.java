package tomoBay.helpers;

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
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 * naive config file reader. takes individual lines of a file and converts it to an array of 
 * strings. 
 * @author Jan P.C. Hanson
 *
 */
public class ConfigReader
{
	/**
	 * Ddefault ctor
	 */
	public ConfigReader()
	{super();}
	/**
	 * reads a config file and passes back an list of strings representing different lines 
	 * in the config file specified. It is important when constructing config files to put the
	 * correct setting on the correct line. line 1 = sandbox server string, 
	 * line 2 = sandbox user token, line 3 = production server string, 
	 * line 4 = production user token.
	 * @param pathToFile the path to the file including the trailing slash
	 * @param fileName the actual filename
	 * @return List<String> containing the various lines of the config file.
	 * String[0] = blank, String[1] = sandbox server string, String[2] = sandbox user token 
	 * String[3] = production server string, String[4] = production user token.
	 */
	public static String[] read(String pathToFile, String fileName)
	{		
		String[] tmp = ConfigReader.convert(pathToFile, fileName, "UTF-8").split("#");
		
		return tmp;
	}
	
	private static String convert(String filePath, String fileName, String charSet)
	{
		Charset charset = Charset.forName(charSet);
		Path file = FileSystems.getDefault().getPath(filePath, fileName);
		String result ="";
		
		try(BufferedReader reader = Files.newBufferedReader(file, charset))
		{
			String line = null;
			while((line = reader.readLine()) != null)
			{result +=line;}
		}
		
		catch (IOException ioe)
		{}
		return result;
	}
}
