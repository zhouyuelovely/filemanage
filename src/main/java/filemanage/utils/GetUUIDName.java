package filemanage.utils;

import java.util.UUID;

public class GetUUIDName {
	// 生成 UUID
	public static String getUUID() {

		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
