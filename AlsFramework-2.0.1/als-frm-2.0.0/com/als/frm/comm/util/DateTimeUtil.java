package com.als.frm.comm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

	private static final String DEFAULT_DATE_STYLE = "yyyyMMdd";

	private static final String DEFAULT_TIME_STYLE = "HHmmss";

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static String getCurrentDate() {

		return format(new Date(), DEFAULT_DATE_STYLE);
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getCurrentTime() {

		return format(new Date(), DEFAULT_TIME_STYLE);
	}

	/**
	 * 格式化成时间类型
	 * 
	 * @param dateStr
	 * @param style
	 * @return
	 */
	public static Date format(String dateStr, String style) {

		try {
			if (StringUtil.isEmpty(style)) {
				style = DEFAULT_DATE_STYLE;
			}
			SimpleDateFormat f = new SimpleDateFormat(style);
			return f.parse(dateStr);
		} catch (Throwable e) {
		}
		return null;
	}

	/**
	 * 格式化成字符串类型
	 * 
	 * @param date
	 * @param style
	 * @return
	 */
	public static String format(Date date, String style) {

		if (StringUtil.isEmpty(style)) {
			style = DEFAULT_DATE_STYLE;
		}
		SimpleDateFormat sf = new SimpleDateFormat(style);
		String str = sf.format(date);
		return str;
	}

	/**
	 * 将一种格式的字符串时间转为另一种格式的字符串时间
	 * 
	 * @param dateStr
	 * @param souceStyle
	 * @return
	 */
	public static String format(String dateStr, String souceStyle,
			String newStyle) {

		if (dateStr == null) {
			return null;
		}

		Date d = format(dateStr, souceStyle);
		if (d != null) {
			return format(d, newStyle);
		}
		return null;
	}

	/**
	 * 日期相加
	 * @param interval
	 * @param number
	 * @param date
	 * @return
	 */
	public static String dateAdd(String interval, int number, Date date) {
		return dateAdd(interval, number, date, "yyyyMMdd");
	}

	public static String dateAdd(String interval, int number, Date date,
			String format) {
		if (date == null)
			return "";
		SimpleDateFormat dateFormat = (format != null ? new SimpleDateFormat(
				format) : new SimpleDateFormat());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (interval.equals("y"))
			calendar.add(1, number);
		else if (interval.equals("m"))
			calendar.add(2, number);
		else if (interval.equals("d"))
			calendar.add(5, number);
		return dateFormat.format(calendar.getTime());
	}

	public static void main(String[] args) {

		String str = "20141212";
		String r = DateTimeUtil.format(str, "yyyyMMdd", "yyyy-MM-dd");
		System.out.println(r);
		System.out.println(DateTimeUtil.getCurrentTime());
	}
}
