public interface List<E>{ //interface for  linkedlist and arraylist classes

	abstract public boolean add(E t);
	abstract public void add(int pos, E t);
	abstract public E remove(int pos);
	abstract public E get(int pos);
	abstract public int size();


}