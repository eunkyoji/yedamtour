package co.yedam.yedamtour.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFiter implements Filter {
	private String encode;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encode = filterConfig.getInitParameter("encode");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(request.getCharacterEncoding() == null ) {
			request.setCharacterEncoding(encode);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
