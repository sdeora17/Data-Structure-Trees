import java.util.ArrayList;
import java.util.Stack;

// Pre - Order, Post - Order, In - Order Traversal in one go.

public class lecture_04 {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(7);
    
    root.left.left = new Node(3);
    root.left.right = new Node(4);


    root.left.right.left = new Node(5);
    root.left.right.left = new Node(6);

    solution(root);
  } 

  public static void solution(Node node){
    Stack<Pair> st = new Stack<>();
    st.add(new Pair<>(node,1));

    ArrayList<Node> preOrder = new ArrayList<>();
    ArrayList<Node> postOrder = new ArrayList<>();
    ArrayList<Node> inOrder = new ArrayList<>();

    if(node == null){
      return;
    }


    while(!st.isEmpty()){
      Pair it = st.pop();

      if(it.second == 1){
        preOrder.add(it.first);
        it.second++;
        st.push(it);


        if(it.first.left != null){
          st.push(new Pair<>(it.first.left, 1));
        }
      }
      else if(it.second == 2){
        inOrder.add(it.first);
        it.second++;
        st.push(it);

        if(it.first.right != null){
          st.push(new Pair<>(it.first.right,1));
        }
      }
      else if(it.second == 3){
        postOrder.add(it.first);
      }
    }
    System.out.println("Pre Order");
    for(Node temp:preOrder){
      System.out.print(temp.data);
    }
    System.out.println();

    System.out.println("In Order");
    for(Node temp:inOrder){
      System.out.print(temp.data);
    }
    System.out.println();
    
    System.out.println("Post Order");
    for(Node temp:postOrder){
      System.out.print(temp.data);
    }
    System.out.println();
  }
}
