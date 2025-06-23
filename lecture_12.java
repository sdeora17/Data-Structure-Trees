import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class lecture_12 {
  public static void main(String[] args) {
    Node node = new Node(12);
    node.left = new Node(10);
    node.right = new Node(14);
    node.left.left = new Node(9);
    node.left.right = new Node(11);
    node.right.left = new Node(13);
    node.right.right = new Node(19);

    solution(node);
    
  }
  public static void solution(Node node){
    Queue<Pair> pair = new LinkedList<>();
    TreeMap<Integer,Integer> map = new TreeMap<>();

    pair.add(new Pair(0,node));

    while(!pair.isEmpty()){
      Pair temp = pair.poll();

      int level = temp.level;
      Node tem = temp.node;

      if(!map.containsKey(level)){
        map.put(level,tem.data);
      }

      if(tem.left != null){
        pair.add(new Pair(level-1,tem.left));
      }

      if(tem.right!= null){
        pair.add(new Pair(level+1,tem.right));
      }
    }
    for(int key: map.keySet()){
      System.out.println(map.get(key));
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
