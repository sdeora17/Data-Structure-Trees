// Post Order using one stack

import java.util.ArrayList;
import java.util.Stack;

public class practice_04 {
  public static void main(String args[]){
    Node node = new Node(14);
    node.left = new Node(12);
    node.right = new Node(18);

    node.left.left = new Node(10);
    node.left.right = new Node(13);

    node.right.left = new Node(17);
    node.right.right = new Node(22);
    solution(node);
  }
  public static void solution(Node node){
    Stack<Node> stackTemp = new Stack<>();
    ArrayList<Node> answer = new ArrayList<>();

    Node current = node;

    while(current != null || !stackTemp.isEmpty()){
      if(current != null){
        stackTemp.add(current);
        current = current.left;
      }else{
       Node temp = stackTemp.peek().right;
       if(temp == null){
        temp = stackTemp.pop();
        answer.add(temp);
        while(!stackTemp.isEmpty() && stackTemp.peek().right == temp){
          temp = stackTemp.pop();
          answer.add(temp);
        }
       }else{
        current = temp;
       } 
      }
    }
    for(Node a : answer){
      System.out.println(a.data);
    }
  }
}


class Node {
  int data;
  Node left;
  Node right;
  
  public Node(int data){
    this.data = data;
  }
}

