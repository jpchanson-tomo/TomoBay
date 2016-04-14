package tomoBay.model.sql.framework;
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
import java.sql.SQLException;

import tomoBay.model.dataTypes.heteroTypeContainer.AbstractField;
import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.framework.queryTypes.AbstractDBQuery;
/**
 * This is a helper class that provides static access to methods useful for creating SQL queries 
 * within this framework.
 * @author Jan P.C. Hanson
 *
 */
public class QueryUtility
{

	/**
	 * private ctor ensures that this class is never instantiated
	 */
	private QueryUtility()
	{super();}
	
	/**
	 * set an Integer parameter for the query object specified.
	 * @param queryObj the query in which to set the Integer parameter (usually just pass in 'this')
	 * @param parameters the HeteroFieldContainer containing all the parameters.
	 * @param field the particular AbstractField within the HeteroFieldContainer to use for this parameter. 
	 * @param index the index of this parameter
	 * @throws ClassCastException
	 * @throws SQLException
	 */
	public static void setINTEGERParam
			(AbstractDBQuery queryObj, HeteroFieldContainer parameters, AbstractField field, int index) 
			throws ClassCastException, SQLException
	{queryObj.statement().setInt(index, parameters.get(field, ClassRef.INTEGER));}
	
	/**
	 * set an Integer parameter for the query object specified.
	 * @param queryObj the query in which to set the Integer parameter (usually just pass in 'this')
	 * @param parameters the HeteroFieldContainer containing all the parameters.
	 * @param field the particular AbstractField within the HeteroFieldContainer to use for this parameter. 
	 * @param index the index of this parameter
	 * @throws ClassCastException
	 * @throws SQLException
	 */
	public static void setVARCHARParam
			(AbstractDBQuery queryObj, HeteroFieldContainer parameters, AbstractField field, int index) 
			throws ClassCastException, SQLException
	{queryObj.statement().setString(index, parameters.get(field, ClassRef.STRING));}
	
	/**
	 * set an Integer parameter for the query object specified.
	 * @param queryObj the query in which to set the Integer parameter (usually just pass in 'this')
	 * @param parameters the HeteroFieldContainer containing all the parameters.
	 * @param field the particular AbstractField within the HeteroFieldContainer to use for this parameter. 
	 * @param index the index of this parameter
	 * @throws ClassCastException
	 * @throws SQLException
	 */
	public static void setBYTEParam
			(AbstractDBQuery queryObj, HeteroFieldContainer parameters, AbstractField field, int index) 
			throws ClassCastException, SQLException
	{queryObj.statement().setByte(index, parameters.get(field, ClassRef.BYTE));}
	
	/**
	 * set an Integer parameter for the query object specified.
	 * @param queryObj the query in which to set the Integer parameter (usually just pass in 'this')
	 * @param parameters the HeteroFieldContainer containing all the parameters.
	 * @param field the particular AbstractField within the HeteroFieldContainer to use for this parameter. 
	 * @param index the index of this parameter
	 * @throws ClassCastException
	 * @throws SQLException
	 */
	public static void setBIGINTParam
			(AbstractDBQuery queryObj, HeteroFieldContainer parameters, AbstractField field, int index) 
			throws ClassCastException, SQLException
	{queryObj.statement().setLong(index, parameters.get(field, ClassRef.LONG));}
	
	/**
	 * set an Integer parameter for the query object specified.
	 * @param queryObj the query in which to set the Integer parameter (usually just pass in 'this')
	 * @param parameters the HeteroFieldContainer containing all the parameters.
	 * @param field the particular AbstractField within the HeteroFieldContainer to use for this parameter. 
	 * @param index the index of this parameter
	 * @throws ClassCastException
	 * @throws SQLException
	 */
	public static void setTINYINTParam
			(AbstractDBQuery queryObj, HeteroFieldContainer parameters, AbstractField field, int index) 
			throws ClassCastException, SQLException
	{queryObj.statement().setBoolean(index, parameters.get(field, ClassRef.BOOLEAN));}
	
	/**
	 * set an Integer parameter for the query object specified.
	 * @param queryObj the query in which to set the Integer parameter (usually just pass in 'this')
	 * @param parameters the HeteroFieldContainer containing all the parameters.
	 * @param field the particular AbstractField within the HeteroFieldContainer to use for this parameter. 
	 * @param index the index of this parameter
	 * @throws ClassCastException
	 * @throws SQLException
	 */
	public static void setTIMESTAMPParam
			(AbstractDBQuery queryObj, HeteroFieldContainer parameters, AbstractField field, int index) 
			throws ClassCastException, SQLException
	{queryObj.statement().setTimestamp(index, parameters.get(field, ClassRef.TIMESTAMP));}
	
	/**
	 * set an Integer parameter for the query object specified.
	 * @param queryObj the query in which to set the Integer parameter (usually just pass in 'this')
	 * @param parameters the HeteroFieldContainer containing all the parameters.
	 * @param field the particular AbstractField within the HeteroFieldContainer to use for this parameter. 
	 * @param index the index of this parameter
	 * @throws ClassCastException
	 * @throws SQLException
	 */
	public static void setDATEParam
			(AbstractDBQuery queryObj, HeteroFieldContainer parameters, AbstractField field, int index) 
			throws ClassCastException, SQLException
	{queryObj.statement().setDate(index, parameters.get(field, ClassRef.DATE));}
	
	/**
	 * set an Integer parameter for the query object specified.
	 * @param queryObj the query in which to set the Integer parameter (usually just pass in 'this')
	 * @param parameters the HeteroFieldContainer containing all the parameters.
	 * @param field the particular AbstractField within the HeteroFieldContainer to use for this parameter. 
	 * @param index the index of this parameter
	 * @throws ClassCastException
	 * @throws SQLException
	 */
	public static void setDOUBLEParam
			(AbstractDBQuery queryObj, HeteroFieldContainer parameters, AbstractField field, int index) 
			throws ClassCastException, SQLException
	{queryObj.statement().setDouble(index, parameters.get(field, ClassRef.DOUBLE));}
	
	/**
	 * set an Integer parameter for the query object specified.
	 * @param queryObj the query in which to set the Integer parameter (usually just pass in 'this')
	 * @param parameters the HeteroFieldContainer containing all the parameters.
	 * @param field the particular AbstractField within the HeteroFieldContainer to use for this parameter. 
	 * @param index the index of this parameter
	 * @throws ClassCastException
	 * @throws SQLException
	 */
	public static void setFLOATParam
			(AbstractDBQuery queryObj, HeteroFieldContainer parameters, AbstractField field, int index) 
			throws ClassCastException, SQLException
	{queryObj.statement().setFloat(index, parameters.get(field, ClassRef.FLOAT));}
}