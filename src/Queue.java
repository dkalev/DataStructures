
public class Queue<AnyType> {
	
	private LinkedList<AnyType> list;
	
	public Queue(){
		
		list = new LinkedList<AnyType>();
		
	}
	
	public void enqueue(AnyType item){
		
		list.addLast(item);
		
	}
	
	public AnyType dequeue(){
		
		return list.removeFirst();
		
	}
	
	public AnyType peek(){
		
		return list.getFirst();
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<String> q = new Queue<String>();
		q.enqueue("cart");
		q.enqueue("part");
		q.enqueue("smart");
		System.out.println(q.peek());
		q.enqueue("Bart");
		System.out.println(q.dequeue());
		System.out.println(q.peek());
		
	}

}
