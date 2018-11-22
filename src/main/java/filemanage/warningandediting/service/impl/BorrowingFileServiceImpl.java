package filemanage.warningandediting.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.warningandediting.dao.BorrowingFileMapper;
import filemanage.warningandediting.pojo.BorrowingFile;
import filemanage.warningandediting.service.BorrowingFileService;

@Service("borrowingFileService")
public class BorrowingFileServiceImpl implements BorrowingFileService {

	@Autowired
	private BorrowingFileMapper bm;

	/**
	 * 查询所有未归还档案
	 */
	@Override
	public List<BorrowingFile> queryBorrowingFile(int before, int after) throws Exception {
		return bm.queryBorrowingFile(before, after);
	}

	/**
	 * 统计未归还档案数量
	 */
	@Override
	public Integer countBorrowingFile() throws Exception {
		return bm.countBorrowingFile();
	}

	/**
	 * 预警天数集合用到
	 */
	@Override
	public List<BorrowingFile> queryAllBorrowingFile() throws Exception {
		return bm.queryAllBorrowingFile();
	}

	/**
	 * 根据预警天数查询信息
	 */
	@Override
	public List<BorrowingFile> queryByEndDate(int before, int after, String endDate) throws Exception {
		return bm.queryByEndDate(before, after, endDate);
	}

	/**
	 * 统计根据预警天数查询信息
	 */
	@Override
	public Integer countByEndDate(String endDate) throws Exception {
		return bm.countByEndDate(endDate);
	}

	@Override
	public Integer countByZeroDate() throws Exception {
		return bm.countByZeroDate();
	}

}
