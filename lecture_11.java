import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class lecture_11 {
  public static void main(String[] args) {
    Node test = new Node(12);
    test.left = new Node(10);    
    test.right = new Node(15);
    test.left.left = new Node(9);
    test.left.right = new Node(11);
    test.right.left = new Node(18);
    test.right.right = new Node(20);
    solution(test);    

  }
  public static void solution(Node node){
    TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> answer = new TreeMap<>();
    Queue<Tuple> queue= new LinkedList<>();
    queue.add(new Tuple(0,0,node));

    while(!queue.isEmpty()){
      Tuple tuple = queue.poll();
      int row = tuple.row;
      int col = tuple.col;
      Node temp = tuple.node;

      if(!answer.containsKey(row)){
        System.out.println("Adding in the level "+ row);
        answer.put(row,new TreeMap<>());
      }

      if(!answer.get(row).containsKey(col)){
        System.out.println("Adding in the col "+col);
        answer.get(row).put(col,new PriorityQueue<>());
      }
      System.out.println("Adding the value "+temp.data);
      answer.get(row).get(col).offer(temp.data);

      if(temp.left != null){
        queue.add(new Tuple(row-1, col+1, temp.left));
      }
      if(temp.right!= null){
        queue.add(new Tuple(row+1,col+1,temp.right));
      }
    }


    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    for(TreeMap<Integer,PriorityQueue<Integer>> qs: answer.values()){
      ArrayList<Integer> temp = new ArrayList<>();
      for(PriorityQueue<Integer> s: qs.values()){
        while(!s.isEmpty()){
          temp.add(s.poll());
        }
      }
      ans.add(temp);
    }
    
    System.out.println(ans.toString());
  }
}


class Tuple{
  int row;
  int col;
  Node node;

  Tuple(int row,int col,Node node){
    this.row = row;
    this.col = col;
    this.node = node;
  }
}
