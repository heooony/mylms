package mylms.core.logging;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import mylms.core.util.WebappHelper;

public class Tracing {
	private static final String N_A = "n/a";
	private static final String AUDIT = "AUDIT";
	
	public static Logger createLoggerFor(Class<?> loggingClass) {
		return LogManager.getLogger(loggingClass.getName());
	}
	
	public static void setHttpRequest(HttpServletRequest req) {
		if(req == null) {
			ThreadContext.clearAll();
		} else {
			String remoteIp = req.getRemoteAddr();
			String userAgent = req.getHeader("User-Agent");
			String referer = req.getHeader("Referer");
			ThreadContext.put("ip", remoteIp == null ? N_A : remoteIp);
			ThreadContext.put("userAgent", userAgent == null ? N_A : userAgent);
			ThreadContext.put("referer", referer == null ? N_A : referer);
			ThreadContext.put("nodeId", Integer.toString(WebappHelper.getNodeId()));
		}
	}

	public static void clearHttpRequest() {
		ThreadContext.clearAll();
	}
}
