package com.youngman.website.util.date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间格式转换工具类
 * @author yzzhouyalei@foxmail.com
 */
public class DateTimeUtils {

	/**
	 * 时间格式，如：2009-08-02 13:43
	 */
	public static final String pattern_yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
	/**
	 * 时间格式，如：2009-08-02 13:43
	 */
	public static final String pattern_yyyy_MMdd_HH_mm = "yyyy-MM-ddHH:mm";
	/**
	 * 时间格式，如：2009-08-02 13:43:13
	 */
	public static final String pattern_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String pattern_yyyy_MM_dd_HH_mm_ss_SSS = "yyyy-MM-dd HH:mm:ss:SSS";
	/**
	 * 时间格式，如：20090802134313
	 */
	public static final String pattern_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	/**
	 * 时间格式，如：2009-08-02
	 */
	public static final String pattern_yyyy_MM_dd = "yyyy-MM-dd";
	/**
	 * 时间格式,如:08-02 11:21
	 */
	public static final String pattern_MM_dd_HH_mm = "MM-dd HH:mm";
	/**
	 * 时间格式，如：2009-08
	 */
	public static final String pattern_yyyy_MM = "yyyy-MM";
	/**
	 * 时间格式，如：13:43
	 */
	public static final String pattern_HH_mm = "HH:mm";
	/**
	 * 日期时间格式化字符串
	 */
	public static final String DATE_TIME_FORMAT_STR_1 = "yyyyMM";
	/**
	 * 日期格式：如：20090802
	 */
	public static final String pattern_yyyyMMdd = "yyyyMMdd";	
	public static final String pattern_yyMMdd = "yyMMdd";
	public static final String pattern_HHmmssSSS = "HHmmssSSS";
	
	public static final String dayNames[] = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"}; 

