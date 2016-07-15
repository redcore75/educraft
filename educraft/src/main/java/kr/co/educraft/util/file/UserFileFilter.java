package kr.co.educraft.util.file;

import java.io.*;

public class UserFileFilter implements FilenameFilter {
	private String search;

	public UserFileFilter(String search) {
		this.search = search;
	}

	public boolean accept(File pathName, String fileName) {
		boolean isFile = false;
		if (fileName.indexOf(search) >= 0)
			isFile = true;
		return isFile;
	}
}
