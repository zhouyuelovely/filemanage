package filemanage.systemmanage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import filemanage.systemmanage.dao.LoggingProduceMapper;
import filemanage.systemmanage.pojo.LoggingProduce;
import filemanage.systemmanage.service.LoggingProduceService;
import filemanage.systemmanage.vo.LogginProduceCondition;
import filemanage.utils.excelmanage.ExportExcel;
import filemanage.utils.layui.Layui;
@Service
public class LoggingProduceServiceImple implements LoggingProduceService{
	private Logger logger=Logger.getLogger(LoggingProduceServiceImple.class);//日志记录
	@Autowired
	private LoggingProduceMapper loggingProduceMapper;
	
	
	@Override//页面渲染日志信息
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui findLoggingProduce(Integer limit, Integer page) {
		Layui layui=new Layui();
		Map<String, Object> map=new HashMap<String,Object>();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		map.put("begin", begin);
		map.put("end", end);
		List<LoggingProduce> data=loggingProduceMapper.findLoggingProduce(map);
		Integer count=loggingProduceMapper.countLoggingProduce();
		return layui.data(count, data);
	}

	@Override//条件查看日志信息
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Layui findLoggingProduceByCondition(LogginProduceCondition logginProduceCondition, Integer limit,
			Integer page) {
		Layui layui=new Layui();
		Integer begin = (page-1)*limit+1;
		Integer end =page*limit;
		logginProduceCondition.setBegin(begin);
		logginProduceCondition.setEnd(end);
		List<LoggingProduce> data=loggingProduceMapper.findLoggingProduceByCondition(logginProduceCondition);
		Integer count=loggingProduceMapper.countLoggingProduceByCondition(logginProduceCondition);
		return layui.data(count, data);
	}

	@Override//导出日志
	public String expectLoggingProduce(String str,String path)throws Exception   {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
		String date=simpleDateFormat.format(new Date());
		String excelPath=path+"/日志记录表("+date+").xlsx";
		String excelName="日志记录表";
		String[] excelOutfit=new String[] {"用户名","用户主机","用户ip地址","操作内容","操作时间"};
		List<List> listName=new ArrayList<List>();
		String[] strings=str.split(",");
		for (String string : strings) {
			LoggingProduce loggingProduce=loggingProduceMapper.expuctLoggingProduce(string);
			List<String> list=new ArrayList<String>();
			list.add(loggingProduce.getUser().getUserName());
			list.add(loggingProduce.getUser().getUserHostName());
			list.add(loggingProduce.getUser().getUserIpAddress());
			list.add(loggingProduce.getLogContent());
			list.add(simpleDateFormat.format(loggingProduce.getLogCreateTime()));
			listName.add(list);
		}
		ExportExcel.createExcel(excelPath, excelName, excelOutfit, listName);
		return excelPath;
	}

}
