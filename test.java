import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test {
  public static void main(String[] args) {
    Node test = new Node(12);
    test.left = new Node(10);    
    test.right = new Node(15);
    test.left.left = new Node(9);
    test.left.right = new Node(11);
    test.right.left = new Node(18);
    test.right.right = new Node(20);
    solution(test);    
  }
  public static void solution(Node node){
    ArrayList<Node> answer = new ArrayList<>();
    Queue<Node> frontalQueue = new LinkedList<>();


    frontalQueue.add(node);

    while(!frontalQueue.isEmpty()){

      Node temp = frontalQueue.remove();
      answer.add(temp);

      if(temp.left!= null){
        frontalQueue.add(temp.left);
      }

      if(temp.right!= null){
        frontalQueue.add(temp.right);
      }
    }

    for(Node tmp:answer){
      System.out.print(tmp.data+" ");
    }
    System.out.println();
  }
}
