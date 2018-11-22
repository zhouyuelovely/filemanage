package filemanage.digitalarchives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import filemanage.digitalarchives.dao.InformationPortalMapper;

@Component
public class FlightTrainTask {
	
	@Autowired
	private InformationPortalMapper informationPortalMapper;
	
	 @Scheduled(cron = "0 0 0 30 * ? ") // 间隔30天后执行
     public void taskCycle() {
		informationPortalMapper.deleteInfomationPortal();
    }

}
