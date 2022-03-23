package mylms.core.dispatcher;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class DispatcherModule {
	public static final void sendServerError(HttpServletResponse resp) {
		try {
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (IOException e) {
			
		}
	}

}
