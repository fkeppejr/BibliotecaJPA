/*
 * Aluno: Fernando Antonio Keppe Junior
 * */

package up.biblioteca.utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

	public static java.util.Date sqlDateToUitlDate(java.sql.Date sDate){
		java.util.Date uDate = new java.util.Date(sDate.getTime());
	    return uDate;
	}
	
	public static java.sql.Date utilDateToSqlDate(java.util.Date uDate){
	    java.sql.Date sDate = new java.sql.Date(uDate.getTime());
	    return sDate;
	}
	
	public static java.util.Date stringToDate(String sDate){
		try {
			//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date tData = null;
			tData = new java.util.Date(format.parse(sDate).getTime());
			return tData;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String dateToString(java.util.Date dDate){
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		String sDate = formatter.format(dDate);
		return sDate;
	}
}
