import java.util.ArrayList;

public class practice_18 {
  public static void main(String[] args) {
    Node node = new Node(5);
    node.left = new Node(2);
    node.right = new Node(7);
    node.left.left = new Node(1);
    node.left.right = new Node(4);
    node.right.left = new Node(6);
    node.right.right = new Node(8);

    solution(node, 1, 8);
    
  }
  public static void solution(Node node,int level1,int level2){
    ArrayList<Integer> route_01 = new ArrayList<>();
    ArrayList<Integer> route_02 = new ArrayList<>();


    route(node,level1,route_01);
    route(node,level2,route_02);



    int answer =0;
    int i = 0;
    int j = 0;
    while(i<route_01.size() && j<route_02.size()){
      if(route_01.get(i) == route_02.get(j)){
        answer = route_01.get(i);  
        i++;
        j++;
      }else{
        break;
      }

    }
    System.out.println(answer);


  }


  public static boolean route(Node node,int level,ArrayList<Integer> answer){
    if(node == null){
      return false;
    }

    answer.add(node.data);

    if(node.data == level){
      return true;
    }

    if(route(node.left,level,answer) || route(node.right,level,answer)){
      return true;
    }
    

    answer.remove(answer.size()-1);
    return false;
  }
}
