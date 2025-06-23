// Breadth First Search

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class lecture_02{
  public static void main(String args[]){
    Node root = new Node(1);

    root.left = new Node(2);
    root.right = new Node(3);
    
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.left = new Node(7);
    root.right.right = new Node(8);


    ArrayList<ArrayList<Node>> answer= solution_01(root);

    for(ArrayList<Node> temp : answer){
      for(Node node: temp){
        System.out.print(node.data+" ");
      }
      System.out.println();
    }

  }
  public static ArrayList<ArrayList<Node>> solution(Node node){
    Queue<Node> queue = new LinkedList<Node>();
    ArrayList<ArrayList<Node>> Answer = new ArrayList<>();

    if(node == null){
      return Answer;
    }

    queue.add(node);
    
    
    while(!queue.isEmpty()){
        int queueSize = queue.size();
        ArrayList<Node> sublist = new ArrayList<>();

      for (int i = 0; i < queueSize; i++) {

        Node temp = queue.remove();

        if(temp.left != null){
          queue.add(temp.left);
        }
        if(temp.right != null){
          queue.add(temp.right);
        }

        sublist.add(temp);
      }

    
      Answer.add(sublist);
    }



    return Answer;
  }

  public static ArrayList<ArrayList<Node>> solution_01(Node node){
    Queue<Node> frontalQueue = new LinkedList<>();
    ArrayList<ArrayList<Node>> Answer = new ArrayList<>();

    if(node == null){
      return Answer;
    }

    frontalQueue.add(node); // Root;

    while(!frontalQueue.isEmpty()){
      ArrayList<Node> sublist = new ArrayList<>();
      int size = frontalQueue.size();

      for (int i = 0; i < size; i++) {
        Node temp = frontalQueue.remove();

        if(temp.left != null){
          frontalQueue.add(temp.left);
        }

        if(temp.right != null){
          frontalQueue.add(temp.right);
        }
      

        sublist.add(temp);
      }
      Answer.add(sublist);
    }
  
    return Answer;
  }
  
}