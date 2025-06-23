import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Queue;

public class lecture_13{
  public static void main(String args[]){
    Node node = new Node(10);
    node.left = new Node(5);
    node.right = new Node(15);
    node.left.left = new Node(3);
    node.left.right = new Node(9);
    node.right.left = new Node(12);
    node.right.right = new Node(15);
    node.left.right.left = new Node(8);
    node.left.right.right = new Node(12);
    solution(node);
  }
  public static void solution(Node node){
    TreeMap<Integer,Integer> map = new TreeMap<>();
    Queue<Pair> que = new LinkedList<>();

    que.add(new Pair(0, node));

    while(!que.isEmpty()){
      Pair test = que.poll();
      int level = test.level;
      Node temp = test.node;


      map.put(level,temp.data);


      if(temp.left!= null){
        que.add(new Pair(level-1,temp.left));
      }

      if(temp.right!= null){
        que.add(new Pair(level+1,temp.right));
      }



    }
          for(Integer test: map.values()){
            System.out.print(test+" ");
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