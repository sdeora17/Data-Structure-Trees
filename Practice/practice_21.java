import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class practice_21 {
  public static void main(String args[]){
    Node node = new Node(10);
    
    node.left = new Node(9);
    node.left.left = new Node(1);
    node.left.right = new Node(5);
    
    node.right = new Node(15);
    node.right.left = new Node(12);
    node.right.right = new Node(5);


    // markParent(node, map);
    solution(node, node.left, 1);

  }
  public static void solution(Node node,Node target,int distance){
    HashMap<Node,Node> map = new HashMap<>();
    markParent(node, map);
    Queue<Node> queue = new LinkedList<>();
    HashMap<Node,Boolean> visited = new HashMap<>();

    int dist = 0;
    queue.add(target);
    visited.put(target,true);

    while(!queue.isEmpty()){
      if(dist == distance){
        System.out.println("Inside Break");
        while(!queue.isEmpty()){
          Node temp = queue.poll();
          System.out.println(temp.data);
        }
        break;
      }
      System.out.println(dist);

      int n = queue.size();

      for(int i = 0;i<n;i++){
        Node temp = queue.poll();

        if(temp.left != null && visited.get(temp.left) == null){
          queue.add(temp.left);
          visited.put(temp.left,true);
        }

        if(temp.right != null && visited.get(temp.right) == null){
          queue.add(temp.right);
          visited.put(temp.right,true);
        }

        if(map.get(temp) != null && visited.get(map.get(temp)) == null){
          queue.add(map.get(temp));
          visited.put(map.get(temp),true);
        }

      }
      dist = dist + 1;
    }
    
  }
  public static void markParent(Node node, HashMap<Node,Node> mapp){
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while(!queue.isEmpty()){
      Node temp = queue.poll();

      if(temp.left != null){
        mapp.put(temp.left, temp);
        queue.add(temp.left);
      }

      if(temp.right != null){
        mapp.put(temp.right,temp);
        queue.add(temp.right);
      }
    }

    for(HashMap.Entry<Node,Node> mpp: mapp.entrySet() ){
      System.out.println(mpp.getKey().data+ "-> Child");
      System.out.println(mpp.getValue().data+ "-> Parent");
    }
  }
}
