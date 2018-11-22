package filemanage.collectandorganize.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.collectandorganize.dao.FilePackingBoxMapper;
import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.service.FilePackingBoxService;
import filemanage.collectandorganize.vo.AmCoArchivefile;
import filemanage.systemmanage.pojo.AmCoBox;



/**
 * 档案整理	 >>	       文件装盒页面
 * @author 陈一达
 * serviceImpl
 */
@Service("FilePackingBoxService")
public class FilePackingBoxServiceImpl implements FilePackingBoxService{

	/**
	 * 调用DAO层接口
	 */
	@Autowired
	private FilePackingBoxMapper fpbm;
	/**
	 * 该全宗下的年度查询
	 */
	@Override
	public List<AmCoArchivefile> filePackingBoxAnnualQuery(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fpbm.filePackingBoxAnnualQuery(map);
	}

	/**
	 * 该全宗下的年度下的保管期限查询
	 */
	@Override
	public List<AmCoArchivefile> filePackingBoxsafekeepingTermQuery(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fpbm.filePackingBoxsafekeepingTermQuery(map);
	}

	/**
	 * 该全宗下的年度下的保管期限下的一级分类查询
	 */
	@Override
	public List<AmCoArchivefile> filePackingBoxArchivesPrimaryQuery(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fpbm.filePackingBoxArchivesPrimaryQuery(map);
	}
	
	/**
	 * 该全宗下的年度下的保管期限下的一级分类下的二级分类查询
	 */
	@Override
	public List<AmCoArchivefile> filePackingBoxArchiveSsecondaryQuery(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fpbm.filePackingBoxArchiveSsecondaryQuery(map);
	}

	/**
	 * 该全宗下的年度下的保管期限下的一级分类下的二级分类查询下的所有文件	(可根据关键词查询)
	 */
	@Override
	public List<AmCoArchivefile> filePackingBoxALLQuery(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fpbm.filePackingBoxALLQuery(map);
	}

