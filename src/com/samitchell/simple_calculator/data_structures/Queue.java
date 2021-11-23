package com.samitchell.simple_calculator.data_structures;

public class Queue<T> {
	private T[] items;
	private int capacity;
	private int rear;
	
	public Queue() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.capacity = capacity;
		this.rear = -1;
		this.items = (T[]) new Object[this.capacity];
	}
	
	private void allocate() {
		int newCapacity = 2 * this.capacity;
		T[] newItems = (T[]) new Object[newCapacity];
		
		for (int i = 0; i < this.capacity; i++) {
			newItems[i] = this.items[i];
		}
		
		this.items = newItems;
		this.capacity = newCapacity;
	}
	
	public void enqueue(T item) {
		if (this.isFull()) {
			this.allocate();
		}
		
		this.rear++;
		this.items[rear] = item;
	}
	
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
	
	public boolean isEmpty() {
		return (this.rear == -1);
	}
	
	public boolean isFull() {
		return (this.rear == this.capacity - 1);
	}
}
