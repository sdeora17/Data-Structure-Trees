import java.util.LinkedList;
import java.util.Queue;

public class lecture_21 {
  public static void main(String args[]){
    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(3);
    node.left.right = new Node(4);
    node.left.left = new Node(5);
    node.right.left = new Node(6);
    node.right.right = new Node(9);
    System.out.println(better_solution(node));
  }
  public static void solution(Node node){
    if(node == null){
      System.out.println(0);
      return;
    }

    Queue<Node> newQueue = new LinkedList<>();
    int count = 1;
    newQueue.add(node);

    while(!newQueue.isEmpty()){
      Node temp = newQueue.poll();

      if(temp.left != null){
        count++;
        newQueue.add(temp.left);
      }

      if(temp.right != null){
        count++;
        newQueue.add(temp.right);
      }
    }

    System.out.println(count);
  }

  public static double better_solution(Node node){
    if(node == null)
      return 0;

    int lh = Left_Height(node);
    int rh = Right_Height(node);
    
    if(lh == rh){
      return Math.pow(2, rh) -1;
    }

    return 1 + better_solution(node.left) + better_solution(node.right);
  
  }
  public static int Left_Height(Node node){
    if(node == null){
      return 0;
    }
    int count = 0;
    while (node!=null) {
      count = count + 1;
      node = node.left;
    }
    return count;
  }
  public static int Right_Height(Node node){
    if(node == null){
      return 0;
    }
    int count = 0;
    while (node!=null) {
      count = count + 1;
      node = node.right;
    }

    return count;
  }

}
