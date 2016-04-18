/**
 * Linked List
 */
package linkedlists;

/**
 * @author adrianafuentes
 *
 *	Implementation of a stack of integers using an array.
 *
 *	First in - Last Out	
 */
public class StackUsingArray {
	
	int capacity = 0;
	int[] arrayint;
	int top = -1;
	int size = 0;
	
	public StackUsingArray(int capacity) {
		this.arrayint = new int[capacity];
		this.capacity = capacity;
	}
	
	public int pop() {
		if(size ==0)
			return -1;
		
		int result = arrayint[top];
		top--;
		size--;
		arrayint[top] = -1;
		
		return result;
	}
	
	public boolean push(int number) {
		if(isFull())
			return false;
		
		arrayint[size] = number;
		top = size;
		setSize();
		return true;
	}
	
	public void setSize() {
		size++;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isFull() {
		if(size == capacity)
			return true;
		else
			return false;
	}
}
