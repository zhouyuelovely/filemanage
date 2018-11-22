package filemanage.recorded.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.recorded.vo.BoxAttachmentHelp;
import filemanage.systemmanage.pojo.AmCoBox;

@Repository
public interface RecordedEditMapper {
	/**
	 * 盒子主键查询盒子信息
	 * @param boxId 盒子主键
	 * @return
	 */
	AmCoBox findAmCoBoxByBoxId(String boxId);
	/**
	 * 添加备考表
	 * @param formAddress 备考表绝对路径
	 * @param boxId 盒子主键
	 * @return
	 */
	Boolean updateAmCoBoxattachment(@Param("formAddress")String formAddress,@Param("boxId")String boxId);
	/**
	 * 备考表地址
	 * @param boxId 盒子主键
	 * @return
	 */
	String havingBoxForm(String boxId);
	/**
	 * 更新文件附件信息
	 * @param boxAttachmentHelp 盒子附件
	 * @return
	 */
	Boolean updateAllAmCoBoxattachment(BoxAttachmentHelp boxAttachmentHelp);
}
