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
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/**
 * This class parses an XML file and returns a string specific to the tag requested.
 * @author Jan P.C. Hanson
 *
 */
public class XMLParser
{
	/**
	 * parses an XML formatted string looking for the first tag specified in the parameters.
	 * @param tag the name of the tag (not including angle brackets)
	 * @param stringToParse the XML formatted string to parse for the tag specified
	 * @return String containing the text inside the XML tag specified
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public static String parse(String tag, String stringToParse)
	{
		try
		{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();

			src.setCharacterStream(new StringReader(stringToParse));

			Document doc = builder.parse(src);
			String tagContent = doc.getElementsByTagName(tag).item(0).getTextContent();
			return tagContent.trim();
		}
		catch(SAXException saxE)
		{return "XML Parser Error: "+saxE.getMessage();}
		catch(ParserConfigurationException | IOException e)
		{return "Internal Error" + e.getMessage();}
		catch(NullPointerException ne)
		{return "<" + tag + ">..." + "</" + tag + ">" + " not found";}
	}
	
	/**
	 * returns a NodeList containing all the nodes that have the specified tag name
	 * @param tag the tag to search for within the string provided
	 * @param stringToParse The string to search for specific tags in.
	 * @return NodeList containing all the tags that match the search term.
	 */
	public static NodeList parseAll(String tag, String stringToParse)
	{
		try
		{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();

			src.setCharacterStream(new StringReader(stringToParse));

			Document doc = builder.parse(src);
			NodeList tagContent = doc.getElementsByTagName(tag);
			return tagContent;
		}
		catch(SAXException saxE)
		{saxE.printStackTrace();}
		catch(ParserConfigurationException | IOException e)
		{e.printStackTrace();}
		catch(NullPointerException ne)
		{ne.printStackTrace();}
		return null;
	}
}
