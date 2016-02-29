import java.util.Iterator;

public class LinkedList<AnyType> implements Iterable<AnyType> 
{

	
	
	private Node<AnyType> head;
	
		
	public LinkedList(){
		head = null;
	}
	
	public boolean isEmpty(){
		
		return head == null;
		
	}
	
	public void addFirst(AnyType item){
		
		head = new Node<AnyType>(item, head);
		
	}
	
	public AnyType getFirst(){
		if (head == null) throw new IndexOutOfBoundsException();
			
		
		return head.data;
		
	}
	
	public AnyType removeFirst(){
							
			AnyType first = head.data;
			head = head.next;
			return first;
							
	}
	
	public AnyType getLast(){
		
		Node<AnyType> tmp = head;
		
		while (tmp.next != null){
			
			tmp = tmp.next;
			
		}
		return tmp.data;
	}
	
	public void addLast(AnyType item){
		
		if (head == null){
			
			addFirst(item);
			
		}else{
			Node<AnyType> tmp = head;
			
			while (tmp.next != null){
				
				tmp = tmp.next;
				
			}
			tmp.next = new Node<AnyType>(item, null);
			
			
		}
		
	}
	
	public void clear(){
		
		head = null;
		
	}
	
	public boolean contains(AnyType item){
		
		Node<AnyType> tmp = head;
		
		while (tmp.next != null){
			
			if (tmp.data.equals(item)){
				
				return true;
				
			}
			tmp = tmp.next;
			
		}
		
		return false;
	}

	
	public AnyType get(int pos){
		
		if (head == null) throw new IndexOutOfBoundsException();
		
		Node<AnyType> tmp = head;
		
		for (int i = 0; i < pos; i++){
			
			tmp = tmp.next;
			
		}
		if (tmp == null) throw new IndexOutOfBoundsException();
			
		return tmp.data;
				
	}
	
	public String toString(){
		
		StringBuffer buffer = new StringBuffer();
		for (Object x : this){
			buffer.append(x + " ");
		}
		return buffer.toString();
	}
	
	
	public void insertAfter(AnyType key, AnyType item){
		
		Node<AnyType> tmp = head;
		
		while (tmp.next != null && !tmp.data.equals(key)){
			
			tmp = tmp.next;
		}
		if (tmp.next != null) tmp.next = new Node<AnyType>(item, tmp.next);			// if tmp.next == null the end of the list was reached
		
	}
	
	public void insertBefore(AnyType key, AnyType item){
		
		if (isEmpty()) return;
		
		if (getFirst().equals(key)) addFirst(item);
		
		Node<AnyType> tmp = head;
		Node<AnyType> prev = null;
		while (tmp.next != null && !tmp.data.equals(key)){
			prev = tmp;
			tmp = tmp.next;
		}
		prev.next = new Node<AnyType>(item, tmp);
		
		
	}
	
	public void remove(AnyType key){
		
		if (isEmpty()) return;
		
		if (getFirst().equals(key)) removeFirst();
		
		Node<AnyType> tmp = head;
		Node<AnyType> prev = null;
		
		while (tmp.next != null && !tmp.data.equals(key)){
			
			prev = tmp;
			tmp = tmp.next;
		
		}
		
		prev.next = tmp.next;
		
		
	}
	
	public LinkedList<AnyType> reverse(){
		
		LinkedList<AnyType> list = new LinkedList<AnyType>();
		Node<AnyType> tmp = head;
		
		while (tmp != null){
			
			list.addFirst(tmp.data);
			tmp = tmp.next;
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> ll = new LinkedList<String>();
		ll.addFirst("yeah");
		ll.addLast("blah");
		ll.addLast("sup");
		ll.insertAfter("blah", "newEntry");
		System.out.println(ll.contains("newEntry"));
		ll.remove("newEntry");
		System.out.println(ll.contains("newEntry"));
		System.out.println(ll.getFirst());
		//System.out.println(ll.get(100));
		System.out.println(ll.toString());
		System.out.println(ll.reverse().toString());
		
		
	}
	
		//helper classes
	private static class Node<AnyType>{
		
		private AnyType data;
		private Node<AnyType> next;
		
		public Node(AnyType data, Node<AnyType> next){
			
			this.data = data;
			this.next = next;
			
		}
		
	}
	

	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<AnyType>{

		private Node<AnyType> current;
		
		public LinkedListIterator(){
			
			current = head;
			
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!= null;
		}

		@Override
		public AnyType next() {
			// TODO Auto-generated method stub
			if (!hasNext()) throw new IndexOutOfBoundsException();
			
			AnyType res = current.data;
			current = current.next;
			
			return res;
		}
		
	}

}
