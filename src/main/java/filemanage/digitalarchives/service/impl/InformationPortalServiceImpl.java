package filemanage.digitalarchives.service.impl;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filemanage.digitalarchives.dao.InformationPortalMapper;
import filemanage.digitalarchives.pojo.InformationPortal;
import filemanage.digitalarchives.pojo.Picturecarousel;
import filemanage.digitalarchives.service.InformationPortalService;
import filemanage.digitalarchives.vo.QueryInforByConditions;


/**
 * @author tchuanwu
 * 档案信息门户业务层实现类
 */
@Transactional
@Service("informationPortalService")
public class InformationPortalServiceImpl implements InformationPortalService {
	
	@Autowired
	private InformationPortalMapper informationPortalMapper;
	private Logger logger=Logger.getLogger(InformationPortalServiceImpl.class);

	@Override
	public List<InformationPortal> queryAllInformation(int before,int after) {
		 logger.info("查询所有已发布的信息");
		return informationPortalMapper.queryAllInformation(before,after);
	}

	@Override
	public InformationPortal queryInformationById(String IPId) {
		   logger.info("根据主键查询信息");
		return informationPortalMapper.queryInformationById(IPId);
	}

	@Override
	public Integer addInformationPortal(InformationPortal information) {
		  logger.info("添加信息");
		return informationPortalMapper.addInformationPortal(information);
	}

	@Override
	public List<InformationPortal> queryInfomationByTime() {
		 logger.info("根据发布日期降序排序查询最新的7条数据");
		return informationPortalMapper.queryInfomationByTime();
	}

	

	@Override
	public int isExitInformationIndexNum(InformationPortal information) {
		 logger.info("判断索引号是否已存在");
		return informationPortalMapper.isExitInformationIndexNum(information);
	}

	@Override
	public int isExitInformationDocumentNum(InformationPortal information) {
		 logger.info("判断文号是否已存在");
		return informationPortalMapper.isExitInformationDocumentNum(information);
	}

	@Override
	public Integer countAllInformation() {
		logger.info("统计所有已发布信息的数量 ");
		return informationPortalMapper.countAllInformation();
	}

	@Override
	public List<InformationPortal> queryAllInformationType() {
		logger.info("查询所有的信息类型 ");
		return informationPortalMapper.queryAllInformationType();
	}

	

	

	@Override
	public int addPicturecarousel(Picturecarousel picturecarousel) {
		logger.info("图片发布轮播");
		return informationPortalMapper.addPicturecarousel(picturecarousel);
	}

	@Override
	public List<Picturecarousel> queryAllPicture() {
		List<Picturecarousel> lists=informationPortalMapper.queryAllPicture();
		if(lists.size()>0) {
			for (Picturecarousel picturecarousel : lists) {
				picturecarousel.setPcPhotoAddress(picturecarousel.getPcPhotoAddress().replaceAll("D:/file", "/resource/"));
			}
		}
		return lists;
	}

	@Override
	public Integer countAllPic() {
		logger.info("统计轮播图片条数");
		return informationPortalMapper.countAllPic();
	}

	@Override
	public List<InformationPortal> queryInforByConditions(QueryInforByConditions conditions) {
		
		return informationPortalMapper.queryInforByConditions(conditions);
	}

	@Override
	public int countQueryInforByConditions(QueryInforByConditions conditions) {
		
		return informationPortalMapper.countQueryInforByConditions(conditions);
	}

	@Override
	public Boolean deleteInfomationPortal() {
		
		return informationPortalMapper.deleteInfomationPortal();
	}

	@Override
	public Boolean deleteAllFile() {
		List<Picturecarousel> lists=informationPortalMapper.queryAllPicture();
		String path=null;
		File file=null;
		for (Picturecarousel picturecarousel : lists) {
			file=new File(picturecarousel.getPcPhotoAddress());
			file.delete();
		}
		return informationPortalMapper.deleteAllFile();
	}

	@Override
	public void deletePictureCarousel() {
		// TODO Auto-generated method stub
		
	}

	

	

	

}
