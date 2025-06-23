import java.util.ArrayList;
import java.util.HashMap;

public class practice_23 {
  public static void main(String[] args) {
    Node node = new Node(10);
    node.left = new Node(6);
    node.right = new Node(15);
    node.left.left = new Node(5);
    node.left.right = new Node(8);
    node.right.left = new Node(11);
    node.right.right = new Node(18);
    ArrayList<Integer> inOrder = new ArrayList<>();
    ArrayList<Integer> preOrder = new ArrayList<>();

    inOrder(inOrder, node);
    postOrder(preOrder, node);

    solution(preOrder,inOrder);
  }
  public static void solution(ArrayList<Integer> preOrder,ArrayList<Integer> inOrder){
    HashMap<Integer,Integer> hmap = new HashMap<>();
    for(int i = 0;i<inOrder.size();i++){
      hmap.put(inOrder.get(i),i);
    }

    recursive(preOrder,0,preOrder.size()-1,inOrder,0,inOrder.size()-1,hmap);

  }

  public static Node recursive(ArrayList<Integer> preOrder,int preStart,int preEnd,ArrayList<Integer> inOrder, int inStart,int inEnd, HashMap<Integer,Integer> hmap){
    int element = preOrder.get(preStart);
    Node node  = new Node(element);
    int inOrderPosition = inOrder.get(element);
    int leftElements = inOrderPosition - inStart;

    node.left = recursive(preOrder,preStart+1,preStart + leftElements,inOrder,inStart,inOrderPosition-1,hmap);
    node.right = recursive(preOrder,preStart + leftElements + 1,preEnd,inOrder,inOrderPosition+1,inEnd,hmap);
    
    return node;
  }

  public static void inOrder(ArrayList<Integer> inOrder,Node node){
    if(node == null){
      return;
    }

    inOrder(inOrder,node.left);
    inOrder.add(node.data);
    inOrder(inOrder,node.right);
  }
  public static void postOrder(ArrayList<Integer> postOrder,Node node){
    if(node == null){
      return;
    }

    postOrder.add(node.data);
    postOrder(postOrder, node.left);
    postOrder(postOrder, node.right);
  }
}
