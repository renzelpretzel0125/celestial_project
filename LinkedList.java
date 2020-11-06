public class LinkedList<T> implements List<T>{

	public class Node<T>{ //for nodes
		T data;
		Node<T> next;
		Node<T> prev;
		public Node(T value){
			data = value;
			next = null;
			prev = null;
		}
	}
	Node<T> head = null;
	public int size = 0;
	public int size(){
		return size;
	}
	public boolean add(T t){ //adds 
		if (head == null) {
			head = new Node(t);
			++size;
			return true;
		}
		Node<T> prev = head;
		for (int i = 0; i < size-1;i++){
			prev = prev.next;
		}
		Node<T> node = new Node(t);
		prev.next = node;
		++size;
		return true;
	}
	public void add(int pos, T t) { //adds items in regards in position
		if (pos == 0) {
			Node<T> node = new Node(t);
			node.next = head;
			head = node;
			++size;
		}else{
			Node<T> prev = head;
			for (int i=0; i < pos-1;i++){
				prev = prev.next;
			}
			Node<T> node = new Node(t);
			node.next = prev.next;
			prev.next = node;
			++size;
		} 
	}
	public T remove (int pos) { //removes from a certain position
		if(pos == 0){
			Node<T> node = head;
			head = head.next;
			--size;
			return node.data;
		}else{
			Node<T> prev = head;
			for (int i=0; i < pos-1; i++){
				prev = prev.next;
			}
			Node<T> node = prev.next;
			prev.next = node.next;
			--size;
			return node.data;
		} 
	}

	public T get(int pos) { //gets data within position
		Node<T> curr = head;
		for (int i = 0; i < pos; i++){
			curr = curr.next;
		}
		return curr.data;
	}


}