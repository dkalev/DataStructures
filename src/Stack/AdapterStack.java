import java.util.Stack;

public class AdapterStack<E> implements StackADT<E>{

	protected Stack<E> stack;
	
	public AdapterStack(){
		stack = new Stack<E>();
	}

	@Override
	public void push(E element) {
		stack.push(element);
		
	}

	@Override
	public E pop() {
		if(stack.isEmpty()) throw new EmptyStackException("Stack is empty");
		return stack.pop();
	}

	@Override
	public E top() {
		if(stack.isEmpty()) throw new EmptyStackException("Stack is empty");
		return stack.peek();
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
