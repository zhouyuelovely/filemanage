package filemanage.collectandorganize.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import filemanage.collectandorganize.dao.AmCoBoxattachmentMapper;
import filemanage.collectandorganize.dao.ArchiveFileStoreMapper;
import filemanage.collectandorganize.dao.BoxSubmitReviewMapper;
import filemanage.collectandorganize.dao.ReturnInfoBoxMapper;
import filemanage.collectandorganize.pojo.AmCoBoxattachment;
import filemanage.collectandorganize.pojo.ArchiveFile;
import filemanage.collectandorganize.pojo.FileAttachment;
import filemanage.collectandorganize.pojo.ReturnInfoBox;
import filemanage.collectandorganize.service.BoxSubmitReviewService;
import filemanage.collectandorganize.vo.BoxByCondition;
import filemanage.collectandorganize.vo.BoxHavingRetentionperiodHelp;
import filemanage.collectandorganize.vo.BoxSubmitReview;
import filemanage.collectandorganize.vo.BoxSubmitReviewAnualHelp;
import filemanage.collectandorganize.vo.ExaminaBoxHelp;
import filemanage.collectandorganize.vo.HavingInforBox;
import filemanage.login.pojo.User;
import filemanage.login.util.getUser.HavingUserInfor;
import filemanage.systemmanage.pojo.AmCoBox;
import filemanage.systemmanage.pojo.Archive;
import filemanage.utils.aop.LoggingTool;
import filemanage.utils.layui.Layui;
import filemanage.utils.page.PageBean;
import filemanage.utils.shuiYinTool.SealTools;
@Service("boxSubmitReviewService")
public class BoxSubmitReviewServiceImple implements BoxSubmitReviewService{
	@Autowired//体检审核
	private BoxSubmitReviewMapper boxSubmitReviewMapper;
	@Autowired//文件
	private ArchiveFileStoreMapper archiveFileStoreMapper;
	@Autowired//盒子附件
	private AmCoBoxattachmentMapper amCoBoxattachmentMapper;
	@Autowired
	private ReturnInfoBoxMapper returnInfoBoxMapper;
	
	Logger log=Logger.getLogger(BoxSubmitReviewServiceImple.class);
	
	@Override//查询全宗下所有的盒子信息
	@LoggingTool(operCon="查询全宗文件")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Layui findAllAmcBox(String archiveId,Integer limit,Integer page) {
		Layui layui=new Layui();
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("archiveId", archiveId);
		map.put("begin", begin);
		map.put("end", end);
		List<AmCoBox> data=boxSubmitReviewMapper.findAllAmcBox(map);
		Integer count=boxSubmitReviewMapper.countAmcBoxArchiveFile(archiveId);
		return layui.data(count, data);
	}

	@Override//统计全宗下盒子的数量
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Integer countAllAmcBoxNum(String archiveId) {
		return boxSubmitReviewMapper.countAllAmcBoxNum(archiveId);
	}

	@Override//统计全宗盒子中文件数量
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Integer countAmcBoxArchiveFile(String archiveId) {
		return boxSubmitReviewMapper.countAmcBoxArchiveFile(archiveId);
	}

	@Override//获取全宗下盒子所有的年度
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<BoxSubmitReviewAnualHelp> countArchiveFileSubmitReviewAnual(String archiveId) {
		List<BoxSubmitReviewAnualHelp> anualHelps=boxSubmitReviewMapper.countArchiveFileSubmitReviewAnual(archiveId);
		for (BoxSubmitReviewAnualHelp boxSubmitReviewAnualHelp : anualHelps) {
			System.out.println(boxSubmitReviewAnualHelp);
		}
		return anualHelps;
	}

	@Override//获取全宗年度下盒子所有的年度
	@LoggingTool(operCon="查询全宗年度信息")
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Layui queryAllAllAmcBoxByAnual(String archiveId, String anual,Integer limit,Integer page) {
		Layui layui=new Layui();
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("archiveId", archiveId);
		map.put("begin", begin);
		map.put("end", end);
		map.put("anual", anual);
		List<AmCoBox> data=boxSubmitReviewMapper.queryAllAllAmcBoxByAnual(map);
		Integer count=boxSubmitReviewMapper.countAllAllAmcBoxByAnual(archiveId, anual);
		return layui.data(count, data);
	}

	@Override//信息查询后的页面信息
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public HavingInforBox havingAllAllAmcBoxByAnual(String archiveId) {
		HavingInforBox havingInforBox=new HavingInforBox();
		havingInforBox.setBoxNum(boxSubmitReviewMapper.countAllAmcBoxNum(archiveId));
		havingInforBox.setFileNum(boxSubmitReviewMapper.countAmcBoxArchiveFile(archiveId));
		return havingInforBox;
	}

