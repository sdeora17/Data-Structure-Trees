import java.util.ArrayList;
import java.util.Stack;;
public class lecture_10{
  public static void main(String args[]){
    Node node = new Node(1);
    node.left = new Node(2);

    node.right = new Node(5);
    node.right.left = new Node(11);
    node.right.right = new Node(15);
    
    
    node.left.right = new Node(5);
    node.left.right.left = new Node(9);
    node.left.right.left.left = new Node(11);
    node.left.right.left.right = new Node(14);
    ArrayList<Node> Answer = new ArrayList<>();
    leftBoundary(node, Answer);
    addLeaves(node, Answer);
    rightBoundary(node, Answer);
    System.out.println();

    for(Node temp:Answer){
      System.out.println(temp.data+" ");
    }


  }
  public static void leftBoundary(Node node,ArrayList<Node> answer){
    Node current = node.left;

    while(current!=null){ 
      if(!isLeaf(current)){
        answer.add(current);
      }

      if(current.left != null){
        current = current.left;
      }else{
        current = current.right;
      }
    }

  }

  public static boolean isLeaf(Node node){
    if(node.left == null && node.right == null){
      return true;
    }
    return false;
  }

  public static void addLeaves(Node node,ArrayList<Node> answer){
    if(isLeaf(node)){
      answer.add(node);
      return;
    }

    if(node.left != null){
      addLeaves(node.left, answer);
    }

    if(node.right!= null){
      addLeaves(node.right, answer);
    }
    

  }

  public static void rightBoundary(Node node, ArrayList<Node> answer){
    Stack<Node> semiAnswer = new Stack<>();
    Node current = node.right;

    while(current!= null){
      if(!isLeaf(current)){
        semiAnswer.push(current);
      }

      if(current.right!=null){
        current = current.right;
      }else{
        current = current.left;
      }
    }
    while(!semiAnswer.isEmpty()){
      answer.add(semiAnswer.pop());
    }
  }
}