/*Name: Emerald Baldwin
  Assignment: Lab 7
  Title: ArrayQueue
  Course: CSCE 270
  Lab Section: 2
  Semester: Fall 2013
  Instructor: Kenneth Blaha
  Date: 11/10/13
  Sources consulted: Dr. Blaha
  Program description: This program implements the PureQueue interface
  */

import java.util.NoSuchElementException;


public class ArrayQueue<E> implements PureQueue<E> {

	private E[] theData; // the array that will hold our queue
	private int size; // the number of elements this queue contains
	private int capacity; //the number of elements this queue can contain
	private int front; // the "first" element in the queue
	private int rear; // the "last" element in the queue
	private final static int DEFAULT_CAPACITY = 10;
	
	/**
	 * No-arg constructor
	 */
	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor
	 * @param initCapacity the amount of elements the user would 
	 * like the queue to be able to hold
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue(int initCapacity) {
		theData = (E[]) new Object[initCapacity];
		front = 0;
		capacity = initCapacity;
		rear = capacity - 1;
		size = 0;
	}
	
	/**
	 * Determines the number of elements in this PureQueue object.
	 *
	 * @return the number of elements in this PureQueue object.
	 *
	 */
	@Override
	public int size() {
		return size;
	}
	
	
	/**
	 * Determines if this PureQueue object has no elements.
	 *
	 * @return true - if this PureQueue object has no elements; otherwise,
	 *                return false.
	 *
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Inserts the specified element into this queue.  
	 * @param o the element to insert.
	 * @return true if it was possible to add the element to
	 * this queue, else false
	 */
	@Override
	public boolean offer(E o) {
		if (size == capacity) {
			reallocate();
		}
		size++;
		rear = (rear + 1) % capacity; // this array is circular
		theData[rear] = o;
		return true;
	}
	
	
	/**
	 * Retrieves and removes the head of this queue, or null
	 * if this queue is empty.
	 *
	 * @return the head of this queue, or null if this
	 *		   queue is empty.
	 */
	@Override
	public E poll() {
		if (size == 0) {
			return null;
		}
		E result = theData[front];
		front = (front + 1) % capacity;
		size--;
		return result;
	}
	
	
	/**
	 * Retrieves and removes the head of this queue.  This method
	 * differs from the poll method in that it throws an
	 * exception if this queue is empty.
	 *
	 * @return the head of this queue.
	 * @throws NoSuchElementException if this queue is empty.
	 */
	@Override
	public E remove() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		E result = theData[front];
		front = (front + 1) % capacity;
		size--;
		return result;
	}
	
	
	/**
	 * Retrieves, but does not remove, the head of this queue,
	 * returning null if this queue is empty.
	 *
	 * @return the head of this queue, or null if this queue
	 * is empty.
	 */
	@Override
	public E peek() {
		if (size == 0) {
			return null;
		} else {
			return theData[front];
		}
	}

	
	/**
	 * Retrieves, but does not remove, the head of this queue.	This method
	 * differs from the peek method only in that it throws an
	 * exception if this queue is empty.
	 *
	 * @return the head of this queue.
	 * @throws NoSuchElementException if this queue is empty.
	 */
	@Override
	public E element() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			return theData[front];
		}
	}
	
	/**
	 * Clears the array of its elements
	 */
	public void clear() {
		size = 0;
		front = 0;
		rear = capacity - 1;
	}
	
	/**
	 * Prints out a string representation of this array
	 * @return the String representation of this array
	 */
	public String toString() {
		int index = front;
		String s = "[";
		if (isEmpty()) {
			return "[]";
		} else {
			for (int i = 0; i < size - 1; i++) {
				s += theData[index] + ", ";
				index = (index + 1) % capacity;
			}
			s += theData[rear] + "]";
			return s;
		}
	}
	
	/**
	 * Private helper class that increases the capacity of
	 * the array when it is full. It re-instantiates front,
	 * theData, and capacity in relation to the new larger
	 * capacity, which is two times the former capacity
	 */
	@SuppressWarnings("unchecked")
	private void reallocate() {
		int newCapacity = 2 * capacity;
		E[] newData = (E[]) new Object[newCapacity];
		int j = front;
		for (int i = 0; i < size; i++) {
			newData[i] = theData[j];
			j = (j + 1) % capacity;
		}
		front = 0;
		theData = newData;
		capacity = newCapacity;
	}

}
