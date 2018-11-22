package filemanage.inventoryandinquire.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filemanage.inventoryandinquire.dao.CascadingMapper;
import filemanage.inventoryandinquire.service.CascadingService;
import filemanage.systemmanage.pojo.PrimaryClassFication;
import filemanage.systemmanage.pojo.SecondryClassFication;
@Service("cascadingService")
public class CascadingServiceImpl implements CascadingService {
	
	@Autowired
	private CascadingMapper cascadingMapper;
	
	/**
	 * 查询一级分类(档案类型)
	 */
	@Override
	public List<PrimaryClassFication> getPrimaryClassList() throws Exception {
		return cascadingMapper.getPrimaryClassList();
	}
	
	/**
	 * 根据一级分类(档案类型)主键查询二级分类(问题、机构)名称集合
	 */
	@Override
	public List<SecondryClassFication> getSecondryClassListByPcId(String pcId) throws Exception {
		return cascadingMapper.getSecondryClassListByPcId(pcId);
	}

	
}
