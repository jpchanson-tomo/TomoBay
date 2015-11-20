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
 * This is a helper class that provides functionality to convert a text based file to a string.
 * @author Jan P.C. Hanson
 *
 */
public class FileToString
{
	/**
	 * this class should not be instanciated
	 */
	private FileToString()
	{super();}
	
	/**
	 * uses a buffered reader to read each line from a file into a string.
	 * @param filePath the path to a particular file
	 * @param fileName the name of the file to be read
	 * @param charSet the Character set to use for the conversion
	 * @return String containing the contents of the file.
	 */
	public static String convert(String filePath, String fileName, String charSet)
	{
		Charset charset = Charset.forName(charSet);
		Path file = FileSystems.getDefault().getPath(filePath, fileName);
		String result ="";
		
		try(BufferedReader reader = Files.newBufferedReader(file, charset))
		{
			String line = null;
			while((line = reader.readLine()) != null)
			{result += "\n" +line;}
		}
		
		catch (IOException ioe)
		{}
		return result;
	}
}
