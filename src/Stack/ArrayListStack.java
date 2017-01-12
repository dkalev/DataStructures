import java.util.ArrayList;

public class ArrayListStack<E> implements StackADT<E> {

	protected ArrayList<E> stack;
	protected int indexLast;
	
	public ArrayListStack(){
		stack = new ArrayList<E>();
		indexLast = -1;
	}
	@Override
	public void push(E element) {
		stack.add(element);
		indexLast++;
		
	}

	@Override
	public E pop() {
		if(indexLast == -1) throw new EmptyStackException("The stack is empty");
		E popped = stack.remove(indexLast);
		indexLast--;
		return popped;
	}

	@Override
	public E top() {
		if(indexLast == -1) throw new EmptyStackException("The stack is empty");
		return stack.get(indexLast);
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
