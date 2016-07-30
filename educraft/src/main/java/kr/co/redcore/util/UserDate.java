package kr.co.redcore.util;

import java.util.*;
import kr.co.redcore.util.string.UserString;

public class UserDate {
	private Calendar calendar;

	public UserDate() {
		calendar = Calendar.getInstance();
	}

	public String getYear() {
		return Integer.toString(calendar.get(Calendar.YEAR));
	}

	public String getMonth() {
		UserString userString = new UserString();
		return userString.addCharToLeft(Integer.toString(calendar.get(Calendar.MONTH) + 1), '0', 2);
	}

	public String getDay() {
		UserString userString = new UserString();
		return userString.addCharToLeft(Integer.toString(calendar.get(Calendar.DATE)), '0', 2);
	}

	public String getHour() {
		UserString userString = new UserString();
		return userString.addCharToLeft(Integer.toString(calendar.get(Calendar.HOUR_OF_DAY)), '0', 2);
	}

	public String getMinute() {
		UserString userString = new UserString();
		return userString.addCharToLeft(Integer.toString(calendar.get(Calendar.MINUTE)), '0', 2);
	}

	public String getSecond() {
		UserString userString = new UserString();
		return userString.addCharToLeft(Integer.toString(calendar.get(Calendar.SECOND)), '0', 2);
	}

	public String getMilliSecond() {
		UserString userString = new UserString();
		String buffer = Integer.toString(calendar.get(Calendar.MILLISECOND));
		if (buffer.length() > 3) {
			return buffer.substring(0, 3);
		} else {
			return userString.addCharToLeft(buffer, '0', 3);
		}
	}

	public String getFormat(String format) {
		UserString userString = new UserString();

		if (format.indexOf("YYYY") >= 0)
			format = userString.replace(format, "YYYY", getYear());
		if (format.indexOf("YY") >= 0)
			format = userString.replace(format, "YY", getYear().substring(2));
		if (format.indexOf("MM") >= 0)
			format = userString.replace(format, "MM", getMonth());
		if (format.indexOf("DD") >= 0)
			format = userString.replace(format, "DD", getDay());
		if (format.indexOf("HH") >= 0)
			format = userString.replace(format, "HH", getHour());
		if (format.indexOf("MI") >= 0)
			format = userString.replace(format, "MI", getMinute());
		if (format.indexOf("SS") >= 0)
			format = userString.replace(format, "SS", getSecond());
		if (format.indexOf("FF3") >= 0)
			format = userString.replace(format, "FF3", getMilliSecond());

		if (format.indexOf("yyyy") >= 0)
			format = userString.replace(format, "yyyy", getYear());
		if (format.indexOf("yy") >= 0)
			format = userString.replace(format, "yy", getYear().substring(2));
		if (format.indexOf("mm") >= 0)
			format = userString.replace(format, "mm", getMonth());
		if (format.indexOf("dd") >= 0)
			format = userString.replace(format, "dd", getDay());
		if (format.indexOf("hh") >= 0)
			format = userString.replace(format, "hh", getHour());
		if (format.indexOf("mi") >= 0)
			format = userString.replace(format, "mi", getMinute());
		if (format.indexOf("ss") >= 0)
			format = userString.replace(format, "ss", getSecond());
		if (format.indexOf("ff3") >= 0)
			format = userString.replace(format, "ff3", getMilliSecond());

		return format;
	}

	public int getActualMinimum(String year, String month) {
		String currYear = getYear();
		String currMonth = getMonth();
		String currDay = getDay();

		calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
		int minDay = calendar.getActualMinimum(calendar.DAY_OF_MONTH);
		calendar.set(Integer.parseInt(currYear), Integer.parseInt(currMonth) - 1, Integer.parseInt(currDay));

		return minDay;
	}

	public int getActualMaximum(String year, String month) {
		String currYear = getYear();
		String currMonth = getMonth();
		String currDay = getDay();

		calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
		int maxDay = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		calendar.set(Integer.parseInt(currYear), Integer.parseInt(currMonth) - 1, Integer.parseInt(currDay));

		return maxDay;
	}

	public String getAddDay(String year, String month, String day, int addDay) {
		String currYear = getYear();
		String currMonth = getMonth();
		String currDay = getDay();

		calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
		calendar.add(calendar.DATE, addDay);
		String retVal = getFormat("YYYYMMDD");
		calendar.set(Integer.parseInt(currYear), Integer.parseInt(currMonth) - 1, Integer.parseInt(currDay));

		return retVal;
	}

	public String getAddMonth(String year, String month, int addMonth) {
		String currYear = getYear();
		String currMonth = getMonth();
		String currDay = getDay();

		calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
		calendar.add(calendar.MONTH, addMonth);
		String retVal = getFormat("YYYYMMDD");
		calendar.set(Integer.parseInt(currYear), Integer.parseInt(currMonth) - 1, Integer.parseInt(currDay));

		return retVal;
	}
	
	public String convertDate(String date, String separator) {
		StringBuffer sb = new StringBuffer();
		sb.append(date.substring(0, 4) + separator + date.substring(4, 6) + separator + date.substring(6, 8));
		
		return sb.toString();
	}	
}
