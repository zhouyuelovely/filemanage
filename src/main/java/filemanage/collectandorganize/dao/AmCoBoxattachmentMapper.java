package filemanage.collectandorganize.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.pojo.ArchiveFile;

@Repository
public interface AmCoBoxattachmentMapper {
	/**
	 *根据盒子主键查询盒子附件信息
	 * @param boxId
	 * @return
	 */
	AmCoBoxattachment queryAmCoBoxattachment(String boxId);
}
