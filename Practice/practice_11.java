import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Queue;

public class practice_11 {
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
  public static void solution(Node root){
    TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
    Queue<Tuple> queue = new LinkedList<>();

    queue.add(new Tuple(0,0,root));

    while(!queue.isEmpty()){
      Tuple temp = queue.poll();
      int row = temp.row;
      int col = temp.col;
      Node node = temp.obj;  

      if(!map.containsKey(row)){
        map.put(row,new TreeMap<>());
      }

      if(!map.get(row).containsKey(col)){
        map.get(row).put(col,new PriorityQueue<>());
      }

      map.get(row).get(col).add(node.data);

      if(node.left != null){
        queue.add(new Tuple(row-1,col+1,node.left));
      }

      if(node.right != null){
        queue.add(new Tuple(row+1,col+1,node.right));
      }    
    }
    
    ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
    for(TreeMap<Integer,PriorityQueue<Integer>> tem: map.values()){
      ArrayList<Integer> te = new ArrayList<>();
      for(PriorityQueue<Integer> sub: tem.values()){
        while(!sub.isEmpty()){
          te.add(sub.poll());
        }
      }
      answer.add(te);
    }
    
    System.out.println(answer.toString());
  }
}


class Tuple{
  int row;
  int col;
  Node obj;

  Tuple(int row,int col,Node obj){
    this.row = row;
    this.col = col;
    this.obj = obj;
  }
}