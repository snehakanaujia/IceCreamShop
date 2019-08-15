/**
 * 
 * @author Sneha Kanaujia
 *
 * @param <T> is a placeholder for the type of non-primitive objects being saved in the list
 */
public class StackLL<T> implements Stack<T>{
	
	/**
	 * Instance variable of type list<T> assigned to an instance of the LinkedList<T> class
	 */
	private List<T> list = new LinkedList<T>();
	
	
	/**
	 * Adds data to the front of the list.
	 * @param data is the data we want to add
	 */
	@Override
	public void push(T data) {
		
		//Adds a new node to the front of the list
		list.add(0, data);
	}
	
	/**
	 * Removes/deletes data from the front of the list.
	 * @return value, the data you are deleting from the list
	 */
	@Override
	public T pop() {
		if(list.size() > 0)
		{
			//Saves the first piece of data in a local variable
			T value = list.get(0);
			//Deletes the first data point from the list
			list.delete(0);
			//Returns the deleted data
			return value;
		}
		
		return  null;
	}

	/**
	 * Gets the data from the front of the list
	 * @return data from the front of the list
	 */
	@Override
	public T peek() {
		
		//Saves the first piece of data in a local variable
		T data = list.get(0);
		//Returns the deleted data
		return data;
	}

	/**
	 * Tells you if the list is empty (true) or not (false)
	 * @return if the list is empty (true) or not (false)
	 */
	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}
	
	/**
	 * Get the size of the list.
	 * @return number of elements in the list
	 **/
	public int getSize()
	{
		return list.size();
	}

}
