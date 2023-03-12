package General;

public interface QueueTAD<T extends Comparable<T>> {
	public void enqueue(T d);

	public T dequeue();

	public T first();

	public boolean isEmpty();

	public int size();
}