	@Override//年度信息查询后的页面信息
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public HavingInforBox reloadAmcBoxByAnual(String archiveId, String anual) {
		HavingInforBox havingInforBox=new HavingInforBox();
		havingInforBox.setBoxNum(boxSubmitReviewMapper.countAllAllAmcBoxByAnual(archiveId, anual));
		havingInforBox.setFileNum(boxSubmitReviewMapper.countAmcBoxArchiveFileByAnual(archiveId, anual));
		return havingInforBox;
	}

	@Override//条件查询后盒子信息
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Layui queryAllAllAmcBoxByCondition(BoxByCondition boxByCondition,Integer limit,Integer page) {
		Layui layui=new Layui();
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("archiveId", boxByCondition.getArchiveId());
		map.put("begin", begin);
		map.put("end", end);
		map.put("anual", boxByCondition.getAnual());
		map.put("codition", boxByCondition.getCodition());
		List<AmCoBox> data=boxSubmitReviewMapper.queryAllAllAmcBoxByCondition(map);//条件查询盒子信息
		Integer count =boxSubmitReviewMapper.countAllAllAmcBoxByCondition(boxByCondition);//条件统计盒子数量
		return layui.data(count, data);
	}

	@Override//条件查询后页面的信息
	public HavingInforBox reloadAmcBoxByCondition(BoxByCondition boxByCondition) {
		HavingInforBox havingInforBox=new HavingInforBox();
		havingInforBox.setBoxNum(boxSubmitReviewMapper.countAllAllAmcBoxByCondition(boxByCondition));//盒数量
		havingInforBox.setFileNum(boxSubmitReviewMapper.countAmcBoxArchiveFileByCondition(boxByCondition));
		return havingInforBox;
	}

	@Override//更新提交
	@LoggingTool(operCon="档案盒送审")
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean updateSubmitRrview(String[] str,String anual,User us) {
		Boolean lock = false;
		String archiveId=HavingUserInfor.havingArchiveId();//获取全宗主键
		User user=HavingUserInfor.havingUser();
		if(user==null) {
			user=us;
		}
		log.info("获取用户信息："+user);
		log.info("数组的长度："+str.length);
		BoxSubmitReview boxSubmitReview=null;
		ExaminaBoxHelp ex=null;
		SealTools sealToole=null;
		for(int i=0;i<str.length;i++) {
			log.info("监听到传来的参数是:"+str[i]);
			boxSubmitReview=new BoxSubmitReview();
			boxSubmitReview.setAnual(anual);
			boxSubmitReview.setArchiveId(archiveId);
			boxSubmitReview.setRetentionperioId(str[i]);
			Boolean x=boxSubmitReviewMapper.updateSubmitRrview(boxSubmitReview)>0;
			if(x) {
				log.info("盒子移送审核成功");
				lock=true;
			}else {
				log.info("盒子移送审核成功--此全宗下无此保管期限的");
				lock=false;
			}
			List<AmCoBox> listBox=boxSubmitReviewMapper.queryAmCoBox(boxSubmitReview);
			for (AmCoBox amCoBox : listBox) {
				AmCoBoxattachment amCoBoxattachment=amCoBoxattachmentMapper.queryAmCoBoxattachment(amCoBox.getBoxid());
				log.info("获取盒子附件的信息:"+amCoBoxattachment);
				log.info("组装水印内容");
				String path=amCoBoxattachment.getBoxattachmentForm();
				log.info("备考表路径为:"+path);
				ex=new ExaminaBoxHelp();
				ex.setExaminaPerson(user.getUserName());
				ex.setExaminaTime(new Date());
				log.info("图片打水印");
				sealToole=new SealTools();
				String boxattachmentForm=sealToole.examinaContent(ex, path);
				Boolean re=boxSubmitReviewMapper.updateBoxattachmentForm(boxattachmentForm, amCoBoxattachment.getBoxattachmentId())>0;
				if(re) {
					log.info("更新盒子附件备考表信息成功");
					lock=true;
				}else {
					log.info("更新盒子附件备考表信息失败");
					lock=false;
				}
			}
			
		}
		return lock;
	}

