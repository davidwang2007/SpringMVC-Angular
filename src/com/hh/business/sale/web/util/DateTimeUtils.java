/**
 * 
 */
package com.hh.business.sale.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 处理日期格式化问题的帮助类
 * @author david
 *
 */
public class DateTimeUtils {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
	private static final SimpleDateFormat sdfDateHourMinute = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
	private static final SimpleDateFormat sdfMonthAndDay = new SimpleDateFormat("MM-dd") ;
	private static final Log logger = LogFactory.getLog("DateTimeUtils");
	private DateTimeUtils(){}
	
	/**
	 * 将形如yyyy-MM-dd HH:mm:ss字符串转化为日期形式
	 * @params datetime
	 * @return Date
	 * @time 2013-7-2 上午10:08:47
	 * @author DavidWang [www]
	 * */
	public static Date parseDatetime(String datetime){
		try {
			Date date =  sdf.parse(datetime);
			return date;
		} catch (ParseException e) {
			logger.error("parseDatetime error occurred!"+e.getMessage());
			return null;
		}
	}
	
	/**
	 * 将形如yyyy-MM-dd字符串转化为日期形式
	 * @params date
	 * @return Date
	 * @time 2013-7-2 上午10:08:47
	 * @author DavidWang [www]
	 * */
	public static Date parseDate(String date){
		try {
			return sdf2.parse(date);
		} catch (ParseException e) {
			logger.error("parseDatetime error occurred!"+e.getMessage());
			return null;
		}
	}
	
	/**
	 * 将形如HH:mm:ss字符串转化为日期形式
	 * @params time
	 * @return Date
	 * @time 2013-7-2 上午10:08:47
	 * @author DavidWang [www]
	 * */
	public static Date parseTime(String time){
		try {
			return sdf3.parse(time);
		} catch (ParseException e) {
			logger.error("parseDatetime error occurred!"+e.getMessage());
			return null;
		}
	}
	
	/**
	 * 将形如yyyy-MM-dd HH:mm字符串转化为日期形式
	 * @params time
	 * @return Date
	 * @time 2013-7-2 上午10:08:47
	 * @author DavidWang [www]
	 * */
	public static Date parseDateHourMinute(String dateHourMinute){
		try{
			return sdfDateHourMinute.parse(dateHourMinute) ;
		}catch(ParseException e){
			logger.error("parseDatetime error occurred!"+e.getMessage());
			return null;
		}
	}
	/**
	 * 将形如MM-dd字符串转化为日期格式
	 * @param
	 * */
	public static Date parseMonthAndDay(String monthAndDay){
		try{
			return sdfMonthAndDay.parse(monthAndDay) ;
		}catch(ParseException e){
			logger.error("parseDatetime error occurred!"+e.getMessage()) ;
			return null ;
		}
	}
	/**
	 * 将日期转化为形如yyyy-MM-dd HH:mm:ss格式的字符串
	 * @params date
	 * @return String
	 * @time 2013-7-2 上午10:11:05
	 * @author DavidWang [www]
	 * */
	public static String formatDatetime(Date date){
		return date == null ? "" :sdf.format(date);
	}
	
	/**
	 * 将日期转化为形如yyyy-MM-dd格式的字符串
	 * @params date
	 * @return String
	 * @time 2013-7-2 上午10:11:05
	 * @author DavidWang [www]
	 * */
	public static String formatDate(Date date){
		return date == null ? "" :sdf2.format(date);
	}
	
	/**
	 * 将日期转化为形如HH:mm:ss格式的字符串
	 * @params date
	 * @return String
	 * @time 2013-7-2 上午10:11:05
	 * @author DavidWang [www]
	 * */
	public static String formatTime(Date date){
		return date == null ? "" :sdf3.format(date);
	}
	
	/**
	 * 将日期转化为形如yyyy-MM-dd HH:mm格式的字符串
	 * @params date
	 * @return String
	 * @time 2013-7-2 上午10:11:05
	 * @author DavidWang [www]
	 * */
	public static String formatDateHourMinute(Date dateHourMinute){
		return dateHourMinute == null ? "" : sdfDateHourMinute.format(dateHourMinute) ;
	}
	
	/**
	 * 将日期转化成形如MM-dd格式的字符串
	 * @param date
	 * @return String
	 * */
	public static String formatMonthAndDay(Date monthAndDay){
		return monthAndDay == null ? "":sdfMonthAndDay.format(monthAndDay) ;
	}
	
	/**
	 * 获取某年月的最后一天
	 * @param year 年
	 * @param month 月
	 * @return 
	 * */
	public static int getLastDayOfMonth(int year, int month) {     
        Calendar cal = Calendar.getInstance();     
        cal.set(Calendar.YEAR, year);     
        cal.set(Calendar.MONTH, month-1);     
        cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));  
       return  Integer.parseInt(new SimpleDateFormat("dd").format(cal.getTime()));  
    }   
	
}
