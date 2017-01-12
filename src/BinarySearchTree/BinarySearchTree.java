public class BinarySearchTree<E extends Comparable<E>> { 
      private BSTNode<E> root; 
 
      public BinarySearchTree() { 
            root = null; 
      } 

      public boolean search(E value) { 
            if (root == null) 
                  return false; 
            else 
                  return root.search(value); 
      }

      public boolean add(E value) { 
            if (root == null) { 
                  root = new BSTNode<E>(value); 
                  return true; 
            } else 
                  return root.add(value); 
      } 

      public boolean remove(E value) { 
        if (root == null) 
           return false; 
        else { 
           if (root.getValue().compareTo(value) == 0) { 
               BSTNode<E> auxRoot = new BSTNode<E>(null); 
               auxRoot.setLeftChild(root); 
               boolean result = root.remove(value, auxRoot); 
               root = auxRoot.getLeftChild(); 
               return result; 
           } else { 
               return root.remove(value, null); 
           } 
         } 
      }
      
    private void printInorder(BSTNode<E> parent){
      	
    	  if (parent == null)return;
    	  printInorder(parent.getLeftChild());
    	  System.out.print(parent.getValue()+" ");
    	  printInorder(parent.getRightChild());
    }
      
    public void displayValues(){  
    	printInorder(root);
    }
    public boolean isEmpty(){
    	return root == null;
    }
      
}
