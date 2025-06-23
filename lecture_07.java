// Maximum Path Sum

public class lecture_07 {
  public static void main(String args[]){
    Node root = new Node(-10);
    root.left = new Node(9);
    root.right = new Node(20);
    root.right.left = new Node(15);
    root.right.right = new Node(7);
    System.out.println(solution(root));


  }

  public static int solution(Node node){
    int maxi[] = {Integer.MIN_VALUE};
    helper(node,maxi);
    return maxi[0];
    
  }

  public static int helper(Node node,int max[]){
    if(node == null){
      return 0;
    }

    int leftSum = Math.max(0,helper(node.left,max));
    int rightSum = Math.max(0,helper(node.right,max));
    max[0] = Math.max(max[0],node.data+leftSum+rightSum);
    return Math.max(leftSum,rightSum) + node.data;
  }
  
  

}
