package chapter4TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class EventRegistration<T> implements IEventRegistration<T> {
	private List<ISubscriber<T>> subList = new ArrayList<ISubscriber<T>>();

	public void RegisterSubscriber(ISubscriber<T> sub) {
		if (subList.indexOf(sub) >= 0) {
			return;
		}
		subList.add(sub);
	}

	public void RemoveSubscriber(ISubscriber<T> sub) {
		subList.remove(sub);
	}

	public void FireEvent(T object) {
		for (ISubscriber<T> sub : subList) {
			sub.onEvent(object);
		}
	}
}
