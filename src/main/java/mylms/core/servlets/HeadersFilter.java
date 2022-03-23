package mylms.core.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HeadersFilter implements Filter {
	
//	@Autowired
//	private CSPModule securityModule;
	
//	@Autowired
//	private List<CSPDirectiveProvider> directiveProviders;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		if(securityModule == null || directiveProviders == null) {
//			CoreSpringFactory.autowireObject(this);
//		}
//		addSecurityHeaders(response);
		chain.doFilter(request, response);
	}

}
