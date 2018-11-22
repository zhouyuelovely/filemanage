package filemanage.collectandorganize.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import filemanage.collectandorganize.pojo.ReturnInfoBox;
@Repository
public interface ReturnInfoBoxMapper {
	/**
	 * 查询驳回情况表
	 * @param anual 年度
	 * @param archiveId 全宗主键
	 * @return 驳回情况
	 */
	List<ReturnInfoBox> findReturnInfoBoxByAnualAndArchiveId(Map<String, Object> map);
	/**
	 * 统计驳回情况数量
	 * @param anual
	 * @param archiveId
	 * @return
	 */
	Integer countReturnInfoBoxByAnualAndArchiveId(@Param("anual")String anual,@Param("archiveId")String archiveId);
	/**
	 * 驳回重整后删除驳回情况表
	 * @param anual 年度
	 * @param archiveId 全宗主键
	 * @return
	 */
	Integer deleteReturnInfoBoxByAnualAndArchiveId(@Param("anual")String anual,@Param("archiveId")String archiveId,@Param("custody")String custody);
	
	/**
	 * 驳回重整_选中的信息弹出层显示
	 * @return
	 */
	List<ReturnInfoBox> selectAllRejectInfo(String boxNumber);
	
	/**
	 * 驳回重整_选中的信息弹出层显示
	 * @return
	 */
	int countSelectAllRejectInfo(String boxnumber);
	
	/**
	 * 驳回重整(添加选中的信息到数据库)
	 * @param returnInfoBox
	 * @return
	 */
	Integer addReject(ReturnInfoBox returnInfoBox);
}
