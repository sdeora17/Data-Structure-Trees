import java.util.ArrayList;

public class lecture_16 {
  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(3);
    node.left.left = new Node(4);
    node.left.right = new Node(5);
    node.left.right.right = new Node(8);
    node.right.left = new Node(6);
    node.right.right = new Node(7);
    int target = 8;
    ArrayList<Integer> answer = new ArrayList<>();

    solution(node, answer, target);

    System.out.println(answer.toString());
  }
  public static boolean solution(Node node,ArrayList<Integer> answer,int target){
    if(node == null){
      return false;
    }

    answer.add(node.data);

    if(node.data == target){
      return true;
    }

    if(solution(node.left, answer, target) || solution(node.right, answer, target)){
      return true;
    }


    answer.remove(answer.size()-1);
    return false;
  }
}
