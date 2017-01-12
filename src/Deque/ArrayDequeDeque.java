import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDeque<E> implements DequeADT<E> {
	
	
	protected Deque<E> deque;
	
	public ArrayDequeDeque(){
		deque = new ArrayDeque<E>();
	}
	
	@Override
	public int size() {
		return deque.size();
	}

	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}

	@Override
	public void addFirst(E element) {
		deque.addFirst(element);
		
	}

	@Override
	public void addLast(E element) {
		deque.addLast(element);
		
	}

	@Override
	public E getFirst() {
		if(isEmpty()) throw new EmptyDequeException("Deque is empty");
		return deque.getFirst();
	}

	@Override
	public E getLast() {
		if(isEmpty()) throw new EmptyDequeException("Deque is empty");
		return deque.getLast();
	}

	@Override
	public E removeFirst() {
		if(isEmpty()) throw new EmptyDequeException("Deque is empty");
		return deque.removeFirst();
	}

	@Override
	public E removeLast() {
		if(isEmpty()) throw new EmptyDequeException("Deque is empty");
		return deque.removeLast();
	}

}
