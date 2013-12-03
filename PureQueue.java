/*
 * @(#)Queue.java	1.5 03/12/19
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

 
public interface PureQueue<E> // Note: does not extend Collection<E>
{

	/**
	 * Determines the number of elements in this PureQueue object.
	 *
	 * @return the number of elements in this PureQueue object.
	 *
	 */
	int size();


	/**
	 * Determines if this PureQueue object has no elements.
	 *
	 * @return true - if this PureQueue object has no elements; otherwise,
	 *                return false.
	 *
	 */
	boolean isEmpty();
		

	/**
	 * Inserts the specified element into this queue.  
	 * @param o the element to insert.
	 * @return <tt>true</tt> if it was possible to add the element to
	 * this queue, else <tt>false</tt>
	 */
	boolean offer(E o);

	/**
	 * Retrieves and removes the head of this queue, or <tt>null</tt>
	 * if this queue is empty.
	 *
	 * @return the head of this queue, or <tt>null</tt> if this
	 *		   queue is empty.
	 */
	E poll();

	/**
	 * Retrieves and removes the head of this queue.  This method
	 * differs from the <tt>poll</tt> method in that it throws an
	 * exception if this queue is empty.
	 *
	 * @return the head of this queue.
	 * @throws NoSuchElementException if this queue is empty.
	 */
	E remove();

	/**
	 * Retrieves, but does not remove, the head of this queue,
	 * returning <tt>null</tt> if this queue is empty.
	 *
	 * @return the head of this queue, or <tt>null</tt> if this queue
	 * is empty.
	 */
	E peek();

	/**
	 * Retrieves, but does not remove, the head of this queue.	This method
	 * differs from the <tt>peek</tt> method only in that it throws an
	 * exception if this queue is empty.
	 *
	 * @return the head of this queue.
	 * @throws NoSuchElementException if this queue is empty.
	 */
	E element();
}
