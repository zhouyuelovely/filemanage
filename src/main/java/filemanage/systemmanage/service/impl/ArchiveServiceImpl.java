package filemanage.systemmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.systemmanage.dao.ArchiveMapper;
import filemanage.systemmanage.pojo.Archive;
import filemanage.systemmanage.service.ArchiveService;

/**
 * @author MLT
 *
 */
@Service("ArchiveService")
public class ArchiveServiceImpl implements ArchiveService {

	@Autowired
	private ArchiveMapper archiveMapper;

	/**
	 * 添加全宗
	 */
	@Override
	public Boolean addOneArchive(Archive archive) {
		return archiveMapper.addOneArchive(archive) > 0;
	}

	/**
	 * 判断全宗号是否存在
	 */
	@Override
	public int isExitArchiveNumber(Archive archive) {
		return archiveMapper.isExitArchiveNumber(archive);
	}

	/**
	 * 判断全宗名是否存在
	 */
	@Override
	public int isExitArchiveName(Archive archive) {
		return archiveMapper.isExitArchiveName(archive);
	}
	
	/**
	 * 判断单位电话是否存在
	 */
	@Override
	public int isExitArchivePhone(Archive archive) {
		return archiveMapper.isExitArchivePhone(archive);
	}

	/**
	 * 删除全宗
	 */
	@Override
	public Boolean deleteOneArchive(String quanzongId) {
		return archiveMapper.deleteOneArchive(quanzongId) > 0;
	}
	/**
	 * 删除前查询全宗下有无书局 
	 */
	@Override
	public int countArchiveLinkInfo(String quanzongId) {
		return archiveMapper.countArchiveLinkInfo(quanzongId);
	}

	/**
	 * 编辑全宗
	 */
	@Override
	public Boolean updateOneArchive(Archive archive) {
		return archiveMapper.updateOneArchive(archive) > 0;
	}

	/**
	 * 列表展示全宗信息
	 */
	@Override
	public Archive queryArchiveById(String quanzongId) {
		return archiveMapper.queryArchiveById(quanzongId);
	}

	/**
	 * 列表展示全宗信息
	 */
	@Override
	public List<Archive> selectAllArchive() {
		return archiveMapper.selectAllArchive();
	}

	/**
	 * 批量导入去重查询
	 */
	@Override
	public Integer countAllByImportArchive(Archive archive) {
		return archiveMapper.countAllByImportArchive(archive);
	}

	/**
	 * 全宗管理_关键词查询
	 */
	@Override
	public List<Archive> queryArchiveByArchiveQueryCondition(Archive archive) {
		return archiveMapper.queryArchiveByArchiveQueryCondition(archive);
	}

	/**
	 * 统计全部全宗数目
	 */
	@Override
	public int countAllArchive() {
		return archiveMapper.countAllArchive();
	}

	/**
	 * 全宗查询关键词数
	 */
	@Override
	public int countArchiveByConditions(String conditions) {
		return archiveMapper.countArchiveByConditions(conditions);
	}

}
