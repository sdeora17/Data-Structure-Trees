import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class lecture_20 {
  public static void main(String[] args) {
    Node node = new Node(3);
    node.left = new Node(5);
    node.right = new Node(1);
    node.left.left = new Node(6);
    node.left.right = new Node(2);
    node.right.left = new Node(0);
    node.right.right = new Node(8);
    node.left.right.left = new Node(7);
    node.left.right.right = new Node(4);
    
    solution(node, node.left, 2);

  } 
  public static void mark_Parent(Node node,HashMap<Node,Node> parent_track){
    Queue<Node> que = new LinkedList<>();
    que.add(node);

    while(!que.isEmpty()){
      Node temp = que.poll();
      if(temp.left != null){
        parent_track.put(temp.left,temp);
        que.add(temp.left);
      }
      if(temp.right!= null){
        parent_track.put(temp.right, temp);
        que.add(temp.right);
      }
    }

    for(Map.Entry<Node,Node> entry: parent_track.entrySet()){
      System.out.println("Key "+entry.getKey().data+" Value "+entry.getValue().data);
    }
  }

  public static void solution(Node node,Node target,int k){
    HashMap<Node,Node> hmap = new HashMap<>();
    mark_Parent(node, hmap);

    HashMap<Node,Boolean> visited = new HashMap<>();
    Queue<Node> que = new LinkedList<>();
    que.add(target);
    visited.put(target,true);
    int level = 0;
   
    while(!que.isEmpty()){
        int size = que.size();
        if(level == k){
          break;
        }
        level = level + 1;

        for(int i = 0;i<size;i++){

          Node temp = que.poll();

          if(temp.left != null && visited.get(temp.left) == null){
            System.out.println("Left Value Inserted");
            visited.put(temp.left,true);
            que.add(temp.left);
          }
          
          if(temp.right != null && visited.get(temp.right) == null){
            System.out.println("Right Value Inserted");
            visited.put(temp.right,true);
            que.add(temp.right);
          }

          if(hmap.get(temp) != null && visited.get(hmap.get(temp)) == null){
            visited.put(hmap.get(temp),true);
            que.add(hmap.get(temp));
          }
        }
    }



  }
}
