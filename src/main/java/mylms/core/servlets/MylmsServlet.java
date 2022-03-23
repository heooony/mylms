package mylms.core.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;

import mylms.core.dispatcher.DispatcherModule;
import mylms.core.logging.Tracing;


public class MylmsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Tracing.createLoggerFor(MylmsServlet.class);
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		log.info("Framework has started");
		FrameworkStartupEventChannel.fireEvent();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		Tracing.setHttpRequest(req);
//		ThreadLocalUserActivityLoggerInstaller.initUserActivityLogger(req);
//		WorkThreadInformations.set("Serve request: ".concat(req.getRequestURI()));
//		if(sessionStatsManager != null) {
//			sessionStatsManager.incrementRequest();
//			sessionStatsManager.incrementConcurrentCounter();
//		}
		
		try {
			super.service(req, resp);
		} catch (ServletException | IOException e) {
			log.error("", e);
			DispatcherModule.sendServerError(resp);
		} finally {
//			WorkThreadInformations.unset();
//			ThreadLocalUserActivityLoggerInstaller.resetUserActivityLogger();
//			I18nManager.remove18nInfoFromThread();
			Tracing.clearHttpRequest();
//			DBFactory.getInstance().commitAndCloseSession();
		}
	}

}
