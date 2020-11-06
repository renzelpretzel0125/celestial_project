public class ArrayList<T> implements List<T>{

	private void grow_array(){ //adjust and grows array
		T[]new_arr = (T[]) new Object[arr.length * 2];
		for (int i = 0; i < arr. length; i++){
			new_arr[i] = arr[i];
		}
		arr = new_arr;
	}

	public int size = 0;
	
	public int size(){
		return size;
	}
	
	public T[]arr = null;

	public boolean add(T t){ //adds
		if (size == arr. length)
		grow_array();
		arr[size++] = t;
		return true;
	}
	
	public void add (int pos, T t){ //adds item in certain position
		for (int i = size; i > pos; i--){
			arr[i] = arr[i- 1];
		}
		arr[pos] = t;
		++size;
	}
	
	public T remove(int pos){ //removes from a certain position
		if(pos < 0 || pos>size){
			return null;
		}else{
			T temp = arr[pos-1];
			for (int i=pos; i < size-1; i++){
				arr[i-1]=arr[i];
			}
			--size;
			return temp;
		} 
	}
	
	public T get(int pos){ //gets item in certain position
		if(pos == 0){
			return arr[0];
		}else if(pos<0){
			return null;
		}
		return arr[pos-1];
	}

}