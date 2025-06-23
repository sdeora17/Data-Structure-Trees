import java.util.ArrayList;

public class lecture_17 {
  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(3);
    node.left.left = new Node(4);
    node.left.right = new Node(5);
    node.left.right.left = new Node(6);
    node.left.right.right = new Node(7);
    node.right.left = new Node(8);
    node.right.right = new Node(9);

    System.out.println(solution(node, 2, 6));

    Node answer = solution_optimal(node, 4, 7);
    System.out.println(answer.data);

  }
  public static int solution(Node node,int num1,int num2){

    ArrayList<Integer> route_01 = new ArrayList<>();
    ArrayList<Integer> route_02 = new ArrayList<>();


    solution_helper(node, num1, route_01);
    solution_helper(node, num2, route_02);

    int i = 0;
    int j = 0;
    int answer = -1;

    while(i<route_01.size() && j<route_02.size()){
      if(route_01.get(i) == route_02.get(j)){
        answer = route_01.get(i);
        i++;
        j++;
      }else{
            break;
          }
    }


    return answer;
  }
  public static boolean solution_helper(Node node,int num1,ArrayList<Integer> answer){
    if(node == null){
      return false;
    }

    answer.add(node.data);

    if(solution_helper(node.left, num1, answer) || solution_helper(node.right, num1, answer)){
      return true;
    }

    if(node.data == num1){
      return true;
    }


    answer.remove(answer.size()-1);


    return false;
  }

  public static Node solution_optimal(Node node,int num1,int num2){
    if(node == null || node.data == num1 || node.data == num2){
      return node;
    }

    Node left = solution_optimal(node.left, num1, num2);
    Node right = solution_optimal(node.right, num1, num2);
    
    if(left == null){
      return right;
    }else if(right == null){
      return left;
    }else{
      return node;
    }
  }

}
