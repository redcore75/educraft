package kr.co.redcore.util.string;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * <p>
 * String값을 적절하게 변환하는 메소드를 포함하는 클래스
 * </p>
 * 
 * @author <a href="mailto:kidani@paran.com">Kang Ki Dan </a>
 * 
 * @version Revision: Date: Jan 6, 2002 2:22:38 PM
 */
public class ConvertUtil {
    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Vo Object 직렬화
     * 
     * @param obj
     * @return
     */
    public static String generateJson( Object obj ){
        return GSON.toJson(obj);
    }
    
	/**
	 * 문자열 채움 함수 <br>
	 * 주어진 문자열을 왼쪽 방향에 공백문자를 길이 만큼 채워서 리턴한다.
	 * 
	 * @param fuStr
	 *            String 소스 문자열
	 * @param fuLen
	 *            int 최종적으로 출력할 문자열 길이
	 * @return String 채워진 문자열
	 */
	public static String getFillup(String fuStr, int fuLen) {
		return getFillup(fuStr, fuLen, ' ');
	}

	/**
	 * 문자열 채움 함수 <br>
	 * 주어진 문자열을 왼쪽 방향에 채울문자를 길이 만큼 채워서 리턴한다.
	 * 
	 * @param fuStr
	 *            String 소스 문자열
	 * @param fuLen
	 *            int 최종적으로 출력할 문자열 길이
	 * @param fuFillChar
	 *            char 채울 문자
	 * @return String 채워진 문자열
	 */
	public static String getFillup(String fuStr, int fuLen, char fuFillChar) {
		if (fuStr == null) {
			return null;
		}

		int fuDiff = fuLen - fuStr.length();

		for (int i = 0; i < fuDiff; i++)
			fuStr = fuFillChar + fuStr;

		return fuStr;
	}

	/**
	 * 문자열 채움 함수<br>
	 * 주어진 문자열을 채울 방향에 채울문자를 길이 만큼 채워서 리턴한다.
	 * 
	 * @param fuStr
	 *            String 소스 문자열
	 * @param fuLen
	 *            int 최종적으로 출력할 문자열 길이
	 * @param fuFillChar
	 *            char 채울 문자
	 * @param fuDirect
	 *            boolean 채울 방향(false : 왼쪽 , true : 오른쪽)
	 * @return String 채워진 문자열
	 */
	public static String getFillup(String fuStr, int fuLen, char fuFillChar, boolean fuDirect) {
		if (fuStr == null) {
			return null;
		}

		int fuDiff = fuLen - fuStr.length();

		if (fuDirect) {
			for (int i = 0; i < fuDiff; i++)
				fuStr += fuFillChar; // 오른쪽
		} else {
			for (int i = 0; i < fuDiff; i++)
				fuStr = fuFillChar + fuStr; // 왼쪽
		}

		return fuStr;
	}

	/**
	 * 문자열 채움 함수<br>
	 * 주어진 문자열을 채울 방향에 공백문자를 길이 만큼 채워서 리턴한다.
	 * 
	 * @param fuStr
	 *            String 소스 문자열
	 * @param fuLen
	 *            int 최종적으로 출력할 문자열 길이
	 * @param fuDirect
	 *            boolean 채울 방향(false : 왼쪽 , true : 오른쪽)
	 * @return String 채워진 문자열
	 */
	public static String getFillup(String fuStr, int fuLen, boolean fuDirect) {
		return getFillup(fuStr, fuLen, ' ', fuDirect);
	}

	/**
	 * 입력한 내용을 보여줄때 \n 을 &ltbr&gt로 바꿔서 보여준다.
	 * 
	 * @param str
	 *            java.lang.String
	 * @return java.lang.String
	 */
	public static String convertTextHtml(String str) {
		return replace(str, '\n', "<BR>");
	}

	/**
	 * String 을 DB Query 문에 더하는 형태로<br>
	 * ' 을 '' 로 변환한다.
	 * 
	 * @param str
	 *            java.lang.String
	 * @return 변환되어진 문자열
	 */
	public static String convertDbString(String str) {
		if (str == null) {
			return "''";
		} else {
			return " '" + replace(str.trim(), '\'', "''") + "' ";
		}
	}

