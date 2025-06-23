import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class lecture_22{
  public static void main(String[] args) {
    Node node = new Node(10);
    node.left = new Node(4);
    node.right = new Node(12);
    node.left.left = new Node(2);
    node.left.right = new Node(6);
    node.right.right = new Node(15);
    node.right.left = new Node(11);

    ArrayList<Node> preOrder = new ArrayList<>();
    ArrayList<Node> inOrder = new ArrayList<>();

    preOrder(node,preOrder);
    inOrder(node,inOrder);

    Node answer = solution(preOrder, inOrder);
    bfs(answer);
  }
  public static void bfs(Node node){
    Queue<Node> que = new LinkedList<>();
    que.add(node);
    ArrayList<ArrayList<Node>> answer = new ArrayList<>();
    
    while(!que.isEmpty()){
      int n = que.size();
      ArrayList<Node> shortAnswer = new ArrayList<>();
      for(int i = 0;i<n;i++){
        Node temp = que.poll();
        if(temp.left != null){
          que.add(temp.left);
        }

        if(temp.right != null){
          que.add(temp.right);
        }

        shortAnswer.add(temp);
      }
      answer.add(shortAnswer);
    }

    for(ArrayList<Node> temp: answer){
      for(Node tmp: temp){
        System.out.print(tmp.data+" ");
      }
      System.out.println();
    }
  }

  public static Node solution(int preOrder[],int inOrder[]){
    HashMap<Integer,Integer> inOrderMap = new HashMap<>();
    
    for(int i = 0;i<inOrder.length;i++){
      inOrderMap.put(inOrder[i],i);
    }  
  
    return recursion(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1, inOrderMap);
  }

  public static Node recursion(int preOrder[],int preStart,int preEnd,
                              int inOrder[],int inStart,int inEnd,
                              HashMap<Integer,Integer> mapp){
    if(preStart>preEnd || inStart>inEnd){
      return null;
    }
    int element = preOrder[preStart];
    Node start = new Node(element);
    int InorderPlace = mapp.get(element);

    int leftSideElements = InorderPlace - inStart;

    start.left = recursion(preOrder, preStart+1, preStart+leftSideElements, inOrder, inStart, InorderPlace-1, mapp);
    start.right = recursion(preOrder, preStart+leftSideElements+1, preEnd, inOrder, InorderPlace+1, inEnd, mapp);

    return start;

  }

  public static Node solution(ArrayList<Node> preOrder, ArrayList<Node> inOrder){
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i = 0;i<inOrder.size();i++){
      map.put(inOrder.get(i).data,i);
    }
    return recursion_algo(preOrder, 0, preOrder.size()-1, inOrder, 0, inOrder.size()-1, map);
  }

  public static Node recursion_algo(ArrayList<Node> preOrder,int preStart,int preEnd, ArrayList<Node> inOrder, int inOrderStart,int inOrderEnd,HashMap<Integer,Integer> map){    
    if(preStart>preEnd || inOrderStart>inOrderEnd){
      return null;
    }
    
    Node start = preOrder.get(preStart);
    int inOrderPlace = map.get(start.data);
    int leftElements = inOrderPlace - inOrderStart;
    
    start.left = recursion_algo(preOrder, preStart+1, preStart+leftElements, inOrder, inOrderStart, inOrderPlace-1, map);
    start.right = recursion_algo(preOrder,preStart+leftElements+1,preEnd,inOrder,inOrderPlace+1,inOrderEnd,map);

    return start;
  }


  public static void preOrder(Node node,ArrayList<Node> preOrder){
    if(node == null){
      return;
    }

    preOrder.add(node);
    preOrder(node.left,preOrder);
    preOrder(node.right,preOrder);


  }
  public static void inOrder(Node node,ArrayList<Node> inOrder){
    if(node == null){
      return;
    }
    
    inOrder(node.left,inOrder);
    inOrder.add(node);
    inOrder(node.right,inOrder);
  }

}