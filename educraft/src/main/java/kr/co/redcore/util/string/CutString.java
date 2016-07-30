package kr.co.redcore.util.string;

public class CutString {
	/**
	 * 만든 이: 자바클루(javaclue) 만든 날: 2003/05/15
	 * 
	 * 지정한 정수의 개수 만큼 빈칸(" ")을 스트링을 구한다.
	 * 
	 * @param int 문자 개수
	 * @return String 지정된 개수 만큼의 빈칸들로 연결된 String
	 */
	public static String spaces(int count) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < count; i++) {
			sb.append(' ');
		}
		return sb.toString();
	}

	/**
	 * 만든 이: 자바클루(javaclue) 만든 날: 2003/06/26
	 * 
	 * 지정한 정수의 개수 만큼 빈칸(" ")을 스트링을 구한다. 절단된 String의 바이트 수가 자를 바이트 개수보다 모자라지 않도록
	 * 한다.
	 * 
	 * @param str
	 *            원본 String
	 * @param int 자를 바이트 개수
	 * @return String 절단된 String
	 */
	public static String cutStringByBytes(String str, int length) {
		byte[] bytes = str.getBytes();
		int len = bytes.length;
		int counter = 0;
		if (length >= len) {
			return str + spaces(length - len);
		}
		for (int i = length - 1; i >= 0; i--) {
			if (((int) bytes[i] & 0x80) != 0)
				counter++;
		}
		return new String(bytes, 0, length + (counter % 2));
	}

	/**
	 * 만든 이: 자바클루(javaclue) 만든 날: 2003/06/26
	 * 
	 * 지정한 정수의 개수 만큼 빈칸(" ")을 스트링을 구한다. 절단된 String의 바이트 수가 자를 바이트 개수를 넘지 않도록 한다.
	 * 
	 * @param str
	 *            원본 String
	 * @param int 자를 바이트 개수
	 * @return String 절단된 String
	 */
	public static String cutInStringByBytes(String str, int length) {
		byte[] bytes = str.getBytes();
		int len = bytes.length;
		int counter = 0;
		if (length >= len) {
			return str;// + spaces(length - len);
		}
		for (int i = length - 1; i >= 0; i--) {
			if (((int) bytes[i] & 0x80) != 0)
				counter++;
		}
		return new String(bytes, 0, length - (counter % 2));
	}
}
