
public class ExtendableArrayQueue<E> implements QueueADT<E> {

	  E[] Q;
	  int f,r;
	  int N;
	  
	  public ExtendableArrayQueue()
	   {
	       N=4;
	       Q = (E[]) new Object[N]; 
	       f=0;
	       r=0;
	   }
	  private void extend(){
		  E[] temp = Q;
		  Q = (E[]) new Object[N*2];
		  int i = 0;
		  while(r != f){
			  Q[i] = temp[f];
			  f = (f + 1) % N;
			  i++;
		  }
		  f = 0;
		  r = i;
		  N = N*2;
	  }
	
	@Override
	public void enqueue(E element) {
		if(r == -((f - 1) % N)) extend();
		Q[r] = element;
		r = (r + 1) % N;
		
	}

	@Override
	public E dequeue() {
		if(isEmpty()) throw new EmptyQueueException("The queue is empty");
		E dequeued = Q[f];
		f = (f + 1) % N;
		return dequeued;
	}

	@Override
	public E front() {
		if(isEmpty()) throw new EmptyQueueException("The queue is empty");
		return Q[f];
	}

	@Override
	public int size() {
		return (N - f + r) % N;
	}

	@Override
	public boolean isEmpty() {
		return r == f;
	}

}
