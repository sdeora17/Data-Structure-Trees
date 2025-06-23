// Zig Zag Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class practice_09 {
  public static void main(String[] args) {
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

    ArrayList<ArrayList<Node>> answer = solution(root);
    for(ArrayList<Node> temp: answer){
      for(Node tmp:temp){
        System.out.print(tmp.data+" ");
      }
      System.out.println();
    }

  }
  public static ArrayList<ArrayList<Node>> solution(Node node){
    Queue<Node> frontalQueue = new LinkedList<>();
    ArrayList<ArrayList<Node>> finalAnswer = new ArrayList<>();

    frontalQueue.add(node);
    boolean flag = false;

    while (!frontalQueue.isEmpty()) {
      ArrayList<Node> sublist = new ArrayList<>();
      int n = frontalQueue.size();
      for (int i = 0; i < n; i++) {

        Node temp = frontalQueue.remove();

        if(temp.left != null){
          frontalQueue.add(temp.left);
        }

        if(temp.right != null){
          frontalQueue.add(temp.right);
        }
        
        sublist.add(temp);
      }

      if(flag == false){
        finalAnswer.add(sublist);
        flag = true;
      }else if(flag == true){
        int left = 0;
        int right = sublist.size()-1;

        while(left<=right){
          Node temp = sublist.get(left);
          sublist.set(left,sublist.get(right));
          sublist.set(right,temp);
          left++;
          right--;
        }

        finalAnswer.add(sublist);
        flag = false;
      }
    }

    return finalAnswer;
  }
}
