import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArrayQueueTest
 */
public class ArrayQueueTest
{
    
	@Test
	public void exists_test() {
		QueueADT<String> q = new ArrayQueue<>();
		assertNotNull(q);
	}
	
	
	@Test
	public void exists_size_test() {
		QueueADT<String> q = new ArrayQueue<>();
		assertNotNull(q);
		assertEquals(0, q.size());
	}

	
	@Test (expected = EmptyQueueException.class)
	public void emptyDequeue_test() throws EmptyQueueException {
		QueueADT<String> q = new ArrayQueue<>();
		q.dequeue();
	}
	
	@Test
	public void empty_test() {
		QueueADT<String> q = new ArrayQueue<>();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void empty_actual_test() {
		QueueADT<String> q = new ArrayQueue<>();
		try {
			q.enqueue("AA");
		} catch (FullQueueException e) {
			e.printStackTrace();
		}
		
		assertFalse(q.isEmpty());
	}
	
	@Test
	public void enqueueTest_test() {
		QueueADT<String> q = new ArrayQueue<>();
		try {
			q.enqueue("A");
		} catch (FullQueueException e) {
			e.printStackTrace();
		}
		assertEquals(1, q.size());
	}
	
	@Test (expected = FullQueueException.class)
	public void enqueueFull_test() throws FullQueueException {
		QueueADT<String> q = new ArrayQueue<>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
	}
	
	@Test
	public void dequeueTest_test() {
		QueueADT<String> q = new ArrayQueue<>();
		try {
			q.enqueue("A");
			q.enqueue("B");
		} catch (FullQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertEquals("A", q.dequeue());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test (expected = EmptyQueueException.class)
	public void frontEmpty_test() throws EmptyQueueException {
		QueueADT<String> q = new ArrayQueue<>();
		q.front();
	}
	
	
	@Test
	public void front_test() {
		QueueADT<String> q = new ArrayQueue<>();
		try {
			q.enqueue("A");
		} catch (FullQueueException e) {
			e.printStackTrace();
		}
		try {
			assertEquals("A", q.front());
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void front2_test() {
		QueueADT<String> q = new ArrayQueue<>();
		try {
			q.enqueue("A");
			q.enqueue("B");
		} catch (FullQueueException e) {
			e.printStackTrace();
		}
		try {
			assertEquals("A", q.front());
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void shuffle_test() throws FullQueueException, EmptyQueueException {
		QueueADT<String> q = new ArrayQueue<>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");    // add 3 [a,b,c]
		assertEquals(3, q.size()); 
		q.dequeue();        // remove 1 [b,c]
		assertEquals(2, q.size());
		q.enqueue("D");    
		assertEquals(3, q.size());
		q.dequeue(); 
		q.dequeue(); 
		assertEquals("D", q.front());
		assertEquals(1, q.size());
		assertFalse(q.isEmpty());
		q.dequeue(); 
		assertTrue(q.isEmpty());
	}
	
}
