/*
 * Written by Vei Paterson Tia
 */
public interface GenLLI<T> {
	public void add(T aData);
	public boolean remove(T aData);
	public boolean contains(T aData);
	public boolean isEmpty();
	public void clear();
	public int size();
}
