package filemanage.warningandediting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.warningandediting.dao.ExpiredFileMapper;
import filemanage.warningandediting.pojo.ExpiredFile;
import filemanage.warningandediting.service.ExpiredFileService;

@Service("expiredFileService")
public class ExpiredFileServiceImpl implements ExpiredFileService {

	@Autowired
	private ExpiredFileMapper efm;

	/**
	 * 查询所有到期档案
	 */
	@Override
	public List<ExpiredFile> queryAllExpiredFile(int before, int after) throws Exception {
		return efm.queryAllExpiredFile(before, after);
	}

	/**
	 * 统计到期档案数量
	 */
	@Override
	public Integer countExpiredFile() throws Exception {
		return efm.countExpiredFile();
	}

	/**
	 * 查询所有全宗名
	 */
	@Override
	public List<ExpiredFile> queryAllQzName() throws Exception {
		return efm.queryAllQzName();
	}

	/**
	 * 用于预警天数的跳转
	 */
	@Override
	public List<ExpiredFile> queryExpiredFile() throws Exception {
		return efm.queryExpiredFile();
	}

	/**
	 * 根据全宗名查看文件
	 */
	@Override
	public List<ExpiredFile> queryFileByQzName(int before, int after, String qzName) throws Exception {
		return efm.queryFileByQzName(before, after, qzName);
	}

	/**
	 * 统计根据全宗名查看文件
	 */
	@Override
	public int countFileByQzName(String qzName) throws Exception {
		return efm.countFileByQzName(qzName);
	}

	/**
	 * 根据预警天数查看文件
	 */
	@Override
	public List<ExpiredFile> queryFileBySurplusDays(int before, int after, String saveDays) throws Exception {
		return efm.queryFileBySurplusDays(before, after, saveDays);
	}

	/**
	 * 统计根据预警天数查看文件
	 */
	@Override
	public int countFileBySurplusDays(String saveDays) throws Exception {
		return efm.countFileBySurplusDays(saveDays);
	}

}
