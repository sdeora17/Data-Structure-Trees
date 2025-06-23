// package Practice;

// Question Display the breadth for search

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class practice_01 {
  public static void main(String[] args) {
    Node node = new Node(4);
    node.left = new Node(6);
    node.right = new Node(9);

    node.left.left = new Node(11);
    node.left.right = new Node(14);
    
    node.right.left = new Node(3);
    node.right.right = new Node(11);

    ArrayList<ArrayList<Node>> answer = solution(node);
    for(ArrayList<Node> temp : answer){
      for(Node sode:temp){
        System.out.print(sode.data+" ");
      }
      System.out.println();
    }
    solution_01(node);
  }
  public static ArrayList<ArrayList<Node>> solution(Node node){
    Queue<Node> queue = new LinkedList<>();
    ArrayList<ArrayList<Node>> question = new ArrayList<>();

    queue.add(node);

    while(!queue.isEmpty()){
      int n = queue.size();
      ArrayList<Node> sublist = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        Node temp = queue.remove();

        if(temp.left!= null){
          queue.add(temp.left);
        }
        if(temp.right!=null){
          queue.add(temp.right);
        }
        sublist.add(temp);
      }

      question.add(sublist);
    }

    return question;
  }

    public static void solution_01(Node node){
      ArrayList<ArrayList<Node>> FinalAnswer = new ArrayList<>();
      Queue<Node> Frontal = new LinkedList<>();

      Frontal.add(node);

      while(!Frontal.isEmpty()){
        ArrayList<Node> sublist = new ArrayList<>();
        int n = Frontal.size();
        for (int i = 0; i < n; i++) {
          Node temp = Frontal.remove();

          if(temp.left != null){
            Frontal.add(temp.left);
          }
          if(temp.right!=null){
            Frontal.add(temp.right);
          }

          sublist.add(temp);
        }
        FinalAnswer.add(sublist);
      }


      for(ArrayList<Node> temp: FinalAnswer){
        System.out.print("[");
        for(Node tem: temp){
          System.out.print(tem.data+" ");
        }
        System.out.print("]");
        System.out.println();
      }
    }
}
