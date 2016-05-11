package tomoBay.model.royalMail;
import java.io.IOException;

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
 * This is the public interface for all CSV generator derived classes and defines the necessary
 * functionality that a concrete CSV generator should implement.
 * 
 * Each subclass should define for itself the number of columns and their respective meanings.
 * 
 * @author Jan P.C. Hanson
 *
 */
@SuppressWarnings("unused")
public interface CSVGenerator
{	
	/**
	 * set the separators to use when constructing the CSV. This method should be called before the
	 * generate() method is called should you wish to set custom separators. If this method is not
	 * called then the separators should default to the form  , , , , ,
	 * @param separator the character used to separate entries
	 * @param entryIndicator the character used to indicate an entry.
	 */
	public abstract void setseparators(char separator, char entryIndicator);
	
	/**
	 * This method adds a rows worth of data to the CSV to be generated. Empty columns should be included.
	 * as this method expects an array of the correct size as defined by the size() method.
	 * @param row an array of Strings with each element representing a specific column.
	 * @throws ArrayIndexOutOfBoundsException indicating that the array is too small or too large.
	 */
	public abstract void addRow(String[] row) throws ArrayIndexOutOfBoundsException;
	
	/**
	 * Generates the CSV file in the location specified in the parameters, and using the encoding 
	 * provided. If the encoding parameter is left blank then it should default to utf-8.
	 * @param fileName the name of the file to be generated
	 * @param filePath the path of the file to be generated
	 * @param encoding the encoding of the file to be generated
	 * @throws IOException 
	 */
	public abstract void generate(String fileName, String filePath, String encoding) throws IOException;
	
	/**
	 * indicates how many columns are required for each row of this CSV.
	 * @return int representing the number of columns.
	 */
	public abstract int size();
	
	/**
	 * informative String representation of the CSV file at the point in time where this method is 
	 * called. This method should print out the names of the columns as the first line, followed by
	 * the values of each of those columns in a given row.
	 * @return String representation of the CSV File in its current state.
	 */
	public abstract String toString();
}
