package kr.co.educraft.util.string;

import java.util.regex.*;

public class UserString {
	public static String addCharToLeft(String src, char oneChar, int strLen) {
		src = src == null ? "" : src;
		StringBuffer sb = new StringBuffer();

		sb.append("");
		while (strLen - src.length() > 0) {
			sb.append(oneChar);
			strLen = strLen - 1;
		}
		sb.append(src);

		return sb.toString();
	}

	public static String addCharToRight(String src, char oneChar, int strLen) {
		StringBuffer sb = new StringBuffer();

		sb.append(src);
		while (strLen > src.length()) {
			sb.append(oneChar);
			strLen = strLen - 1;
		}

		return sb.toString();
	}

	public static String replace(String src, String search, String replace) {
		StringBuffer sb = new StringBuffer();

		sb.append("");
		while (src.length() != 0) {
			int start = src.indexOf(search);
			if (start > -1) {
				int end = start + search.length();
				sb.append(src.substring(0, start));
				sb.append(replace);
				src = src.substring(end);
			} else {
				sb.append(src);
				break;
			}
		}

		return sb.toString();
	}

	public static String replacePattern(String src, String replace, String pattern) {
		Pattern ptn = Pattern.compile(pattern);
		Matcher mch = ptn.matcher(src);
		return mch.replaceAll(replace);
	}
	
	public static byte[] getByteAddCharToLeft(byte[] src, char oneChar, int strLen) throws Exception {
		byte[] returnBytes = new byte[strLen];
		src = src == null ? new byte[]{} : src;
		
		if (src.length > strLen) {
			System.arraycopy(src, 0, returnBytes, 0, strLen);
		} else {
			int emptyLen = strLen - src.length;
			for (int i = 0; i < emptyLen; i++) {
				returnBytes[i] = (byte) oneChar;
			}
			System.arraycopy(src, 0, returnBytes, emptyLen, src.length);
		}
		return returnBytes;
	}
}
