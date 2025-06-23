import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class practice_12 {
  public static void main(String[] args) {
    
        Node temp = new Node(14);
    temp.left = new Node(10);
    temp.right = new Node(12);
    temp.left.left = new Node(9);
    temp.left.right = new Node(10);
    temp.right.left = new Node(15);
    temp.right.right = new Node(21);
    solution(temp);
  }
  public static void solution(Node node){
    TreeMap<Integer,Integer> map = new TreeMap<>();
    Queue<Pair> queue = new LinkedList<>();
    
    queue.add(new Pair(0,node));

    while(!queue.isEmpty()){
      Pair temp = queue.poll();

      int level = temp.level;
      Node t = temp.node;
    
      if(!map.containsKey(level)){
        map.put(level,t.data);
      }
    
      if(t.left!=null){
        queue.add(new Pair(level-1, t.left));
      }
      if(t.right != null){
        queue.add(new Pair(level+1,t.right));
      }
    }

    for(Integer a: map.values()){
      System.out.println(a);
    }
  }
}

class Pair{
  int level;
  Node node;

  Pair(int a, Node b){
    this.level = a;
    this.node = b;
  }
}
