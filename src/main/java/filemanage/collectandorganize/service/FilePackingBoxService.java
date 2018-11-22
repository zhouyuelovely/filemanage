package filemanage.collectandorganize.service;

import java.util.List;
import java.util.Map;

import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.systemmanage.pojo.AmCoBox;

/**
 * 档案整理	 >>	       文件装盒页面
 * @author 陈一达
 * Service层
 */
public interface FilePackingBoxService {

	/**
	 * 该全宗下的年度查询
	 */
	List<AmCoArchivefile> filePackingBoxAnnualQuery(Map<String, Object> map);
	
	/**
	 * 该全宗下的年度下的保管期限查询
	 */
	List<AmCoArchivefile> filePackingBoxsafekeepingTermQuery(Map<String, Object> map);
	
	/**
	 * 该全宗下的年度下的保管期限下的一级分类查询
	 */
	List<AmCoArchivefile> filePackingBoxArchivesPrimaryQuery(Map<String, Object> map);
	
	/**
	 * 该全宗下的年度下的保管期限下的一级分类下的二级分类查询
	 */
	List<AmCoArchivefile> filePackingBoxArchiveSsecondaryQuery(Map<String, Object> map);
	
	/**
	 * 该全宗下的年度下的保管期限下的一级分类下的二级分类查询下的所有文件	(可根据关键词查询)
	 */
	List<AmCoArchivefile> filePackingBoxALLQuery(Map<String, Object> map);
	/**
	 * 该全宗下的年度下的保管期限下的一级分类下的二级分类查询下的所有文件	(可根据关键词查询)(总数)
	 */
	int filePackingBoxALLQueryCount(Map<String, Object> map);
	/**
	 * 该全宗下的年度下的保管期限下的一级分类下的二级分类查询下的所有文件	(可根据关键词查询)(分页)
	 * @return
	 */
	List<AmCoArchivefile> pagingDataQuery(Map<String, Object> map);
	/**
	 * 生成档号更新文件表	(全宗号-一级分类代码•年度-保管期限代码-机构问题代码-件号)
	 * @param amcoarchivefile
	 * @return
	 */
	Integer updateFileNumber(AmCoArchivefile amcoarchivefile);
	
	/**
	 * 进行文件装盒操作(更新文件表装盒的文件，添加盒主键)		(②	盒编号格式：全宗号-年度-保管期限代码-盒号 	盒编号根据格式生成，确定盒的唯一性) -->
	 * @param amcoarchivefile
	 * @return
	 */
	Integer updateFilePackingBox(AmCoArchivefile amcoarchivefile);
	
	/**
	 * 根据全宗ID查询全宗号
	 * @param amcoarchivefile
	 * @return
	 */
	String queryQuanzongNumber(String quanzongId);
	/**
	 * 根据一级分类主键查询一级分类代码
	 * @param amcoarchivefile
	 * @return
	 */
	String queryPCCode(String primaryclassificationid);
	/**
	 * 根据保管期限ID查询保管期限代码 
	 * @param amcoarchivefile
	 * @return
	 */
	String queryRetentionperiodCode(String retentionperiodid);
	/**
	 * 根据二级分类ID查询二级分类代码 
	 * @param amcoarchivefile
	 * @return
	 */
	String querySCCode(String secondaryclassificationid);
	
	/**
	 * 更新盒表（添加盒内情况说明）以及生成盒属性并更新盒表
	 * @param amcobox
	 * @return
	 */
	Integer updatePackingBox(AmCoBox amcobox);
	/**
	 * 查看该盒的盒号是否存在并计算最大的盒号 
	 * @param amcobox
	 * @return
	 */
	List<AmCoBox> queryMaxBoxNumber(AmCoBox amcobox);
	/**
	 * 填充档案盒的数据
	 * @return
	 */
	Integer insertAmCoBox(AmCoBox amcobox);
	
	/**
	 * 添加档案盒附近的数据
	 * @param amcoboxattachment
	 * @return
	 */
	Integer insertAmCoBoxattachment(AmCoBoxattachment amcoboxattachment);
	/**
	 * 档案合计(可根据关键词)
	 * @return
	 */
	Integer countFilePackingBox(Map<String, Object> map);
	
	/**
	 * 档案页数合计(可根据关键词)
	 * @return
	 */
	Integer countArchivefilePages(Map<String, Object> map);
	/**
	 * 获取档案盒路径
	 * @param fileattachment
	 * @return
	 */
	List<FileAttachment> fileAttachmentPathQuery(FileAttachment fileattachment);
	/**
	 * 根据盒表的文件主键规则查询相应的盒号
	 * @param amcoarchivefile
	 * @return
	 */
	List<AmCoBox> boxNumberQueryList(AmCoBox amcobox);
	
	/**
	 * 根据文件主键查询文件提名
	 * @param amcoarchivefile
	 * @return
	 */
	List<AmCoArchivefile> archivefiletitleQuery(AmCoArchivefile amcoarchivefile);
	
	/**
	 * Excel生成数据查询
	 * @param amcoarchivefile
	 * @return
	 */
	List<AmCoArchivefile> ExcelQuery(AmCoArchivefile amcoarchivefile);
	
	/**
	 * 根据指定的封面文件主键获取页数，档号（截取件号）
	 * @param amcoarchivefile
	 * @return
	 */
	List<AmCoArchivefile> getFileNumber(AmCoArchivefile amcoarchivefile);
	
	/**
	 * 根据文件编号跟新备注
	 * @param amcoarchivefile
	 * @return
	 */
	Integer updateArchivefileremark(AmCoArchivefile amcoarchivefile);
}
