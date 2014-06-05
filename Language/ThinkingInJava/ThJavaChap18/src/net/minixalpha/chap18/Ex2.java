package net.minixalpha.chap18;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

class SortedDirList {
	private String[] fileList;

	public SortedDirList(String path) {
		File file = new File(path);
		fileList = file.list();
		Arrays.sort(fileList);
	}

	public String[] list() {
		return fileList;
	}

	public String[] list(String regex) {
		Pattern pattern = Pattern.compile(regex);
		String[] filterFileList = new String[fileList.length];
		int j = 0;
		for (String path : fileList) {
			if (pattern.matcher(path).matches()) {
				filterFileList[j++] = path;
			}
		}
		return Arrays.copyOf(filterFileList, j);
	}

}

public class Ex2 {
	public static void main(String[] args) {
		SortedDirList list = new SortedDirList(".");
		System.out.println(Arrays.toString(list.list()));
		System.out.println(Arrays.toString(list.list("^\\..+")));
	}
}
