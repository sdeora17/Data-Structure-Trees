import java.util.ArrayList;
import java.util.Stack;

public class practice_10 {
  public static void main(String args[]){
    ArrayList<Node> finalAnswer = new ArrayList<>();

    Node node = new Node(10);
    node.left = new Node(5);
    node.right = new Node(12);

    node.left.left = new Node(3);
    node.left.right = new Node(4);
    
    node.right.left = new Node(11);
    node.right.right = new Node(14);

    addLeftBoundary(node, finalAnswer);
    for(Node tmp:finalAnswer){
      System.out.print(tmp.data+" ");
    }
    System.out.println();
    addLeaves(node, finalAnswer);
    for(Node tmp:finalAnswer){
      System.out.print(tmp.data+" ");
    }
    System.out.println();
    addRightBoundary(node, finalAnswer);
    for(Node tmp:finalAnswer){
      System.out.print(tmp.data+" ");
    }
    System.out.println();
  }
  public static boolean isLeaf(Node node){
    if(node.left == null && node.right == null){
      return true;
    }

    return false;
  }


 
  public static void addLeftBoundary(Node node,ArrayList<Node> answer){
    answer.add(node);

    Node leftSide = node.left;

    while(leftSide != null){
      if(!isLeaf(leftSide)){
        answer.add(leftSide);
      }

      if(leftSide.left != null){
        leftSide = leftSide.left;
      }else{
        leftSide = leftSide.right;
      }
    }
  }
  public static void addLeaves(Node node,ArrayList<Node> answer){
    // In-Order Traversal
    if(isLeaf(node)){
      answer.add(node);
      return;
    }

    if(node.left != null){
      addLeaves(node.left,answer);
    }

    if(node.right!= null){
      addLeaves(node.right, answer);
    }

  }

  public static void addRightBoundary(Node node,ArrayList<Node> answer){
    Node currentRight = node.right;
    Stack<Node> temp = new Stack<>();


    while(currentRight != null){
      
      if (!isLeaf(currentRight)) {
        temp.push(currentRight);
      }

      if(currentRight.right != null){
        currentRight = currentRight.right;
      }else{
        currentRight = currentRight.left;
      }
    }

    while(!temp.isEmpty()){
      answer.add(temp.pop());
    }
  }
}
