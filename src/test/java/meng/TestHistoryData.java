package meng;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import filemanage.recorded.dao.HisoryDataMapper;
import filemanage.recorded.pojo.HistoryAnnex;
import filemanage.recorded.pojo.HistoryData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-mvc-web.xml","classpath:spring-mvc-dao.xml"})
@WebAppConfiguration("src/main/resources")
public class TestHistoryData {
	@Autowired
	private HisoryDataMapper hisoryDataMapper;
	
	@Test
	public void testAddHistoryData() {
		List<HistoryData> lists=new ArrayList<HistoryData>();
		HistoryData historyData=null;
		for(int i=0;i<3;i++) {
			historyData=new HistoryData();
			historyData.setHistorydataId(UUID.randomUUID().toString());
			historyData.setHistorydataPages("3"+i);
			lists.add(historyData);
		}
		hisoryDataMapper.addHistoryData(lists);
	}
	@Test
	public void testAddHistoryAnnex() {
		List<HistoryAnnex> list =new ArrayList<HistoryAnnex>();
		HistoryAnnex historyAnnex;
		for(int i=0;i<3;i++) {
			String hid=UUID.randomUUID().toString();
			for(int j=0;j<3;j++) {
				historyAnnex=new HistoryAnnex();
				historyAnnex.setHistoryannexId(UUID.randomUUID().toString());
				historyAnnex.setHistoryannexName(i+":"+j);
				historyAnnex.setHistoryannexPath(i+"/"+j);
				historyAnnex.setHistorydataId(hid);
				list.add(historyAnnex);
			}
		}
		Integer integer=hisoryDataMapper.addHistoryAnnex(list);
		System.out.println(integer);
		List<HistoryData> lists=new ArrayList<HistoryData>();
		HistoryData historyData=null;
		for(int i=0;i<3;i++) {
			historyData=new HistoryData();
			historyData.setHistorydataId(UUID.randomUUID().toString());
			historyData.setHistorydataPages("3"+i);
			lists.add(historyData);
		}
		hisoryDataMapper.addHistoryData(lists);
	}
	@Test
	public void testQueryHistorydataType() {
		String id=hisoryDataMapper.queryHistorydataType("文书档案");
		System.out.println(id);		
	}
}
