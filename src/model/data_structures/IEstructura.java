package model.data_structures;

public interface IEstructura<E> extends Iterable<E>
{
	public int size();

	public boolean isEmpty();

	public E getFirst();

	public void clear();
}