	@Override//根据年度查询盒子的信息
	@LoggingTool(operCon="档案盒驳回重整")
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean reorganize(String archiveId, String anual,String custody) {
		Boolean lock=false;
		List<AmCoBox> boxList=boxSubmitReviewMapper.queryAllAllAmcBoxByAnualTurnDown(archiveId,anual,custody);//获取所有的盒子的信息
		for (AmCoBox amCoBox : boxList) {
			Boolean result=boxSubmitReviewMapper.updateArchiveFileBoxStart(amCoBox.getBoxid())>0;
			if(result) {
				lock=true;
				log.info("文件已驳回重整");
			}else {
				lock=false;
				log.info("文件驳回失败");
				break;
			}
		}
		Boolean dele=returnInfoBoxMapper.deleteReturnInfoBoxByAnualAndArchiveId(anual, archiveId,custody)>0;
		if(dele) {
			lock=true;
			log.info("驳回情况删除成功");
		}else {
			lock=false;
			log.info("驳回情况删除失败");
		}
		Boolean del=boxSubmitReviewMapper.deleteAmcBox(archiveId, anual,custody)>0;
		if(del) {
			log.info("盒子删除成功");
		}else {
			lock=false;
			log.info("盒子删除失败");
		}
		AmCoBoxattachment amCoBoxattachment=null;
		for (AmCoBox amCoBox : boxList) {
			amCoBoxattachment=amCoBoxattachmentMapper.queryAmCoBoxattachment(amCoBox.getBoxid());//获取盒子附件信息
			log.info("盒子附件的信息为："+amCoBoxattachment);
			File fileFile=new File(amCoBoxattachment.getBoxattachmentFile());//归档文件目录地址
			File fileBox=new File(amCoBoxattachment.getBoxattachmentBox());//盒面盒脊地址地址
			File fileForm=new File(amCoBoxattachment.getBoxattachmentForm());//备考表地址
			fileBox.delete();
			fileFile.delete();
			fileForm.delete();
			Boolean delA=boxSubmitReviewMapper.deleteBoxAttachment(amCoBox.getBoxid())>0;
			if(delA) {
				lock=true;
				log.info("盒子附件删除成功");
			}else {
				lock=false;
				log.info("盒子附件删除失败");
			}
		}
		return lock;
	}
	
	@Override//根据盒子主键查询文件信息
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Layui queryArchiveFileByBoxId(String boxId,Integer limit,Integer page) {
		Layui layui=new Layui();
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("boxId", boxId);
		map.put("begin", begin);
		map.put("end", end);
		List<ArchiveFile> data=archiveFileStoreMapper.queryArchiveFileByBoxId(map);
		Integer count=archiveFileStoreMapper.countArchiveFileByBoxId(boxId);
		return layui.data(count, data);
	}
	
