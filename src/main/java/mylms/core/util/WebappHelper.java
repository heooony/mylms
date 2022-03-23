package mylms.core.util;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

import mylms.core.configuration.Destroyable;
import mylms.core.configuration.Initializable;

public class WebappHelper implements Initializable, Destroyable, ServletContextAware {
	
	public static int nodeId;

	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	public static int getNodeId() {
		return nodeId;
	}
	
}
