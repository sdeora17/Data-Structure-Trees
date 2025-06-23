import java.util.ArrayList;

public class practice_17 {
  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(3);
    node.left.left = new Node(4);
    node.left.right = new Node(5);
    node.right.left = new Node(6);
    node.right.right = new Node(7);
    ArrayList<Integer> object = new ArrayList<>();
    System.out.println(solution(node, 7,object));
    System.out.println(object.toString());
  }
  public static boolean solution(Node node,int left,ArrayList<Integer> answer){
    
    if(node == null){
      return false;
    }

    answer.add(node.data);

    if(node.data == left){
      return true;
    }


    if(solution(node.left, left,answer) || solution(node.right, left,answer)){
      return true;
    }

    answer.remove(answer.size()-1);

    return false;
  }
}
