package kr.co.redcore.util;

public class UserRand {
	public static String randString(int size, int radix) {
		StringBuffer buf = new StringBuffer();
		
		for (int i = 0; i < size; i++) {
			buf.append(Integer.toString((int) (Math.random() * radix), radix));
		}
		
		return buf.toString();
	}
}
