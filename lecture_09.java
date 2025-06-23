import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class lecture_09 {
  public static void main(String args[]){
    Node root = new Node(1);

    
    root.left = new Node(2);
    root.left.left = new Node(5);
    root.left.right = new Node(4);
    
    root.right = new Node(3);
    root.right.left = new Node(7);
    root.right.right = new Node(6);
    
    root.left.left.left = new Node(12);
    root.left.left.right = new Node(15);

    root.left.right.left = new Node(16);
    root.left.right.right = new Node(18);



    solution(root);
  }
  public static void solution(Node node){
    Queue<Node> frontalQueue = new LinkedList<>();
    ArrayList<ArrayList<Node>> FinalAnswer = new ArrayList<>();
    
    boolean flag = false;
    frontalQueue.add(node);

    while(!frontalQueue.isEmpty()){
      int n = frontalQueue.size();
      ArrayList<Node> subAnswer = new ArrayList<>();
      // flag = false;

      for (int i = 0; i < n; i++) {
        Node temp = frontalQueue.remove();

        if(temp.left != null){
          frontalQueue.add(temp.left);
        }

        if(temp.right!=null){
          frontalQueue.add(temp.right);
        }
        subAnswer.add(temp);
      }

      if(flag == false){
        System.out.println("Inside false");
        FinalAnswer.add(subAnswer);
        flag = true;
      }else{
        System.out.println("Inside true");
        int left = 0;
        int right = subAnswer.size()-1;
        while(left<right){
          Node temp = subAnswer.get(left);
          subAnswer.set(left,subAnswer.get(right));
          subAnswer.set(right,temp);
          left++;
          right--;
        }
        for(Node tem:subAnswer){
          System.out.println(tem.data);
        }
        FinalAnswer.add(subAnswer);
        flag = false;
      }
    }

    for(ArrayList<Node> tmp : FinalAnswer){
      for(Node temp: tmp){
        System.out.print(temp.data+" ");
      }
      System.out.println();
    }
  }
}
