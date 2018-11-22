package meng;

import java.io.File;

public class ChangeName {
	public static void main(String[] args) {
		
		File fi=new File("D:/file/001/");
		fi.renameTo(new File("D:/file/001/"));
	}
}
