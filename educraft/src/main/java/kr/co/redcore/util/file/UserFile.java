package kr.co.redcore.util.file;

import java.io.*;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserFile {
	private static final Logger logger = LoggerFactory.getLogger(UserFile.class);

	public boolean copyToFile(String src, String des) {
		boolean retVal = true;

		try {
			FileInputStream fin = new FileInputStream(src);
			BufferedInputStream bin = new BufferedInputStream(fin);
			FileOutputStream fout = new FileOutputStream(des);
			BufferedOutputStream bout = new BufferedOutputStream(fout);

			int data = 0;
			while ((data = bin.read()) != -1) {
				bout.write(data);
			}

			bout.flush();
			bout.close();
			fout.close();

			bin.close();
			fin.close();
		} catch (IOException ex) {
			logger.error(ex.getMessage(), ex);
			retVal = false;
		}

		return retVal;
	}

	public boolean moveToFile(String src, String des) {
		boolean retVal = true;

		if (copyToFile(src, des)) {
			deleteFile(src);
		} else {
			retVal = false;
		}

		return retVal;
	}

	public boolean deleteFile(String src) {
		File fp = new File(src);
		return fp.delete();
	}

	public boolean deleteFiles(String pathName, String search) {
		UserFileFilter filter = new UserFileFilter(search);
		File dir = new File(pathName);
		String list[] = dir.list(filter);
		if (list.length < 1) {
			return false;
		}

		for (int i = 0; i < list.length; i++) {
			File fp = new File(pathName + list[i]);
			fp.delete();
		}

		return true;
	}

	public static byte[] loadFile(String fileName) throws IOException {
		File file = new File(fileName);
		return FileUtils.readFileToByteArray(file);
	}

	public static void saveFile(String fileName, byte[] data) throws IOException {
		FileUtils.writeByteArrayToFile(new File(fileName), data);
	}
}
