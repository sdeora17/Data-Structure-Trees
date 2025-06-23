public class practice_20 {
  public static void main(String args[]){
    Node node = new Node(10); 
    node.left = new Node(5);
    node.right = new Node(12);
    node.left.left = new Node(1);
    node.left.right = new Node(7);
    node.right.left = new Node(11);
    node.right.right = new Node(14);
    preOrder(node);
    System.out.println();
    solution(node);
    preOrder(node);


    //   17
    //  8   12
    // 1  7 11 14

    // 

  }
  public static void preOrder(Node node){
    if(node == null){
      return;
    }

    System.out.print(node.data+" ");
    preOrder(node.left);
    preOrder(node.right);
  }


  public static void solution(Node node){
    if(node == null)
      return;
    int amount = 0;

    if(node.left != null)
      amount += node.left.data;

    if(node.right != null){
      amount+= node.right.data;
    }

    if(amount>node.data){
      node.data = amount;
    }else{
      if(node.left!= null){
        node.left.data = node.data;
      }
      if(node.right != null){
        node.right.data = node.data;
      }
    }

    solution(node.left);
    solution(node.right);

    int total = 0;

    if(node.left!= null){
      total += node.left.data;
    }
    
    if(node.right != null){
      total += node.right.data;
    }

    if(node.left!= null || node.right!= null){
      node.data = total;
    }

  }
}
