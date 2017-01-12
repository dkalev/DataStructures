
public class BSTNode<E extends Comparable<E>>{ 
      private E value; 
      private BSTNode<E> left; 
      private BSTNode<E> right; 
 
      public BSTNode(E value) { 
            this.value = value; 
            left = null; 
            right = null; 
      } 
      
      public E getValue() {
          return value;
      }
      
      public void setValue(E value) {
          this.value = value;
      }
      
      public BSTNode<E> getLeftChild() {
          return left;
      }
      
      public BSTNode<E> getRightChild() {
          return right;
      }
       
      public void setLeftChild(BSTNode<E> node) {
          left = node;
      }
        
      public void setRightChild(BSTNode<E> node) {
          right = node;
      }
        
      public boolean search(E value) { 
            if (value.compareTo(this.value)== 0) 
                  return true; 
            else if (value.compareTo(this.value) < 0) { 
                  if (left == null) 
                        return false; 
                  else 
                        return left.search(value); 
            } else if (value.compareTo(this.value) > 0) { 
                  if (right == null) 
                        return false; 
                  else 
                        return right.search(value); 
            } 
            return false; 
      }
      
      public boolean add(E value) { 
            if (value.compareTo(this.value)== 0) 
                  return false; 
            else if (value.compareTo(this.value) < 0) { 
                  if (left == null) { 
                        left = new BSTNode<E>(value); 
                        return true; 
                  } else 
                        return left.add(value); 
            } else if (value.compareTo(this.value) > 0) { 
                  if (right == null) { 
                        right = new  BSTNode<E>(value); 
                        return true; 
                  } else 
                        return right.add(value); 
            } 
            return false; 
      } 

      public boolean remove(E value, BSTNode<E> parent) { 
        if (value.compareTo(this.value) < 0) { 
           if (left != null) 
              return left.remove(value, this); 
           else 
              return false; 
       } else if (value.compareTo(this.value) > 0) { 
           if (right != null) 
              return right.remove(value, this); 
           else 
              return false; 
       } else { 
           if (left != null && right != null) { 
               this.value = right.minValue(); 
               right.remove(this.value, this); 
           } else if (parent.left == this) { 
               parent.left = (left != null) ? left : right; 
           } else if (parent.right == this) { 
               parent.right = (left != null) ? left : right; 
           } 
           return true; 
       }
    } 
   
    public E minValue() { 
         if (left == null) 
             return value; 
         else 
             return left.minValue(); 
    }

    	
}
