// Top view of the binary tree

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class practice_13 {
  public static void main(String args[]){
    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(3);
    node.left.left = new Node(4);
    node.left.right = new Node(5);
    node.right.left = new Node(6);
    node.right.right = new Node(7);

    solution(node);
  }
  public static void solution(Node node){
    Queue<Pair> queue = new LinkedList<>();
    TreeMap<Integer,Integer> map = new TreeMap<>();

    queue.add(new Pair(0, node));

    while (!queue.isEmpty()) {
      Pair top = queue.poll();
      int level = top.level;
      Node temp = top.node;

      if(!map.containsKey(level)){
        map.put(level,temp.data);
      }

      if(temp.left != null){
        queue.add(new Pair(level-1,temp.left));
      }

      if(temp.right != null){
        queue.add(new Pair(level+1,temp.right));
      }
    }

    for(Integer temp: map.values()){
      System.out.print(temp+" ");
    }

  }

}


class Pair{
  int level;
  Node node;

  Pair(int level,Node node){
    this.level = level;
    this.node = node;
  }
}