	@Override//根据这字主键查询文件附件
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public PageBean<FileAttachment> queryFileAttachmentByBoxId(String boxId,int currPage) {
		Map<String, Object> map =new HashMap<String,Object>();
		PageBean<FileAttachment> pageBean=new PageBean<FileAttachment>();
		pageBean.setCurrPage(currPage);
		// 每页显示的数据
		int pageSize = 1;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = archiveFileStoreMapper.countFileAttachmentByBoxId(boxId);
		pageBean.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageBean.setTotalPage(num.intValue());
		map.put("begin", (currPage - 1) * pageSize + 1);
		map.put("end", currPage * pageSize);
		map.put("boxId", boxId);
		List<FileAttachment> lists=archiveFileStoreMapper.queryFileAttachmentByBoxId(map);
		for (FileAttachment fileAttachment : lists) {
			log.info("监听到文件附件返回的参数：fileAttachment="+fileAttachment);
			fileAttachment.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replace("D:/file", "/resource"));
		}
		pageBean.setLists(lists);
		return pageBean;
	}

	@Override//根据盒子主键查询盒子附件信息
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public AmCoBoxattachment queryAmCoBoxattachment(String boxId) {
		log.info("监听到查看盒子附件信息的主键"+boxId.length());
		AmCoBoxattachment amCoBoxattachment=amCoBoxattachmentMapper.queryAmCoBoxattachment(boxId);
		log.info("监听到传回来的盒子附件信息是"+amCoBoxattachment);
		amCoBoxattachment.setBoxattachmentBox(amCoBoxattachment.getBoxattachmentBox().replace("D:/file", "/resource"));
		if(amCoBoxattachment.getBoxattachmentForm()!=null&&amCoBoxattachment.getBoxattachmentForm()!="") {
			amCoBoxattachment.setBoxattachmentForm(amCoBoxattachment.getBoxattachmentForm().replace("D:/file", "/resource"));
		}
		return amCoBoxattachment;
	}

	@Override//根据文件的主键查询文件附件信息
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<FileAttachment> queryFileAttachmentByArchiveFileId(String archiveFileId) {
		List<FileAttachment> list=archiveFileStoreMapper.queryFileAttachmentByArchiveFileId(archiveFileId);
		for (FileAttachment fileAttachment : list) {
			fileAttachment.setFileAttachmentPath(fileAttachment.getFileAttachmentPath().replace("D:/file", "/resource"));
		}
		return list;
	}

	@Override//更具盒子主键查询盒子信息
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public AmCoBox queryAmCoBoxByBoxId(String boxId) {
		return boxSubmitReviewMapper.queryAmCoBoxByBoxId(boxId);
	}

	@SuppressWarnings("unused")
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<String> findBoxPathList(String boxYear,String retentionperiodid) throws Exception {
		User user = HavingUserInfor.havingUser();
		List<String> listTemp = new ArrayList<String>();
		if(user!=null) {
			Archive archive = new Archive();
			archive.setQuanzongId(user.getArchive().getQuanzongId());
			AmCoBoxattachment amCoBoxattachment = new AmCoBoxattachment();
			amCoBoxattachment.setArchive(archive);
			amCoBoxattachment.setBoxYear(boxYear);
			amCoBoxattachment.setRetentionperiodid(retentionperiodid);
			if(amCoBoxattachment!=null) {
				List<AmCoBoxattachment> list = boxSubmitReviewMapper.findBoxPathList(amCoBoxattachment);
				List<String> boxPathList = new ArrayList<>();
				for (AmCoBoxattachment amCoBoxattachment2 : list) {
					boxPathList.add(amCoBoxattachment2.getBoxattachmentBox().substring(0,
							amCoBoxattachment2.getBoxattachmentBox().lastIndexOf("/")));
				}
				for (int i = 0; i < boxPathList.size(); i++) {
					if (!listTemp.contains(boxPathList.get(i))) {
						listTemp.add(boxPathList.get(i));
					}
				}
			}else {
				log.error("档案盒附件实例为空:"+amCoBoxattachment);
			}
		}else {
			throw new Exception("用户信息为空:"+user);
		}
		
		return listTemp;
	}

	@Override//驳回情况信息
	public Layui returnInfor(String archiveId, String anual,Integer limit,Integer page) {
		/*Layui layui=new Layui();*/
		log.info("驳回情况");
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("archiveId", archiveId);
		map.put("begin", begin);
		map.put("end", end);
		map.put("anual", anual);
		List<ReturnInfoBox> data=returnInfoBoxMapper.findReturnInfoBoxByAnualAndArchiveId(map);
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).getBoxsericalnumber()+"sadgasdfasgasgaas"+data.get(i).getReturnInfoReason());
		}
		log.info("驳回文件的数量"+data.size());
		Integer count=returnInfoBoxMapper.countReturnInfoBoxByAnualAndArchiveId(anual, archiveId);
		return Layui.data(count, data);
	}

	@Override
	public List<BoxHavingRetentionperiodHelp> havingRetentionperiod(String archiveId, String anual) {
		log.info("获取年度下保管期限");
		return boxSubmitReviewMapper.havingRetentionperiod(archiveId, anual);
	}

	@Override//年度保管期限获取盒子信息
	public Layui queryAllAllAmcBoxByAnualAndRetentionperoid(String archiveId, String anual, Integer limit, Integer page,
			String retentionperoids) {
		Layui layui=new Layui();
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("archiveId", archiveId);
		map.put("begin", begin);
		map.put("end", end);
		map.put("anual", anual);
		map.put("retentionperoids", retentionperoids);
		List<AmCoBox> data=boxSubmitReviewMapper.queryAllAllAmcBoxByAnualAndRetentionperoids(map);
		Integer count=boxSubmitReviewMapper.countAmcBoxArchiveFileByAnualAndRetentionperoids(map);
		return layui.data(count, data);
	}

	@Override//年度保管期限获取件数等信息
	public HavingInforBox reloadAmcBoxByAnualAndRetentionperoid(String archiveId, String anual,
			String retentionperoids) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("archiveId", archiveId);
		map.put("anual", anual);
		map.put("retentionperoids", retentionperoids);
		Integer boxNum=boxSubmitReviewMapper.countcountAllAllAmcBoxByAnualAndRetentionperoids(map);
		Integer fileNum=boxSubmitReviewMapper.countAmcBoxArchiveFileByAnualAndRetentionperoids(map);
		HavingInforBox havingInforBox=new HavingInforBox();
		havingInforBox.setBoxNum(boxNum);
		havingInforBox.setFileNum(fileNum);
		return havingInforBox;
	}

}