	/**
	 * 该全宗下的年度下的保管期限下的一级分类下的二级分类查询下的所有文件	(可根据关键词查询)(总数)
	 */
	@Override
	public int filePackingBoxALLQueryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fpbm.filePackingBoxALLQueryCount(map);
	}

	
	
	
	/**
	 * 生成档号更新文件表	(全宗号-一级分类代码•年度-保管期限代码-机构问题代码-件号)
	 */
	@Override
	public Integer updateFileNumber(AmCoArchivefile amcoarchivefile) {
		// TODO Auto-generated method stub
		return fpbm.updateFileNumber(amcoarchivefile);
	}

	/**
	 * 根据全宗ID查询全宗号
	 * @param amcoarchivefile
	 * @return
	 */
	@Override
	public String queryQuanzongNumber(String quanzongId) {
		// TODO Auto-generated method stub
		return fpbm.queryQuanzongNumber(quanzongId);
	}

	/**
	 * 根据一级分类主键查询一级分类代码
	 * @param amcoarchivefile
	 * @return
	 */
	@Override
	public String queryPCCode(String primaryclassificationid) {
		// TODO Auto-generated method stub
		return fpbm.queryPCCode(primaryclassificationid);
	}

	/**
	 * 根据保管期限ID查询保管期限代码 
	 * @param amcoarchivefile
	 * @return
	 */
	@Override
	public String queryRetentionperiodCode(String retentionperiodid) {
		// TODO Auto-generated method stub
		return fpbm.queryRetentionperiodCode(retentionperiodid);
	}

	/**
	 * 根据二级分类ID查询二级分类代码 
	 * @param amcoarchivefile
	 * @return
	 */
	@Override
	public String querySCCode(String retentionperiodid) {
		// TODO Auto-generated method stub
		return fpbm.querySCCode(retentionperiodid);
	}
	
	/**
	 * 进行文件装盒操作(更新文件表装盒的文件，添加盒主键)		(②	盒编号格式：全宗号-年度-保管期限代码-盒号 	盒编号根据格式生成，确定盒的唯一性) -->
	 */
	@Override
	public Integer updateFilePackingBox(AmCoArchivefile amcoarchivefile) {
		// TODO Auto-generated method stub
		return fpbm.updateFilePackingBox(amcoarchivefile);
	}

	/**
	 * 更新盒表（添加盒内情况说明）以及生成盒属性并更新盒表
	 */
	@Override
	public Integer updatePackingBox(AmCoBox amcobox) {
		// TODO Auto-generated method stub
		return fpbm.updatePackingBox(amcobox);
	}

	/**
	 * 档案合计(可根据关键词)
	 */
	@Override
	public Integer countFilePackingBox(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fpbm.countFilePackingBox(map);
	}

	/**
	 * 档案页数合计(可根据关键词)
	 */
	@Override
	public Integer countArchivefilePages(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fpbm.countArchivefilePages(map);
	}
	/**
	 * 查看该盒的盒号是否存在并计算最大的盒号 
	 * @param amcobox
	 * @return
	 */
	@Override
	public List<AmCoBox> queryMaxBoxNumber(AmCoBox amcobox) {
		// TODO Auto-generated method stub
		return fpbm.queryMaxBoxNumber(amcobox);
	}
	/**
	 * 填充档案盒的数据
	 * @return
	 */
	@Override
	public Integer insertAmCoBox(AmCoBox amcobox) {
		// TODO Auto-generated method stub
		return fpbm.insertAmCoBox(amcobox);
	}
	/**
	 * 添加档案盒附近的数据
	 * @param amcoboxattachment
	 * @return
	 */
	@Override
	public Integer insertAmCoBoxattachment(AmCoBoxattachment amcoboxattachment) {
		// TODO Auto-generated method stub
		return fpbm.insertAmCoBoxattachment(amcoboxattachment);
	}
	
	/**
	 * 生成档案盒路径
	 */
	@Override
	public List<FileAttachment> fileAttachmentPathQuery(FileAttachment fileattachment) {
		// TODO Auto-generated method stub
		return fpbm.fileAttachmentPathQuery(fileattachment);
	}
	/**
	 * 根据盒表的文件主键规则查询相应的盒号
	 * @param amcoarchivefile
	 * @return
	 */
	@Override
	public List<AmCoBox> boxNumberQueryList(AmCoBox amcobox) {
		// TODO Auto-generated method stub
		return fpbm.boxNumberQueryList(amcobox);
	}
	/**
	 * 根据文件主键查询文件提名
	 * @param amcoarchivefile
	 * @return
	 */
	@Override
	public List<AmCoArchivefile> archivefiletitleQuery(AmCoArchivefile amcoarchivefile) {
		// TODO Auto-generated method stub
		return fpbm.archivefiletitleQuery(amcoarchivefile);
	}
	
	
	/**
	 * Excel生成数据查询
	 */
	@Override
	public List<AmCoArchivefile> ExcelQuery(AmCoArchivefile amcoarchivefile) {
		// TODO Auto-generated method stub
		return fpbm.ExcelQuery(amcoarchivefile);
	}
	/**
	 * 该全宗下的年度下的保管期限下的一级分类下的二级分类查询下的所有文件	(可根据关键词查询)(分页)
	 * @return
	 */
	@Override
	public List<AmCoArchivefile> pagingDataQuery(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fpbm.pagingDataQuery(map);
	}

	/**
	 * 根据指定的封面文件主键获取页数，档号（截取件号）
	 * @param amcoarchivefile
	 * @return
	 */
	@Override
	public List<AmCoArchivefile> getFileNumber(AmCoArchivefile amcoarchivefile) {
		// TODO Auto-generated method stub
		return fpbm.getFileNumber(amcoarchivefile);
	}
	/**
	 * 根据文件编号跟新备注
	 * @param amcoarchivefile
	 * @return
	 */
	@Override
	public Integer updateArchivefileremark(AmCoArchivefile amcoarchivefile) {
		// TODO Auto-generated method stub
		return fpbm.updateArchivefileremark(amcoarchivefile);
	}

}
