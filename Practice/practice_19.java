import java.util.Queue;
import java.util.LinkedList;

public class practice_19{
  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.left.left = new Node(3);
    node.right = new Node(4);
    node.right.right = new Node(5);
    solution(node);    
  }
  public static void solution(Node node){
    Queue<Tuple> object = new LinkedList<>();
    object.add(new Tuple(0,node));
    int answer = 0;

    while(!object.isEmpty()){
      int left = 0;
      int right = 0;
      int size = object.size();
      int nMin = object.peek().level;

      for(int i = 0;i<size;i++){
        Tuple item = object.peek();
        int level = item.level - nMin;
        Node temp = item.node;

        object.poll();

        if(i == 0){
          left = level; 
        }

        if(i == size-1){
          right = level;
        } 

        if(temp.left!= null){
           object.add(new Tuple(level*2+1, temp.left));
        }

        if(temp.right != null){
          object.add(new Tuple(level*2+2, temp.right));
        }
      }
      answer = Math.max(answer,right-left+1);
    }
    System.out.println(answer);
  }
}

class Tuple{
  int level;
  Node node;

  Tuple(int level, Node node){
    this.level = level;
    this.node = node;
  }
}