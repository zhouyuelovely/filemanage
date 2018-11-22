package filemanage.login.util.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import filemanage.login.pojo.User;
import filemanage.login.service.LogService;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{
	@Autowired
	private LogService logService;
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		String username= (String)subject.getPrincipal();
		User user=logService.queryUserByUserName(username);
		 //获取session
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        HttpSession session = httpServletRequest.getSession();
        //把用户信息保存到session
        session.setAttribute("user", user);
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession ses = req.getSession();
		ses.setAttribute("user", user);
		return super.onLoginSuccess(token, subject, request, response);
	}
	
}
