package com.samitchell.simple_calculator.data_structures;

/**
 * A class to represent a queue of objects of type T
 * @author Stuart A Mitchell
 *
 * @param <T>	the type of the objects in the queue
 */
public class Queue<T> {
	private T[] items;
	private int capacity;
	private int rear;
	
	/**
	 * Default constructor - creates a queue with a capacity of 10 objects
	 */
	public Queue() {
		this(10);
	}
	
	/**
	 * Non-default constructor - creates a queue of the given capacity
	 * @param capacity	the maximum capacity of the queue
	 */
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.capacity = capacity;
		this.rear = -1;
		this.items = (T[]) new Object[this.capacity];
	}
	
	/**
	 * Allocates more space in the queue
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
	 * Places an item in the queue
	 * @param item	the item to place in the queue
	 */
	public void enqueue(T item) {
		if (this.isFull()) {
			this.allocate();
		}
		
		this.rear++;
		this.items[rear] = item;
	}
	
	/**
	 * Removes the item at the from of the queue
	 * @return	the item at the front of the queue
	 */
	public T dequeue() {
		if (this.isEmpty()) {
			return null;
		} else {
			T item = this.items[0];
			
			for (int i = 0; i < this.rear; i++) {
				this.items[i] = this.items[i+1];
			}
			
			this.rear--;
			return item;
		}
	}
	
	/**
	 * Checks whether the queue is empty
	 * @return	whether or not the queue is empty
	 */
	public boolean isEmpty() {
		return (this.rear == -1);
	}
	
	/**
	 * Checkes whether the queue is full
	 * @return	whether or not the queue is full
	 */
	public boolean isFull() {
		return (this.rear == this.capacity - 1);
	}
}
