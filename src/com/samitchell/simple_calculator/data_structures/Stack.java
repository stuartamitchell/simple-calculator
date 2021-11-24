package com.samitchell.simple_calculator.data_structures;

/**
 * A class to represent a stack of objects of type T
 * 
 * @author Stuart A Mitchell
 *
 * @param <T>	the type of the objects in the stack
 */
public class Stack<T> {
	private T[] items;
	private int capacity;
	private int headPos;
	
	/**
	 * Default constructor - creates a Stack with a capacity of 10
	 */
	public Stack() {
		this(10);
	}
	
	/**
	 * Non-default constructor - creates a stack with the supplied capacity
	 * @param capacity	the desired capacity for the stack
	 */
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		this.headPos = -1;
		this.capacity = capacity;
		this.items = (T[]) new Object[capacity];
	}
	
	/**
	 * Allocates more space for the stack when it gets full
	 */
	@SuppressWarnings("unchecked")
	private void allocate() {
		int newCapacity = 2 * this.capacity;
		T[] newItems = (T[]) new Object[newCapacity];
		
		for (int i = 0; i < this.capacity; i++) {
			newItems[i] = this.items[i];
		}
		
		this.items = newItems;
		this.capacity = newCapacity;
	}
	
	/**
	 * Checks whether the stack is empty
	 * @return whether the stack is empty or not
	 */
	public boolean isEmpty() {
		return (this.headPos == -1);
	}
	
	/**
	 * Checks whether the stack is full
	 * @return whether the stack is full or not
	 */
	public boolean isFull() {
		return (this.headPos == this.capacity - 1);
	}
	
	/**
	 * Peeks at the top of the stack without removing the item
	 * @return the value at the top of the stack
	 */
	public T peek() {
		if (this.isEmpty()) {
			return null;
		} else {
			return this.items[headPos];
		}
	}
	
	/**
	 * Pops the top item off the stack
	 * @return the item at the top of the stack
	 */
	public T pop() {
		if (this.isEmpty()) {
			return null;
		} else {
			T item = this.items[headPos];
			this.headPos--;
			return item;
		}
	}
	
	/**
	 * Pushes the supplied to the top of the stack
	 * @param item	the item to push to the top of the stack
	 */
	public void push(T item) {
		if (this.isFull()) {
			this.allocate();
		}
		
		this.headPos++;
		this.items[headPos] = item;
	}
}
