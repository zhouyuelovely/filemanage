package filemanage.utils.exchangeCenter;

import javax.servlet.http.HttpServletRequest;

import filemanage.digitalarchives.pojo.Advice;
import filemanage.digitalarchives.pojo.Reply;
import filemanage.digitalarchives.service.AdviceService;
import filemanage.login.pojo.User;

/**
 * 交流中心业务实现封装
 * @author Administrator
 * 陈一达
 */
public class exchangeCenterBRInterface {

	/**
	 * 针对咨询建议/回复 的业务（新增）
	 * @param request
	 * @param exchangeCenter 前台返回参数
	 * @return
	 */
	public String adviceReplyInsert(HttpServletRequest request,exchangeCenterData exchangeCenter,AdviceService aService) {
		String returnSmage = null;
		if (exchangeCenter.getCommitType().equals("1")) {
			Advice advice = new Advice();
			User user = new User();
			user.setUserId(exchangeCenter.getUserId());
			advice.setAdviceTheme(exchangeCenter.getAdviceTheme());
			advice.setAdviceType(exchangeCenter.getAdviceType());
			advice.setAdvicePublicinformation(exchangeCenter.getAdvicePublicinformation());
			advice.setAdviceTime(exchangeCenter.getAdviceTime());
			advice.setAdviceContent(exchangeCenter.getAdviceContent());
			advice.setUserIds(user);
			if(aService.insertAdvice(advice)>0) {
				if(exchangeCenter.getAdviceType().equals("1")) {
					returnSmage = "{msg:'咨询提交成功，请等待回复！'}";
				}else {
					returnSmage = "{msg:'建议提交成功，请等待回复！'}";
				}
				
			}else {
				returnSmage = "{msg:'提交失败！请联系管理员！'}";
			}
		}else if(exchangeCenter.getCommitType().equals("2")) {
			Reply reply = new Reply();
			Advice advice = new Advice();
			User user = new User();
			advice.setAdviceId(exchangeCenter.getAdviceId());
			reply.setAdviceId(advice);
			reply.setReplyContent(exchangeCenter.getReplyContent());
			reply.setReplyTime(exchangeCenter.getAdviceTime());
			reply.setRuserId(exchangeCenter.getUserId());
			if(aService.insertReply(reply)>0) {
				advice.setRuserId(exchangeCenter.getUserId());
				if(aService.updateAdvice(advice) > 0) {
					returnSmage = "{msg:'回复成功！'}";
				}else {
					returnSmage = "{msg:'更新咨询建议表失败！！'}";
				}
				
			}else {
				returnSmage = "{msg:'回复失败！！'}";
			}
			
		}
		return returnSmage;
		
	}
}
