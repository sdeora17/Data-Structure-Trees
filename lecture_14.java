import java.util.LinkedList;
import java.util.Queue;

public class lecture_14 {
  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(3);
    node.left.left = new Node(4);
    node.left.right = new Node(5);
    node.right.left = new Node(6);
    node.right.right = new Node(7);

    Queue<Integer> answer = solution(node,0);
    System.out.println(answer.toString());
  }
  public static Queue<Integer> solution(Node node,int level){
    Queue<Integer> answer = new LinkedList<Integer>();
    
    if(node == null){
      return answer;
    }

    System.out.print(node.data+" ");
    System.out.print(level+" ");
    System.out.println(answer.size());

    if(answer.size() == level){
      System.out.println();
      answer.add(node.data);
    }

    answer.addAll(solution(node.right,level+1));
    answer.addAll(solution(node.left,level+1));

    return answer;
  }
}
