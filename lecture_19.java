public class lecture_19{
  public static void main(String[] args) {
  Node node = new Node(40);
  node.left = new Node(10);
  node.right = new Node(20);
  node.left.left = new Node(2);
  node.left.right = new Node(5);
  node.right.left = new Node(30);
  node.right.right = new Node(40);
  solution(node);    
  System.out.println();
  preOrder(node);
  }

  public static void preOrder(Node node){
    if(node == null)
      return;
    
      System.out.print(node.data+" ");
      preOrder(node.left);
      preOrder(node.right);
  }



  public static void solution(Node node){
    if(node == null){
      return;
    }

    int childSum = 0;
    if(node.left != null){
      childSum += node.left.data;
    }

    if(node.right != null){
      childSum += node.right.data;
    }

    if(childSum>node.data){
      node.data = childSum;
    }else if(childSum<=node.data){
      if(node.left!= null){
        node.left.data = node.data;
      }
      if(node.right!=null){
        node.right.data = node.data;
      }
    }

    solution(node.left);
    solution(node.right);

    int total = 0;
    if(node.left != null)
      total += node.left.data;
    
    
    if(node.right != null)
      total += node.right.data;

    // Check for leaf node
    if(node.left != null || node.right != null)
      node.data = total;
    System.out.println(total);
  }
}