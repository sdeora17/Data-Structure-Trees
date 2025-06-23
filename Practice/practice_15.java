import java.util.ArrayList;

public class practice_15{
  public static void main(String[] args) {
   Node node = new Node(1);
   node.left = new Node(2);
   node.right = new Node(3);
   
   node.left.left = new Node(4);
   node.left.right = new Node(5);

   node.right.left = new Node(6);
   node.right.right = new Node(7);

   node.left.right.right = new Node(8);

   ArrayList<Integer> object = new ArrayList<>();

   solution(node, object, 0);

    System.out.println(object.toString());

  }

  public static void solution(Node node,ArrayList<Integer> object,int level){
    if(node == null){
      return;
    }

    if(object.size() == level){
      object.add(node.data);
    }

    solution(node.left, object, level+1);
    solution(node.right, object, level+1);

  }
}