	/**
	 * String[] 을 DB Query 문에 더하는 형태로<br>
	 * 
	 * @param str
	 *            java.lang.String[]
	 * @return 변환되어진 문자열
	 */
	public static String convertDbString(String[] str) {
		if (str == null) {
			return "''";
		} else {
			StringBuffer temp = new StringBuffer();

			for (int i = 0; i < str.length; i++) {
				temp.append("'");
				temp.append(replace(str[i].trim(), '\'', "''"));
				temp.append("'");

				if (i < (str.length - 1)) {
					temp.append(",");
				}
			}

			return temp.toString();
		}
	}

	/**
	 * ArrayList 를 DB Query 문에 더하는 형태로<br>
	 * 앞뒤에 ' 을 넣고 구분은 , 으로 한다.
	 * 
	 * @param list
	 * @return 변환되어진 문자열
	 */
	public static String convertDbString(ArrayList list) {
		if (list == null) {
			return "''";
		} else {
			StringBuffer temp = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				temp.append("'");
				temp.append(replace(((String) list.get(i)).trim(), '\'', "''"));
				temp.append("'");

				if (i < (list.size() - 1)) {
					temp.append(",");
				}
			}

			return temp.toString();
		}
	}

	/**
	 * ArrayList 를 DB Query 문에 더하는 형태로<br>
	 * 구분은 , 으로 한다.
	 * 
	 * @param list
	 * @return String
	 */
	public static String convertDbNumber(ArrayList list) {
		if (list == null) {
			return "";
		} else {
			StringBuffer temp = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				temp.append(((String) list.get(i)).trim());

				if (i < (list.size() - 1)) {
					temp.append(",");
				}
			}

			return temp.toString();
		}
	}

	/**
	 * String[] 을 DB Query 문에 더하는 형태로<br>
	 * 구분은 , 으로 한다.
	 * 
	 * @param strArray
	 * @return String
	 */
	public static String convertDbNumber(String[] strArray) {
		if (strArray == null) {
			return "";
		} else {
			StringBuffer temp = new StringBuffer();

			for (int i = 0; i < strArray.length; i++) {
				temp.append(strArray[i]);

				if (i < (strArray.length - 1)) {
					temp.append(",");
				}
			}

			return temp.toString();
		}
	}

	/**
	 * " 을 &quot; 로 변환 form- text,textarea, hidden에 뿌려줄때..
	 * 
	 * @param str
	 *            java.lang.String
	 * @return java.lang.String
	 */
	public static String Q2S(String str) {
		return replace(str, '\"', "&quot;");
	}

	/**
	 * &quot; 을 " 로 변환 DB에 넣을때.
	 * 
	 * @param str
	 *            java.lang.String
	 * @return java.lang.String
	 */
	public static String S2Q(String str) {
		return replace(str, "&quot;", "\"");
	}

	/**
	 * 문자열을 다른 문자열로 바꿔주는 것.
	 * 
	 * @param str
	 *            java.lang.String
	 * @param oldString
	 *            java.lang.String
	 * @param newString
	 *            java.lang.String
	 * @return java.lang.String
	 */
	public static String replace(String str, String oldString, String newString) {
		int index = 0;

		while ((index = str.indexOf(oldString, index)) >= 0) {
			str = str.substring(0, index) + newString + str.substring(index + oldString.length());
			index += newString.length();
		}

		return str.trim();
	}

	/**
	 * Character 를 다른 문자열로 바꿔주는 것.
	 * 
	 * @param str
	 *            java.lang.String
	 * @param oldChar
	 *            char
	 * @param newString
	 *            java.lang.String
	 * @return 변환되어진 문자열
	 */
	public static String replace(String str, char oldChar, String newString) {
		if (str == null) {
			return "";
		}

		StringBuffer buf = new StringBuffer();
		char[] c = str.toCharArray();
		int len = c.length;

		for (int i = 0; i < len; i++) {
			if (c[i] == oldChar) {
				buf.append(newString);
			} else {
				buf.append(c[i]);
			}
		}

		return buf.toString().trim();
	}

	/**
	 * 배열리스트중에 특정 String 이 있는지 확인
	 * 
	 * @param array
	 *            배열리스트
	 * @param str
	 *            문자열
	 * @return 배열리스트에 문자열이 있으면 true, 없으면 false
	 */
	public static boolean isHasString(String[] array, String str) {
		if ((array == null) || (str == null)) {
			return false;
		}

		boolean flag = false;

		for (int i = 0; i < array.length; i++) {
			if (str.equals(array[i])) {
				flag = true;

				break;
			}
		}

		return flag;
	}

	/**
	 * WEB 에서 특수문자 보여주기
	 * 
	 * @param s
	 *            변환할 문자열
	 * @return 변환되어진 문자열
	 */
	public static String translate(String s) {
		if (s == null) {
			return "";
		}

		StringBuffer buf = new StringBuffer();
		char[] c = s.toCharArray();
		int len = c.length;

		for (int i = 0; i < len; i++) {
			if (c[i] == '&') {
				buf.append("&amp;");
			} else if (c[i] == '<') {
				buf.append("&lt;");
			} else if (c[i] == '>') {
				buf.append("&gt;");
			} else if (c[i] == '"') {
				buf.append("&quot;");
			} else if (c[i] == '\'') {
				buf.append("&#039;");
			} else {
				buf.append(c[i]);
			}
		}

		return buf.toString();
	}

	/**
	 * WML 에서 특수문자 보여주기
	 * 
	 * @param s
	 * @return 변환되어진 문자열
	 */
	public static String translateWML(String s) {
		if (s == null) {
			return "";
		}

		StringBuffer buf = new StringBuffer();
		char[] c = s.toCharArray();
		int len = c.length;

		for (int i = 0; i < len; i++) {
			if (c[i] == '&') {
				buf.append("&amp;");
			} else if (c[i] == '<') {
				buf.append("&lt;");
			} else if (c[i] == '>') {
				buf.append("&gt;");
			} else if (c[i] == '"') {
				buf.append("&quot;");
			} else if (c[i] == '\'') {
				buf.append("&apos;");
			} else if (c[i] == '$') {
				buf.append("$$");
			} else {
				buf.append(c[i]);
			}
		}

		return buf.toString();
	}

	/**
	 * UTF-8 로 encoding 된 String
	 * 
	 * @param str
	 * @return String
	 */
	public static String convertUTF8(String str) {
		String result = null;

		try {
			result = java.net.URLEncoder.encode(str, "UTF-8");
		} catch (java.io.UnsupportedEncodingException e) {
			result = str;
		}

		return result;
	}

	// ////////////////////////////////////////////////////////////////////////////////

	/**
	 * String 을 String 으로 변환한다.<br>
	 * null 일경우 defaultValue<br>
	 * null 이 아닐경우 trim()<br>
	 * 
	 * @param value
	 *            java.lang.String
	 * @param defaultValue
	 *            java.lang.String
	 * 
	 * @return String
	 */
	public static String convert(String value, String defaultValue) {
		if (value == null) {
			return defaultValue;
		} else {
			return value.trim();
		}
	}

	/**
	 * String 을 boolean 으로 변환한다.<br>
	 * null 일경우 defaultValue<br>
	 * yes, true, on, 1 --> true<br>
	 * no, false, off, 0 --> false<br>
	 * 
	 * @param value
	 *            java.lang.String
	 * @param defaultValue
	 *            boolean
	 * 
	 * @return boolean
	 */
	public static boolean convert(String value, boolean defaultValue) {
		if (value == null) {
			return (defaultValue);
		} else if (value.equalsIgnoreCase("yes") || value.equalsIgnoreCase("true") || value.equalsIgnoreCase("on") || value.equals("1")) {
			return true;
		} else if (value.equalsIgnoreCase("no") || value.equalsIgnoreCase("false") || value.equalsIgnoreCase("off") || value.equals("0")) {
			return false;
		} else {
			return (defaultValue);
		}
	}

	/**
	 * @param value
	 *            java.lang.String
	 * @param defaultValue
	 *            char
	 * 
	 * @return char
	 */
	public static char convert(String value, char defaultValue) {
		if ((value == null) || (value.length() == 0)) {
			return (defaultValue);
		} else {
			return value.charAt(0);
		}
	}

	/**
	 * @param value
	 *            java.lang.String
	 * @param defaultValue
	 *            byte
	 * 
	 * @return byte
	 */
	public static byte convert(String value, byte defaultValue) {
		if (value == null) {
			return (defaultValue);
		}

		try {
			return Byte.parseByte(value);
		} catch (NumberFormatException e) {
			return (defaultValue);
		}
	}

	/**
	 * @param value
	 *            java.lang.String
	 * @param defaultValue
	 *            short
	 * 
	 * @return short
	 */
	public static short convert(String value, short defaultValue) {
		if (value == null) {
			return (defaultValue);
		}

		try {
			return Short.parseShort(value);
		} catch (NumberFormatException e) {
			return (defaultValue);
		}
	}

	/**
	 * @param value
	 *            java.lang.String
	 * @param defaultValue
	 *            int
	 * 
	 * @return int
	 */
	public static int convert(String value, int defaultValue) {
		if (value == null) {
			return (defaultValue);
		}

		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return (defaultValue);
		}
	}

	/**
	 * @param value
	 *            java.lang.String
	 * @param defaultValue
	 *            long
	 * 
	 * @return long
	 */
	public static long convert(String value, long defaultValue) {
		if (value == null) {
			return (defaultValue);
		}

		try {
			return Long.parseLong(value);
		} catch (NumberFormatException e) {
			return (defaultValue);
		}
	}

	/**
	 * @param value
	 *            java.lang.String
	 * @param defaultValue
	 *            float
	 * 
	 * @return float
	 */
	public static float convert(String value, float defaultValue) {
		if (value == null) {
			return (defaultValue);
		}

		try {
			return Float.parseFloat(value);
		} catch (NumberFormatException e) {
			return (defaultValue);
		}
	}

	/**
	 * @param value
	 *            java.lang.String
	 * @param defaultValue
	 *            double
	 * 
	 * @return double
	 */
	public static double convert(String value, double defaultValue) {
		if (value == null) {
			return (defaultValue);
		}

		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return (defaultValue);
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param _reader
	 *            DOCUMENT ME!
	 * @param defaultValue
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * 
	 * @throws IOException
	 *             DOCUMENT ME!
	 */
	public static StringBuffer convert(Reader _reader, String defaultValue) throws IOException {
		StringBuffer output = new StringBuffer();

		if (_reader == null) {
			return output.append(defaultValue);
		}

		char[] buf = new char[1024];
		int readcnt;

		while ((readcnt = _reader.read(buf, 0, 1024)) != -1) {
			// while ((readcnt = _reader.read(buf)) != -1) {
			output.append(buf, 0, readcnt);
		}

		_reader.close();

		return output;
	}

	/**
	 * 한글을 폰으로 전송할때 처리한다.
	 * 
	 * @param message
	 * 
	 * @return encode 된 byte
	 */
	public static byte[] encodeSend(String message) {
		byte[] buf = message.getBytes();

		for (int i = 0; i < buf.length; i++) {
			if (buf[i] == -1) {
				buf[i] = 1;
			}
		}

		return buf;
	}

	/**
	 * 한글을 폰에서 전송받을때 처리한다.
	 * 
	 * @param buf
	 * 
	 * @return decode 된 byte
	 */
	public static String decodeSend(byte[] buf) {
		for (int i = 0; i < buf.length; i++) {
			if (buf[i] == 1) {
				buf[i] = -1;
			}
		}

		return new String(buf);
	}
}