	public static Date parseStringToDate(String pattern, String dateString) {
		DateFormat df1 = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = df1.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}
	public static String getDayPlus(Date date,int len){ 
	    SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd"); 
	    try { 
	        Calendar cal = Calendar.getInstance(); 
	        cal.setTime(date); 
	        cal.add(Calendar.DATE, len); 
	        return sdf.format(cal.getTime()); 
	    } catch (Exception e) { 
	        return sdf.format(new Date()); 
	    } 
	}
	/**
	 * @author zyl
	 */
	public static String parseToDefaultString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern_yyyy_MM_dd);
		return date==null?"":sdf.format(date);
	}
	/**
	 * @author zyl
	 */
	public static String parseToYMDHMSString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern_yyyy_MM_dd_HH_mm_ss);
		return date==null?"":sdf.format(date);
	}
	/**
	 * @author zyl
	 */
	public static String parseToMDHMString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern_MM_dd_HH_mm);
		return date==null?"":sdf.format(date);
	}
	/**
	 * 返回pattern_yyyy_MM_dd_HH_mm_ss类型的时间
	 */
	public static String getNowTimeStamp(){
		Date date = new Date();
		String time=null;
		SimpleDateFormat nf = new SimpleDateFormat(pattern_yyyy_MM_dd_HH_mm_ss);
		try {
				time = nf.format(date);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return time;
	}
	/**
	 * 根据规则转换成指定的时间字符串
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String parseDateToString(String pattern, Date date) {
		DateFormat df1 = new SimpleDateFormat(pattern);
		return date==null?"":df1.format(date);
	}

	/**
	 * 将日期字符串有一种格式转为另一种格式
	 * @param pattern1
	 * @param pattern2
	 * @param dateString
	 * @return
	 * @throws ParseException 
	 */
	public static String switchToAnotherString(String pattern1, String pattern2, String dateString) throws ParseException{
		DateFormat df1 = new SimpleDateFormat(pattern1);
		DateFormat df2 = new SimpleDateFormat(pattern2);
		Date date = df1.parse(dateString);
		return df2.format(date);
	}
	/**
	 * 获取days天前的日期
	 * 
	 * @param days
	 * @return
	 */
	public static Date getStartDateOfTodayByDays(int days) {
		long now = System.currentTimeMillis();

		return new Date(now - days * 24 * 60 * 60 * 1000);
	}
	/**
	 * 获取days天后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static Date getEndDateOfTodayByDays(int days) {
		long now = System.currentTimeMillis();

		return new Date(now + days * 24 * 60 * 60 * 1000);
	}

	/**
	 * 更新时间的计算
	 * 
	 * @param publishedDate
	 * @return
	 */
	public static String Datetochange(Date reflshDate) {
		if (reflshDate == null)
			return "";

		Calendar c = Calendar.getInstance();

		c.setTime(reflshDate);

		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
				c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.HOUR_OF_DAY),
				c.get(Calendar.MINUTE), c.get(Calendar.SECOND));

		Long time = (new Date().getTime()) - (c.getTimeInMillis());

		int ss = 1000;
		int mi = ss * 60;
		int hh = mi * 60;
		int dd = hh * 24;

		long day = time / dd;
		long hour = (time - day * dd) / hh;
		long minute = (time - day * dd - hour * hh) / mi;

		String strDay = "" + day;
		String strHour = "" + hour;
		String strMinute = "" + minute;
		StringBuffer leavetime = new StringBuffer();
		if (!strDay.equals("0")) {
			leavetime.append(strDay + "天");
		}
		if (!strHour.equals("0")) {
			leavetime.append(strHour + "小时");
		}
		leavetime.append(strMinute + "分钟前");
		
		if (day>2) {
			//leavetime.delete(0, leavetime.length()-1);
			leavetime.delete(0, leavetime.length());
			leavetime.append(DateTimeUtils.formatDateToString(DateTimeUtils.pattern_yyyy_MM_dd_HH_mm, reflshDate));
		}
		return leavetime.toString();
	}

	public static String DateLoginChange(Date loginDate) {
		if (loginDate == null)
			return "";

		Calendar c = Calendar.getInstance();

		c.setTime(loginDate);

		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
				c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.HOUR_OF_DAY),
				c.get(Calendar.MINUTE), c.get(Calendar.SECOND));

		Long time = (new Date().getTime()) - (c.getTimeInMillis());

		int ss = 1000;
		int mi = ss * 60;
		int hh = mi * 60;
		int dd = hh * 24;

		long day = time / dd;
		long hour = (time - day * dd) / hh;
		long minute = (time - day * dd - hour * hh) / mi;

		StringBuffer leavetime = new StringBuffer();
		if (day == 0 && hour == 0 && minute < 10) {
			leavetime.append("刚刚来过");
		} else {
			String strDay = "" + day;
			String strHour = "" + hour;
			String strMinute = "" + minute;

			if (!strDay.equals("0")) {
				leavetime.append(strDay + "天");
			}
			if (!strHour.equals("0")) {
				leavetime.append(strHour + "小时");
			}
			leavetime.append(strMinute + "分钟前");
		}
		return leavetime.toString();
	}
	/**
	 * 获取n月前的月份 格式如下：
	 * 2014-05
	 * 
	 * @return
	 */
	public static String getUpMonthByNow(int moths) {
		Calendar calendar = Calendar.getInstance();
		 calendar.setTime(new Date());  
		 calendar.set(Calendar.MONDAY,calendar.get(Calendar.MONDAY)-moths);
		return formatDateToString(pattern_yyyy_MM,calendar.getTime());
	}
	/**
	 * 获取n年的年份 格式如下：
	 * 2014
	 * 
	 * @return
	 */
	public static String getUpYearByNow(int years) {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR)-years+"";
	}
	/**
	 * 获取今天的开始时间
	 * 
	 * @return
	 */
	public static Date getBeginDateTimeOfToday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取今天的结束时间
	 * 
	 * @return
	 */
	public static Date getEndDateTimeOfToday() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getHalfOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 15);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getOneOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 30);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getOneHalfOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 45);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getTowOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 60);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	@SuppressWarnings("deprecation")
	public static String getYearNo(Date date) {
		int year = date.getYear();
		String yearNo = (year + "").substring(1);
		return yearNo;
	}

	@SuppressWarnings("deprecation")
	public static String getMonthNo(Date date) {
		int month = date.getMonth();
		String monthNo = month + 1 + "";
		if (month < 10) {
			monthNo = "0" + monthNo;
		}
		return monthNo;
	}

	public static String getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return String.valueOf(calendar.get(Calendar.YEAR));
	}

	public static String getMonthDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return String.valueOf(calendar.get(Calendar.MONTH) + 1)
				+ String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
	}

	public static String getFormatMonthDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return String.valueOf(calendar.get(Calendar.MONTH) + 1) + "/"
				+ String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 通过字符串创建一个Date对象
	 * 
	 * @param time
	 *            格式如"2010-06-11"
	 * @return date
	 * @throws ParseException
	 */
	public static Date formatStringToDate(String time) throws ParseException {
		DateFormat sdf = DateFormat.getDateInstance();

		return sdf.parse(time);
	}

	public static String formatDateToString(String pattern, Date date) {

		if (null == date) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		return sdf.format(date);
	}

	public static Date formatStringToDate(String pattern, String time)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		return sdf.parse(time);
	}

	/**
	 * 获取某天的结束时间
	 * 
	 * @return
	 */
	public static Date getEndDateTimeOfDate(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}
	/**
	 * 获取某天的开始时间
	 * 
	 * @return
	 */
	public static Date getStartDateTimeOfDate(Date date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	// 获得当前日期与本周日相差的天数
	private static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return 1 - dayOfWeek;
		}
	}

	/**
	 * 获取本周的开始时间
	 * 
	 * @return
	 */
	public static Date getBeginWeekTimeOfToday(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -(-getMondayPlus()));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 根据日期获取3天前的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginThreeDays(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -2);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 根据日期获取两月前的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginOfTwoMounth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 根据日期获得一季度的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginOfFirstQuarter(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 根据日期获得二季度的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginOfSecondQuarter(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 3);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 根据日期获得三季度的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginOfThirdQuarter(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 6);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 根据日期获得四季度的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginOfFourthQuarter(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 8);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 根据日期获取当月的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginOfMounth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	/**
	 * 根据所给日期获取当前月的最后时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndOfMounth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	public static String getStringCallLong(long callLong) {
		if (0 != callLong) {
			if (callLong < 60) {
				return "00:" + callLong;
			} else if (callLong > 60 && callLong < 3600) {
				return callLong / 60 + ":" + callLong % 60;
			} else {
				return (8000 / 60) / 60 + ":" + (8000 / 60) % 60 + ":" + 8000
						% 60;
			}
		}
		return null;
	}

	/**
	 * 根据日期获取24小时前的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeforeOneDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, -1440);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 根据日期获取90分钟(5400秒)前的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNinetyMinutesLater(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.SECOND, -5400);
		return calendar.getTime();
	}
	/**
	 * 根据日期获取90分钟(5400秒)后的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNinetyMinutesAfter(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.SECOND, 5400);
		return calendar.getTime();
	}

	// 验证一个时间是否为当天以前
	public static boolean isTodayByTime(String date) {
		boolean msg = false;
		Date orderDate = DateTimeUtils.parseStringToDate(
				DateTimeUtils.pattern_yyyy_MM_dd_HH_mm_ss, date);
		Date endDate = DateTimeUtils.getEndDateTimeOfToday();
		if (orderDate.before(endDate)) {
			msg = true;
		}
		return msg;
	}

	/**
	 * 获取时间戳
	 * 
	 * @return
	 */
	public static String getTimestamp(Date date) {
		SimpleDateFormat nf = new SimpleDateFormat("yyyyMMddHHmmss");
		String ntime = nf.format(date);
		return ntime;
	}
	/**
	 * 获取时间戳
	 * 无参数
	 * @return
	 */
	public static String getTimestamp() {
		Date date=new Date();
		SimpleDateFormat nf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String ntime = nf.format(date);
		return ntime;
	}
	
	/**
	 * 获得日期段内所有日期的数组
	 * @param calendarType 日期跨度的类型
	 */
	
	public static Date[] getDateArrays(Date start,Date end ,int calendarType){
		ArrayList<Date> ret = new ArrayList<Date>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		Date tmpDate = calendar.getTime();
		long endTime = end.getTime();
		while(tmpDate.before(end)||tmpDate.getTime() == endTime){
			ret.add(calendar.getTime());
			calendar.add(calendarType, 1);
			tmpDate = calendar.getTime();
		}		
		
		Date[] dates = new Date[ret.size()];
		return ret.toArray(dates);		
	}
	
	/**
	 * 增加一天
	 * @param d1
	 * @return
	 */
	public static String getNextTimeDate(String d1){
		SimpleDateFormat sdf = new SimpleDateFormat(DateTimeUtils.pattern_yyyy_MM_dd);
		String time=sdf.format(new Date().getTime()+1*24*3600*1000);
		
		return time;
	}
	
	/**
	 * 判断某一天为星期几
	 * data格式：例如2013-01-01
	 */
	public static String getDateNumber(String data) throws ParseException{
		Calendar calendar = Calendar.getInstance();			
		Date date=formatStringToDate(pattern_yyyy_MM_dd,data);
	    calendar.setTime(date);
	    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);	    
	    return dayNames[dayOfWeek - 1];

	}
	/**
	 * 两个时间比较
	 * 0 --相等
	 * < 0 str1小于 str2
	 * > 0 str1大于 str2
	 */
	public static int compareTime(String str1,String str2){
		java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Calendar c1=java.util.Calendar.getInstance();
		java.util.Calendar c2=java.util.Calendar.getInstance();
		try{
		  c1.setTime(df.parse(str1));
		  c2.setTime(df.parse(str2));
		}catch(java.text.ParseException e){
		  System.err.println("格式不正确");
		}
		int result=c1.compareTo(c2);
		return result;
	}
	/**
	 * 返回年月日
	 * @param date
	 * @return
	 */
	public static String getYMD(Date date){
		String ymd = "";
		try {
			ymd = DateTimeUtils.formatDateToString(DateTimeUtils.pattern_yyyy_MM_dd, date);
		} catch (Exception e) {
			System.err.println("格式不正确");
		}
		return ymd;
	}
}
