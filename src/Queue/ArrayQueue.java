/**
 * This class is for completion in exerise 1C part ii
*/

public class ArrayQueue<E> implements QueueADT<E>
{
   E[] Q;
   int f,r;
   int N;  // array size

   /**
    * Constructor for objects of class ArrayQueue.
    * In assignment 1C part ii no change need be made to this constructor.
    * With this constructor a queue can hold up to 3 (i.e. N-1)items when 
    * using the approach described in lectures.
    */
   public ArrayQueue()
   {
       N=4;
       Q = (E[]) new Object[N]; 
       f=0;
       r=0;
   }
    
   // In exercise 1C part ii complete the methods below using an array implementation 
   
   /** 
     @throws FullQueueException
   */
   public void enqueue(E element){
	     if(size() == N - 1) throw new FullQueueException("The queue is full.");
	     Q[r] = element;
	     r = (r + 1) % N;
   }

   /**
     @throws EmptyQueueException
   */
   public E dequeue(){
	    if(isEmpty()) throw new EmptyQueueException("The queue is empty.");
	    E dequeued = Q[f];
	    f = (f + 1) % N;
	    return dequeued;
   }
   
   /**
     @throws EmptyQueueException
   */
   public E front(){
	   if(isEmpty()) throw new EmptyQueueException("The queue is empty.");
	   return Q[f];
   }

   public int size(){
	   return (N - f + r) % N;
   }

   public boolean isEmpty(){
     return r == f;
   }  
}
