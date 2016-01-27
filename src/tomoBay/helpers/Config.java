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

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public enum Config
{
	MON_ST("MONDAY_START_TIME"), 
	MON_END("MONDAY_END_TIME"),
	TUE_ST("TUESDAY_START_TIME"), 
	TUE_END("TUESDAY_END_TIME"),
	WED_ST("WEDNESDAY_START_TIME"), 
	WED_END("WEDNESDAY_END_TIME"),
	THUR_ST("THURSDAY_START_TIME"), 
	THUR_END("THURSDAY_END_TIME"),
	FRI_ST("FRIDAY_START_TIME"), 
	FRI_END("FRIDAY_END_TIME"),
	SAT_ST("SATURDAY_START_TIME"), 
	SAT_END("SATURDAY_END_TIME"),
	SUN_ST("SUNDAY_START_TIME"), 
	SUN_END("SUNDAY_END_TIME"),
	
	DB_QSTR("JDBC_QUERY_STRING"),
	DB_USR("DB_USER"),
	DB_PWD("DB_PASSWORD"),
	DB_CON_MIN("DB_CONNECTION_POOL_MIN_SIZE"),
	DB_CON_MAX("DB_CONNECTION_POOL_MAX_SIZE"),
	DB_AQUIRE_INC("DB_CONNECTION_POOL_AQUIRE_INCREMENT"),
	DB_MAX_STMTS("DB_CONNECTION_POOL_MAX_STATEMENTS"),
	
	WIN_LOC("WINSTOCK_IP"),
	WIN_PORT("WINSTOCK_PORT"),
	WIN_URL1("WINSTOCK_URL_PT1"),
	WIN_URL2("WINSTOCK_URL_PT2"),
	
	EBAY_SAND_SRV("EBAY_SANDBOX_SERVER"),
	EBAY_SAND_KEY("EBAY_SANDBOX_API_KEY"),
	EBAY_PROD_SRV("EBAY_PRODUCTION_SERVER"),
	EBAY_PROD_KEY("EBAY_PRODUCTION_API_KEY"),
	EBAY_LOOKBCK("EBAY_LOOKBACK_DAYS"),
	
	MAIL_ADDR("SYSTEM_EMAIL_ADDRESS"),
	MAIL_PWD("SYSTEM_EMAIL_PASSWORD"),
	MAIL_USR("EMAIL_USER"),
	
	Ship_Type("SHIPPING_TYPE"),
	;
	
	/**
	 * needed to allow values associated with enum constants
	 */
	private final String text;
	
	/**
	 * needed to allow values associated with enum constants
	 * @param text
	 */
	private Config (final String text)
	{this.text = text;}
	
	/**
	 * return the string associated with the enum const
	 * @return String 
	 */
	public String getVar()
	{return text;}
}
