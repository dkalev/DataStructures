public class NodeQueue<E> implements QueueADT<E>{
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public NodeQueue(){
		head = null;
		tail = null;
		size = 0;
	}
	@Override
	public void enqueue(E element) {
		Node<E> temp = new Node<E>(element, null);
		if(isEmpty()){
			head = temp;
			tail = head;
		}else{			
			tail.setNext(temp);
			tail = temp;
		}
		size++;
	}

	@Override
	public E dequeue() {
		if(isEmpty()) throw new EmptyQueueException("Queue is empty.");
		E dequeued = head.getElement();
		head = head.getNext();
		size--;
		return dequeued;
	}

	@Override
	public E front() {
		if(isEmpty()) throw new EmptyQueueException("Queue is empty.");
		return head.getElement();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	
	
	
	
}
