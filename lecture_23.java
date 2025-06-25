import java.util.ArrayList;
import java.util.HashMap;

public class lecture_23{
  public static void main(String[] args) {
    Node node = new Node(12);
    node.left = new Node(4);
    node.right = new Node(14);
    node.left.left = new Node(2);
    node.left.right = new Node(6);
    node.right.left = new Node(13);
    node.right.right = new Node(15);
    ArrayList<Integer> postOrder = new ArrayList<>();
    ArrayList<Integer> inOrder = new ArrayList<>();
    
    pOrder(postOrder, node);
    iOrder(inOrder, node);
    System.out.println(postOrder.toString());
    System.out.println(inOrder.toString());

    Node answer = solution(postOrder, inOrder);
    ArrayList<Integer> ansPostOrder = new ArrayList<>();
    ArrayList<Integer> ansInOrder = new ArrayList<>();
    
    pOrder(ansPostOrder,node);
    iOrder(ansInOrder, node);


    System.out.println(ansPostOrder.toString());
    System.out.println(ansInOrder.toString());
  }
  public static Node solution(ArrayList<Integer> postOrder,ArrayList<Integer> inOrder){
    HashMap<Integer,Integer> hmap = new HashMap<>();
    for(int i = 0;i<inOrder.size();i++){
      hmap.put(inOrder.get(i),i);
    }

    return recursion(postOrder, 0, postOrder.size()-1, inOrder, 0, inOrder.size()-1, hmap);
    
  }


  public static Node recursion(ArrayList<Integer> postOrder,int postStart,int postEnd,ArrayList<Integer> inOrder,int inStart,int inEnd,HashMap<Integer,Integer> hmap){
    if(postStart>postEnd || inStart>inEnd){
      return null;
    }

    Node node = new Node(postOrder.get(postEnd));
    int element = postOrder.get(postEnd);
    int inOrderPosition = hmap.get(element);
    int rightElements = inEnd-inOrderPosition;

    node.left = recursion(postOrder,postStart,postEnd-1-rightElements,inOrder,inStart,inOrderPosition-1,hmap);
    node.right = recursion(postOrder,postStart+rightElements,postEnd-1,inOrder,inOrderPosition+1,inEnd,hmap);

    return node;
  }

  public static void pOrder(ArrayList<Integer> postOrder, Node node){
    if(node == null){
      return;
    }


    pOrder(postOrder, node.left);
    pOrder(postOrder, node.right);
    postOrder.add(node.data);
  }
  public static void iOrder(ArrayList<Integer> inOrder,Node node){
    if(node == null)
      return;

    iOrder(inOrder, node.left);
    inOrder.add(node.data);
    iOrder(inOrder, node.right);
  }
}