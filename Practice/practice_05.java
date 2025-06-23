import java.util.ArrayList;
import java.util.Stack;

public class practice_05{
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(7);
    
    root.left.left = new Node(3);
    root.left.right = new Node(4);

    root.right.left = new Node(10);
    root.right.right = new Node(15);


    solution(root);
  }
  public static void solution(Node node){
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair<>(node, 1));

    ArrayList<Node> PreOrder = new ArrayList<>();
    ArrayList<Node> PostOrder = new ArrayList<>();
    ArrayList<Node> InOrder = new ArrayList<>();

    while(!stack.isEmpty()){
      Pair temp = stack.pop();

      if(temp.rank == 1){
        PreOrder.add(temp.node);
        temp.rank++;
        stack.push(temp);

        if(temp.node.left != null){
          stack.push(new Pair<>(temp.node.left, 1));
        }

      }else if(temp.rank == 2){
        InOrder.add(temp.node);
        temp.rank++;
        stack.push(temp);

        if(temp.node.right != null){
          stack.push(new Pair<>(temp.node.right,1));
        }
      }else{
        PostOrder.add(temp.node);
      }
    }
    System.out.println("Pre Order List");
    for(Node t:PreOrder){
      System.out.print(t.data+" ");
    }
    System.out.println();
    System.out.println("PostOrder List");
    for(Node t:PostOrder){
      System.out.print(t.data+" ");
    }
    System.out.println();
    System.out.println("In Order List");
    for(Node t:InOrder){
      System.out.print(t.data+" ");
    }
    System.out.println();
  }
}

class Pair<U,V>{
  Node node;
  int rank;

  Pair(Node node,int rank){
    this.node = node;
    this.rank = rank;
  }
}