package kr.co.educraft.util.string;

import java.util.*;

public class Tokenizer {
	private int start;
	private int pos;
	private int count;
	private Properties properties;

	public Tokenizer(String src, String token) {
		start = 0;
		pos = 0;
		count = 0;
		properties = new Properties();

		while (true) {
			int tokenIndex = src.indexOf(token, start);
			if (tokenIndex < 0) {
				properties.put(Integer.toString(count), src.substring(start));
				count++;
				break;
			}
			properties.put(Integer.toString(count), src.substring(start, tokenIndex));
			start = tokenIndex + token.length();
			count++;
		}
	}

	public int countTokens() {
		return count;
	}

	public boolean hasToken() {
		if (pos < count)
			return true;
		else
			return false;
	}

	public String nextToken() {
		String strTemp = properties.getProperty(Integer.toString(pos));
		if (strTemp == null) {
			return null;
		} else {
			pos++;
			return strTemp;
		}
	}
}
