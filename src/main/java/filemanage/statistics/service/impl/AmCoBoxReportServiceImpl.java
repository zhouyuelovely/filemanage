package filemanage.statistics.service.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filemanage.statistics.dao.AmCoBoxReportMapper;
import filemanage.statistics.pojo.AmCoBoxReport;
import filemanage.statistics.service.AmCoBoxReportService;



@Transactional
@Service("amCoBoxReportService")
public class AmCoBoxReportServiceImpl implements AmCoBoxReportService {
	@Resource
	private AmCoBoxReportMapper acbr;

	@Override
	public Map<String, List<AmCoBoxReport>> queryByBox(String anual) {
		// 柱状图的数据
		List<AmCoBoxReport> quanzongList = acbr.queryQuanzongname(anual);
		
		Map<String, List<AmCoBoxReport>> map = new HashMap<>();
		for (int i = 0; i < quanzongList.size(); i++) {
			List<AmCoBoxReport> list = acbr.queryByBox(anual, quanzongList.get(i).getQuanzongid());
			map.put(quanzongList.get(i).getQuanzongname(), list);
		}
		return map;
	}

	@Override
	public List<AmCoBoxReport> queryQuanzongname(String anual) {
		return acbr.queryQuanzongname(anual);
	}

	@Override
	public List<AmCoBoxReport> queryPcname(String anual) {
		return acbr.queryPcname(anual);
	}

	@Override
	public List<AmCoBoxReport> queryAnual() {
		return acbr.queryAnual();
	}
	//以件查询
	@Override
	public Map<String, List<AmCoBoxReport>> queryByFile(String anual) {
		// 柱状图的数据
				List<AmCoBoxReport> quanzongList = acbr.queryQuanzongname(anual);
				
				Map<String, List<AmCoBoxReport>> map = new HashMap<>();
				for (int i = 0; i < quanzongList.size(); i++) {
					List<AmCoBoxReport> list = acbr.queryByFile(anual, quanzongList.get(i).getQuanzongid());
					map.put(quanzongList.get(i).getQuanzongname(), list);
				}
				return map;
	}

	@Override
	public List<AmCoBoxReport> queryBorrowing(String anual) {
		int total = acbr.queryBorrowingCount(anual);		//查询总借阅数
		List<AmCoBoxReport> list = acbr.queryBorrowing(anual);
		for (int i = 0; i < list.size(); i++) {
			int borrownum = list.get(i).getBorrowingnum();
			double x_double = borrownum*1.0;
			double tempresult=x_double/total;
			DecimalFormat df1 = new DecimalFormat("0.00%");  
			String borrowProportion = df1.format(tempresult);
			list.get(i).setBorrowProportion(borrowProportion);
		}
		return list;
	}
	
	@Override
	public List<AmCoBoxReport> queryBorrowingTable(String anual, int before, int after) {
		Integer total = acbr.queryBorrowingCount(anual);		//查询总借阅数
		List<AmCoBoxReport> list = acbr.queryBorrowingTable(anual,before,after);
		if(total==null){
			total = 0;
		}else{
			
			for (int i = 0; i < list.size(); i++) {
				int borrownum = list.get(i).getBorrowingnum();
				double x_double = borrownum*1.0;
				double tempresult=x_double/total;
				DecimalFormat df1 = new DecimalFormat("0.00%");  
				String borrowProportion = df1.format(tempresult);
				list.get(i).setBorrowProportion(borrowProportion);
			}
		}
		return list;
	}

	@Override
	public int queryBorrowingCount(String anual) {
		return acbr.queryBorrowingCount(anual);
	}

	@Override
	public List<AmCoBoxReport> queryBorrowingType(String anual) {
		return acbr.queryBorrowingType(anual);
	}

	@Override
	public List<AmCoBoxReport> queryBorrowingAnual() {
		return acbr.queryBorrowingAnual();
	}
	/**
	 * 查询驳回情况数据
	 */
	@Override
	public List<AmCoBoxReport> queryReject(String anual) {
		List<AmCoBoxReport> list = acbr.queryReject(anual);
		Integer total = acbr.queryRejectTotal(anual);
		if(total==null){
			total = 0;
		}else{
			for (int i = 0; i < list.size(); i++) {
				int rejectnum = list.get(i).getRejectnum();
				
				double x_double = rejectnum*1.0;
				double tempresult = (1-(x_double/total))*100;
				DecimalFormat df1 = new DecimalFormat("0.00");  
				String rejectProprotion = df1.format(tempresult);
				list.get(i).setRejectProprotion(rejectProprotion);
			}
		}
		
		return list;
	}
	
	@Override
	public List<AmCoBoxReport> queryRejectTable(String anual,int before,int after) {
		List<AmCoBoxReport> list = acbr.queryRejectTable(anual,before,after);
		Integer total = acbr.queryRejectTotal(anual);
		if(total==null){
			total = 0;
		}else{
			for (int i = 0; i < list.size(); i++) {
				int rejectnum = list.get(i).getRejectnum();
				
				double x_double = rejectnum*1.0;
				double tempresult = 1-(x_double/total);
				DecimalFormat df1 = new DecimalFormat("0.00%");  
				String rejectProprotion = df1.format(tempresult);
				list.get(i).setRejectProprotion(rejectProprotion);
			}
		}
		return list;
	}

	@Override
	public Integer queryRejectTotal(String anual) {
		Integer total = acbr.queryRejectTotal(anual);
		if(total==null){
			total = 0;
		}
		return total;
	}

	@Override
	public List<AmCoBoxReport> queryRejectAnual() {
		return acbr.queryRejectAnual();
	}

	@Override
	public List<AmCoBoxReport> queryByBoxTable(String anual,int before,int after) {
		return acbr.queryByBoxTable(anual,before,after);
	}

	@Override
	public List<AmCoBoxReport> queryByFileTable(String anual,int before,int after) {
		return acbr.queryByFileTable(anual,before,after);
	}

	@Override
	public int queryByBoxTableTotal(String anual) {
		return acbr.queryByBoxTableTotal(anual);
	}

	@Override
	public int queryByFileTableTotal(String anual) {
		return acbr.queryByFileTableTotal(anual);
	}

	@Override
	public List<AmCoBoxReport> queryRejectQuanzong(String anual) {
		return acbr.queryRejectQuanzong(anual);
	}


	@Override
	public List<AmCoBoxReport> queryFileAnual() {
		return acbr.queryFileAnual();
	}

	@Override
	public String queryboxCountnum(String anual, String pcname, String quanzongid) {
		return acbr.queryboxCountnum(anual, pcname, quanzongid);
	}

	@Override
	public String queryfileSumnum(String anual, String pcname, String quanzongid) {
		return acbr.queryfileSumnum(anual, pcname, quanzongid);
	}

	@Override
	public List<AmCoBoxReport> queryFileQuanzongname(String anual) {
		return acbr.queryFileQuanzongname(anual);
	}

	@Override
	public List<AmCoBoxReport> queryFilePcname(String anual) {
		return acbr.queryFilePcname(anual);
	}

	@Override
	public int queryBorrowingTableTotal(String anual) {
		return acbr.queryBorrowingTableTotal(anual);
	}

	@Override
	public Integer queryRejectTableTotal(String anual) {
		Integer total = acbr.queryRejectTableTotal(anual);
		if(total==null){
			total=0;
		}
		return total;
	}
}
