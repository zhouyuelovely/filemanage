package filemanage.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;

@WebFilter(
		urlPatterns={"/*"},//过滤所有内容
		initParams={
				@WebInitParam(name="encode",value="utf-8")//初始化参数
		})
public class ContextFilter implements Filter{//中文过滤器
	private String encoding;
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding=filterConfig.getInitParameter("encode");
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain)throws IOException, ServletException {
		req.setCharacterEncoding(encoding);//设置解码采用字符集
		resp.setCharacterEncoding(encoding);//设置响应时对内容进行的编码方式
		HttpServletResponse response=(HttpServletResponse)resp;
		response.addHeader("Content-Type", "test/html;charset="+encoding);//浏览器就行编码方式
		chain.doFilter(req, resp);
	}

	public void destroy() {
		
	}

}
