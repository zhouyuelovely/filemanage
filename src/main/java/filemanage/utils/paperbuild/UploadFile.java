package filemanage.utils.paperbuild;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadFile extends Thread {
	private Logger log = Logger.getLogger(UploadFile.class);
	private CommonsMultipartFile file;
	private String saveDirectoryPath;
	private long partLength;
	private long pointer = 0;

	UploadFile() {
		super();
	}

	public UploadFile(CommonsMultipartFile file, String saveDirectoryPath, long partLength, long pointer) {
		super();
		this.file = file;
		this.saveDirectoryPath = saveDirectoryPath;
		this.partLength = partLength;
		this.pointer = pointer;
	}

	@Override
	public void run() {
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(),
					new File(saveDirectoryPath, file.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public long getPointer() {
		return pointer;
	}

	class UploadFileInner {
		String srcPath;
		String desPath;
		int index;

		Boolean test(CommonsMultipartFile file, String saveDirectoryPath, int index) throws Exception {
			if (file.isEmpty()) {
				throw new Exception("上传文件为空--file=" + file);
			} else {
				long partLength;
				byte[] bt = file.getBytes();
				for (int i = 0; i < bt.length; i++) {
					partLength = bt.length / index + 1;
					new UploadFile(file, saveDirectoryPath, partLength * (i + 1), 0).start();
				}
				log.info("文件上传成功!");
			}
			return true;
		}

	}

}
