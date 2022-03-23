package mylms.core.util.event;

import mylms.core.util.coordinate.CoordinatorManager;

public class FrameworkStartupEventChannel {
	
	private static CoordinatorManager coordinatorManager;
	
	public static MultiUserEvent getEvent() {
		return new FrameworkStartedEvent();
	}
	
	public static void fireEvent() {
		coordinatorManager.getCoordinator().getEventBus().fireEventToListenersOf(getEvent(), FRAMEWORK_STARTUP_EVENT_CHANNEL);
	}
}
