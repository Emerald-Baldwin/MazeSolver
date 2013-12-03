//jUnit test for ArrayQueue

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

public class ArrayQueueTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSize() {
		ArrayQueue<String> myQ = new ArrayQueue<String>();
		
		// test a size of 0
		assertEquals(0, myQ.size());
		
		// test a size of more than 0
		myQ.offer("Sarah");
		myQ.offer("Lily");
		assertEquals(2, myQ.size());
		
		// test a size larger than capacity
		myQ.offer("a");
		myQ.offer("b");
		myQ.offer("c");
		myQ.offer("d");
		myQ.offer("e");
		myQ.offer("f");
		myQ.offer("g");
		myQ.offer("h");
		myQ.offer("i");
		assertEquals(11, myQ.size());
	}

	@Test
	public void testIsEmpty() {
		// test with an empty array
		ArrayQueue<String> myQ = new ArrayQueue<String>();
		assertEquals(true, myQ.isEmpty());
		
		// test with a nonempty array
		myQ = new ArrayQueue<String>();
		myQ.offer("Sarah");
		assertEquals(false, myQ.isEmpty());
	}

	@Test
	public void testOffer() {
		// test adding something to a string
		ArrayQueue<String> myQ = new ArrayQueue<String>();
		myQ.offer("Sarah");
		myQ.offer("Lily");
		assertEquals("[Sarah, Lily]", myQ.toString());
	}

	@Test
	public void testPoll() {
		ArrayQueue<String> myQ = new ArrayQueue<String>();
		myQ.offer("Sarah");
		myQ.offer("Lily");
		assertEquals("[Sarah, Lily]", myQ.toString());
		assertEquals("Sarah", myQ.poll());
		myQ.poll();
		
		// test when nothing in ArrayQueue
		assertEquals(null, myQ.poll());
	}

	@Test (expected = NoSuchElementException.class)
	public void testRemove() {
		ArrayQueue<String> myQ = new ArrayQueue<String>();
		myQ.offer("Sarah");
		myQ.offer("Lily");
		assertEquals("[Sarah, Lily]", myQ.toString());
		assertEquals("Sarah", myQ.remove());
		myQ.remove();
		// will throw an exception
		myQ.remove();
	}

	@Test
	public void testPeek() {
		ArrayQueue<String> myQ = new ArrayQueue<String>();
		myQ.offer("Sarah");
		myQ.offer("Lily");
		assertEquals("Sarah", myQ.peek());
		myQ.remove();
		myQ.remove();
		assertEquals(null, myQ.peek());
	}

	@Test (expected = NoSuchElementException.class)
	public void testElement() {
		ArrayQueue<String> myQ = new ArrayQueue<String>();
		myQ.offer("Sarah");
		myQ.offer("Lily");
		assertEquals("Sarah", myQ.element());
		myQ.remove();
		myQ.remove();
		// will throw an exception
		myQ.element();
	}
	
	@Test
	public void testToString() {
		ArrayQueue<String> myQ = new ArrayQueue<String>();
		// test with no elements in ArrayQueue
		assertEquals("[]", myQ.toString());
		myQ.offer("Lily");
		// test with one element in ArrayQueue
		assertEquals("[Lily]", myQ.toString());
		myQ.offer("a");
		myQ.offer("b");
		myQ.offer("c");
		myQ.offer("d");
		myQ.offer("e");
		myQ.offer("f");
		myQ.offer("g");
		myQ.offer("h");
		myQ.offer("i");
		// test with many elements in ArrayQueue
		assertEquals("[Lily, a, b, c, d, e, f, g, h, i]", myQ.toString());
	}
	
	@Test
	public void testClear() {
		ArrayQueue<String> myQ = new ArrayQueue<String>();
		// test clear when myQ is empty
		myQ.clear();
		
		// test clear when myQ contains something
		myQ.offer("Sarah");
		myQ.offer("Lily");
		myQ.clear();
		assertEquals("[]", myQ.toString());
	}

}
