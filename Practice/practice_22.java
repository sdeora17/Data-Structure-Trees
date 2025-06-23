import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class practice_22 {
  public static void main(String[] args) {
    Node node = new Node(10);
    
    node.left = new Node(9);
    node.left.left = new Node(1);
    node.left.right = new Node(5);
    
    node.right = new Node(15);
    node.right.left = new Node(12);
    node.right.right = new Node(5);

    // mark_Parent(node, new HashMap<>());
    solution(node,node.left);
  }
  public static void solution(Node node,Node target){
    HashMap<Node,Node> hmap = new HashMap<>();
    mark_Parent(node, hmap);

    Queue<Node> queue = new LinkedList<>();
    HashMap<Node,Boolean> map = new HashMap<>();


    queue.add(node);
    map.put(node,true);

    int count = 0;

    while(!queue.isEmpty()){
      int n = queue.size();
      for(int i = 0;i<n;i++){
        Node temp = queue.poll();
        int changeDone = 0;
        if(temp.left != null && map.get(temp.left) == null){
          queue.add(temp.left);
          map.put(temp.left,true);
          changeDone = 1;
        }

        if(temp.right != null && map.get(temp.right) == null){
          queue.add(temp.right);
          map.put(temp.right,true);
          changeDone = 1;
        }

        if(hmap.get(temp) != null && map.get(hmap.get(temp)) == null){
          queue.add(hmap.get(temp));
          map.put(hmap.get(temp),true);
          changeDone = 1;
        }


        if(changeDone == 1){
          count++;
        }
      }      
    }

    System.out.println(count);

  }
  public static void mark_Parent(Node node, HashMap<Node,Node> hmap){
    Queue<Node> que = new LinkedList<>();
    que.add(node);

    while(!que.isEmpty()){
      Node temp = que.poll();

      if(temp.left != null){
        hmap.put(temp.left,temp);
        que.add(temp.left);
      }
      
      if(temp.right!= null){
        hmap.put(temp.right,temp);
        que.add(temp.right);
      }

    }

  }
}
