package filemanage.utils.paperbuild;

import java.io.File;
import java.io.RandomAccessFile;


public class FileThread extends Thread {
	private File srcFile;
	private File desFile;
	private long partLength;
	private long pointer = 0;

	FileThread() {
		super();
	}

	public FileThread(File srcFile, File desFile, long partLength, long pointer) {
		super();
		this.srcFile = srcFile;
		this.desFile = desFile;
		this.partLength = partLength;
		this.pointer = pointer;
	}

	@Override
	public void run() {
		RandomAccessFile rafSrc = null;
		RandomAccessFile rafDes = null;
		try {
			rafSrc = new RandomAccessFile(srcFile, "r");
			rafDes = new RandomAccessFile(desFile, "rw");

			rafSrc.seek(pointer);
			rafDes.seek(pointer);

			byte[] buffer = new byte[(int) partLength];
			int len = rafSrc.read(buffer);
			rafDes.write(buffer, 0, len);
			pointer = rafSrc.getFilePointer();
			rafDes.close();
			rafSrc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public long getPointer() {
		return pointer;
	}
}
