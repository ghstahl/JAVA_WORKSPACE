package chapter4TreesAndGraphs;

public interface IEventRegistration<T> {
	public void RegisterSubscriber(ISubscriber<T> sub);

	public void RemoveSubscriber(ISubscriber<T> sub);

	public void FireEvent(T object);
}
