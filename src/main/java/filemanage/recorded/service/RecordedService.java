package filemanage.recorded.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import filemanage.recorded.vo.ArchiveFileAddHelp;
import filemanage.recorded.vo.BoxAddHelp;
import filemanage.recorded.vo.ConditionHelp;
import filemanage.recorded.vo.GdFileArray;
import filemanage.recorded.vo.PreparationFormHelp;
import filemanage.recorded.vo.RecodedTableSelect;
import filemanage.recorded.vo.RecordedTableCountHelp;
import filemanage.recorded.vo.SelectQueryHelp;
import filemanage.recorded.vo.TableContentInfor;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.utils.layui.Layui;

/**
 * @author meng
 *
 */
public interface RecordedService {
//==============================================历史档案============================================
	/**
	 * 保存泰坦格式的文件 
	 * @param zipFile 上传的文件信息 
	 * @param chunk 当前片数
	 * @param chunks 总的片数
	 * @param path 保存路径
	 * @return
	 */
	Boolean addHistoryTaitan(MultipartFile zipFile,Integer chunk,Integer chunks,String path);
//=====================================================新建档案=======================================
	/**
	 * 获取归档文件目录的信息
	 * @param file 归档文件目录绝对路径
	 * @return
	 */
	TableContentInfor havingTableContentInfor(String file);
	/**
	 * 获取全宗号
	 * @return
	 */
	List<ConditionHelp> findQuanzongNumber();
	/**
	 * 获取全宗名
	 * @return
	 */
	List<ConditionHelp> findQuanzongName();
	/**
	 * 获取一级分类
	 * @return
	 */
	List<ConditionHelp> findPcId();
	/**
	 * 获取二级分类
	 * @return
	 */
	List<ConditionHelp> findScId();
	/**
	 * 获取保管期限
	 * @return
	 */
	List<ConditionHelp> findRetentionperiodName();
	/**
	 * 获取盒属性
	 * @return
	 */
	List<ConditionHelp> findBoxpropertyPag();
	/**
	 * 保存盒子信息
	 * @param file 备考表文件
	 * @param preparationFormHelp 盒子的相关信息
	 * @param srcImage 盒面盒脊基础图片位置
	 * @return
	 */
	String saveBoxInfor(MultipartFile file);
	/**
	 * 获取盒子内文件
	 * @param boxId 盒子主键
	 * @return
	 */
	Layui havingFileByBoxId(String boxId,Integer limit,Integer page);
	/**
	 * 保存文件信息
	 * @param file 上传的文件
	 * @param boxId 盒子主键
	 * @return
	 */
	String saveFileInfor(MultipartFile file,String boxId);
	/**
	 * 更新文件信息
	 * @param fileId 文件主键
	 * @param content 字段名
	 * @param value 字段值
	 * @return
	 */
	Boolean updateFileInfor(String fileId,String content,String value);
	/**
	 * 获取文件附件的集合
	 * @param archiveFileId 文件主键
	 * @return
	 */
	List<String> havingFileAtta(String archiveFileId);
	/**
	 * 条件查询文件 
	 * @param boxId 盒子主键
	 * @param start 状态
	 * @param limit 大小
	 * @param page 页数
	 * @return
	 */
	Layui findArchiveFileByBoxIdAndStart(String boxId,String start,Integer limit,Integer page);
	/**
	 * 更新文件的状态
	 * @param boxId
	 * @return
	 */
	String updataBoxStart(PreparationFormHelp preparationFormHelp,String srcImage);
//=====================================================著录列表=====================================
	/**
	 * 著录列表一级分类
	 * @param quanzongId
	 * @return
	 */
	List<RecodedTableSelect> findSeelectPc(String quanzongId);
	/**
	 * 获取年度
	 * @param map 全宗和一级分类
	 * @return
	 */
	List<String> findSelectAnual(String quanzongId);
	/**
	 * 著录列表
	 * @param quanzongId 全宗主键
	 * @param limit 大小
	 * @param page 当前页数
	 * @return
	 */
	Layui havingAmCoBoxByQuanzongId(String quanzongId,Integer limit,Integer page);
	/**
	 * select 著录列表
	 * @param quanzongId 全宗主键
	 * @param selectQueryHelp select内容
	 * @param limit 大小
	 * @param page 当前页数
	 * @return
	 */
	Layui havingAmCoBoxBySelect(String quanzongId,SelectQueryHelp selectQueryHelp,Integer limit,Integer page);
	/**
	 * 条件 著录列表
	 * @param quanzongId 全宗主键
	 * @param condition 条件
	 * @param limit 大小
	 * @param page 当前页数
	 * @return
	 */
	Layui havingAmCoBoxByCondition(String quanzongId,String condition,Integer limit,Integer page);
	/**
	 * 删除盒子
	 * @param boxId 盒子主键（删除文件信息，文件附件信息，盒子信息，盒子附件信息）
	 * @return
	 */
	Boolean deleteBox(String boxId);
	/**
	 * 盒子和文件数量
	 * @param quanzongId 全宗主键
	 * @param limit 大小
	 * @param page 页数
	 * @return
	 */
	RecordedTableCountHelp havingFileAmCoBoxByQuanzongId(String quanzongId,Integer limit,Integer page);
	/**
	 * select 盒子和文件数量
	 * @param quanzongId 全宗主键
	 * @param selectQueryHelp select信息
	 * @param limit 大小
	 * @param page 当前页数
	 * @return
	 */
	RecordedTableCountHelp havingFileAmCoBoxBySelect(String quanzongId,SelectQueryHelp selectQueryHelp);
	/**
	 * condition 盒子和文件数量
	 * @param quanzongId 全宗id
	 * @param condition 条件
	 * @param limit 大小
	 * @param page 当前页数
	 * @return
	 */
	RecordedTableCountHelp havingFileAmCoBoxByCondition(String quanzongId,String condition);
	/**
	 * 提交进馆
	 * @param str 盒子主键的集合
	 * @return
	 */
	Boolean updateBoxStart(String str);
//======================================================添加盒内文件================================================
	/**
	 * 盒子信息
	 * @param boxId 盒子主键
	 * @return
	 */
	AmCoBox findAmCoBoxByBoxId(String boxId);
	/**
	 * 添加备考表
	 * @param file 文件
	 * @param boxId 盒子主键
	 * @return
	 */
	String updateAmCoBoxattachment(MultipartFile file,String boxId);
	/**
	 * 备考表地址
	 * @param boxId 盒子主键
	 * @return
	 */
	String havingBoxForm(String boxId);
	/**
	 * 保存盒子信息
	 * @param preparationFormHelp 盒子信息
	 * @param srcImage 水印地址
	 * @return
	 */
	String saveBox(PreparationFormHelp preparationFormHelp,String srcImage);
	/**
	 * 手动注入添加盒子文件信息
	 */
	String saveBoxs(HttpServletRequest request);
	
	/**
	 * 
	 * @param listFile
	 * @param path
	 * @return
	 */
	public Map<String, Object> havingHistory(List<String> listFile,String path);
//==========================================历史数据导出=======================================
	/**
	 * 泰坦数据导出
	 * @param ids 泰坦数据主键集合
	 * @param remark 标记,1：新建数据;2:历史数据
	 * @return
	 */
	String expectHistory(String ids,String remark) throws Exception;
}
