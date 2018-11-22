package filemanage.warningandediting.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.warningandediting.dao.EditingFileMapper;
import filemanage.warningandediting.pojo.EditingFile;
import filemanage.warningandediting.service.EditingFileService;

@Service("editingFileService")
public class EditingFileServiceImpl implements EditingFileService {

	@Autowired
	private EditingFileMapper em;

	/**
	 * 查询所有编研文件
	 */
	@Override
	public List<EditingFile> queryEditingFile(int before, int after) throws Exception {
		return em.queryEditingFile(before, after);
	}

	/**
	 * 统计编研文件数量
	 */
	@Override
	public Integer countEditingFile() throws Exception {
		return em.countEditingFile();
	}

	/**
	 * 查看边沿内容
	 */
	@Override
	public EditingFile queryEditingFileBody(String editingId) throws Exception {
		return em.queryEditingFileBody(editingId);
	}

	/**
	 * 查询所有编研类型
	 */
	@Override
	public List<EditingFile> queryEditingFileType() throws Exception {
		return em.queryEditingFileType();
	}

	/**
	 * 查询所有编研日期
	 */
	@Override
	public List<EditingFile> queryEditingFileDate() throws Exception {
		return em.queryEditingFileDate();
	}

	/**
	 * 搜索框模糊查询
	 */
	@Override
	public List<EditingFile> fuzzyEditingFile(int before, int after, String searchBody) throws Exception {
		return em.fuzzyEditingFile(before, after, searchBody);
	}

	/**
	 * 统计模糊查询条数
	 */
	@Override
	public Integer countFuzzyEditingFile(String searchBody) throws Exception {
		return em.countFuzzyEditingFile(searchBody);
	}

	/**
	 * 下拉查看文件
	 */
	@Override
	public List<EditingFile> queryEditingFileByType(int before, int after, String editingTypeName) throws Exception {
		return em.queryEditingFileByType(before, after, editingTypeName);
	}

	/**
	 * 统计下拉查看文件
	 */
	@Override
	public Integer countQueryEditingFileByType(String editingTypeName) throws Exception {
		return em.countQueryEditingFileByType(editingTypeName);
	}

	/**
	 * 根据编研时间查看文件
	 */
	@Override
	public List<EditingFile> queryEditingFileByDate(int before, int after, Date editingDate) throws Exception {
		return em.queryEditingFileByDate(before, after, editingDate);
	}

	/**
	 * 统计根据编研时间查看文件
	 */
	@Override
	public Integer countQueryEditingFileByDate(Date editingDate) throws Exception {
		return em.countQueryEditingFileByDate(editingDate);
	}

	/**
	 * 删除编研文件
	 */
	@Override
	public Integer deleteEditingFile(String editingId) throws Exception {
		return em.deleteEditingFile(editingId);
	}

	/**
	 * 查询所有编研文件
	 */
	@Override
	public List<EditingFile> queryAllEditingFile() throws Exception {
		return em.queryAllEditingFile();
	}

	/**
	 * 添加编研文件
	 */
	@Override
	public Integer addEditingFile(EditingFile editingFile) {
		return em.addEditingFile(editingFile);
	}

	/**
	 * 查询类型主键
	 */
	@Override
	public EditingFile queryByTypeName(String editingTypeName) {
		return em.queryByTypeName(editingTypeName);
	}

	/**
	 * 修改编研文件
	 */
	@Override
	public Integer updateEditingFile(EditingFile editingFile) {
		return em.updateEditingFile(editingFile);
	}

}
