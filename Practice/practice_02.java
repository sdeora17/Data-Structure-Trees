// Iterative Pre - Order

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;
import java.util.Stack;

public class practice_02 {
  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(3);

    node.left.left = new Node(4);
    node.left.right = new Node(5);
    
    node.right.left = new Node(6);
    node.right.right = new Node(7);

    solution(node);
  }  
  public static void solution(Node node){
    Stack<Node> newStack = new Stack<>();

    if(node == null){
      return;
    }

    newStack.add(node);

    while(!newStack.isEmpty()){

    
      System.out.println(newStack.peek().data);
      Node temp = newStack.pop();

      if(temp.right!=null){
        newStack.add(temp.right);
      }

      if(temp.left!=null){
        newStack.add(temp.left);
      }
    }
  }


}
