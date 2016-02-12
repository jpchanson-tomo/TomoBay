package tomoBay.model.dataTypes.json;
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
import tomoBay.exceptions.JSONentityException;
/**
 * this class represents a simple text value for a key value pair. The add method does not accept
 * an AbstractJSON_value and will throw an exception if one is passed to it, use null instead.
 * THIS IS THE EXCEPTION TO THE RULE, ALL OTHER AbstractJSONvalue DERIVED TYPES NEED THAT ARGUMENT
 * @author Jan P.C. Hanson
 *
 */
public final class JSONentity_string extends JSONentity
{
	/**the value of the JSON value string**/
	private String value_M;
	
	/**
	 * default ctor
	 */
	public JSONentity_string()
	{super();}
	
	/**
	 * instantiates a string JSON value
	 */
	public JSONentity_string(String name)
	{
		super();
		this.value_M = name;
	}

	/* 
	 * this value does not take any AbstractJSON_value argument and will throw an exception
	 * if one is given as an argument. pass it a null value. This is to make the motivation
	 * clear; that this is an exceptional class and not the norm.
	 * 
	 * (non-Javadoc)
	 * @see tomoBay.model.dataTypes.json.AbstractJSON_value#add(java.lang.String, tomoBay.model.dataTypes.json.AbstractJSON_value)
	 */
	@Override
	public JSONentity add(String key, JSONentity value)
	{
		if(value!=null) {throw new JSONentityException("JSONentity_string must be a null object not: "+value.toString());}
		else{this.value_M=key.toString();}
		return this;
	}
	
	/* (non-Javadoc)
	 * @see tomoBay.model.dataTypes.json.AbstractJSON_value#toString()
	 */
	@Override
	public String toString()
	{return "\""+this.value_M+"\"";}
}
