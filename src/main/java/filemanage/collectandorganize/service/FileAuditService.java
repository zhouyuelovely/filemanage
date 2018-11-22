package filemanage.collectandorganize.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import filemanage.collectandorganize.pojo.ReturnInfoBox;
import filemanage.collectandorganize.vo.BoxAuditHelp;
import filemanage.collectandorganize.vo.BoxByCondition;
import filemanage.collectandorganize.vo.BoxPageInfo;
import filemanage.collectandorganize.vo.BoxVo;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.utils.layui.Layui;

/**
 * @author MLT 档案审核
 *
 */
public interface FileAuditService {
	/**
	 * 返回盒子的信息
	 * @return 
	 */
	Layui findAmcBox(Integer limit,Integer page);
	/**
	 * 获取盒子页数的信息
	 * @return 盒子信息组装
	 */
	BoxPageInfo havingPageInfo();
	/**
	 * 获取盒子拥有的全宗信息
	 * @return
	 */
	List<BoxAuditHelp> listArchiveInfo();
	/**
	 * 更具全宗主键获取审核的全部年度
	 * @return 
	 */
	List<BoxAuditHelp> listAnualByArchiveId(String archiveId);
	/**
	 * 根据全宗主键和年度进行筛选
	 * @param anual 年度
	 * @param archiveId 全宗主键
	 * @return
	 */
	Layui findAmcBoxAnualAndArchiveId(String anual,String archiveId,Integer limit,Integer page);
	/**
	 * 根据全宗主键和年度查询
	 * @param anual 年度
	 * @param archiveId 全宗主键
	 * @return
	 */
	BoxPageInfo havingPageInfoAnualAndArchiveId(String anual,String archiveId);
	/**
	 * 条件查询盒子信息
	 * @param boxByCondition 盒子信息：可能存在年度，全宗主键，条件
	 * @return
	 */
	Layui findAmcBoxCondition(BoxByCondition boxByCondition,Integer limit,Integer page);
	
	/**
	 * 条件查询盒子信息
	 * @param boxByCondition 盒子信息：可能存在年度，全宗主键，条件
	 * @return
	 */
	BoxPageInfo havingPageInfofindAmcBoxCondition(BoxByCondition boxByCondition);
	/**
	 * 验收合格
	 * @param anual 年度
	 * @param archiveId 全宗主键
	 * @return 
	 */
	Boolean updateGood(@Param("anual")String anual,@Param("archiveId")String archiveId);
	/**
	 * 驳回重整
	 * @param anual 年度
	 * @param archiveId 全宗主键
	 * @return
	 */
	Boolean updateBad(@Param("anual")String anual,@Param("archiveId")String archiveId);
	/**
	 * 添加驳回情况表
	 * @param returnInfoBox 驳回情况
	 * @return
	 */
	Boolean addReturnFor(ReturnInfoBox returnInfoBox);
	/**
	 * 根据盒主键查询驳回情况表是否有信息
	 * @param boxVo
	 * @return
	 */
	Integer queryReturnFor(String boxId);
	/**
	 * 更新驳回情况
	 * @param returnInfoReson
	 * @param returnInfoId
	 * @return
	 */
	Boolean updateReturnFor(@Param("returnInfoReson")String returnInfoReson,@Param("returnInfoId")String returnInfoId);
	
}
