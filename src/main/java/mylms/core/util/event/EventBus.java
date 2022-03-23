package mylms.core.util.event;

import mylms.core.id.MylmsResourceable;

public interface EventBus {

	public void fireEventToListenersOf(MultiUserEvent event, MylmsResourceable ores);
}
