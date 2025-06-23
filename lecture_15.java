public class lecture_15 {
  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.left.right = new Node(3);
    node.left.left = new Node(4);

    node.right = new Node(2);
    node.right.left = new Node(3);
    node.right.right = new Node(4);

    System.out.println(solution(node));

  }
  public static boolean solution(Node node){
    return node == null || solutionHelper(node.left, node.right);
  }

  public static boolean solutionHelper(Node node1,Node node2){
    if(node1 == null || node2 == null){
      return node1 == node2;
    }
    
    if (node1.data != node2.data)
      return false;

    return solutionHelper(node1.right, node2.left) && solutionHelper(node1.right,node2.left);


  }
}
