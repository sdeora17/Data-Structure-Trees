// Height and Check Balance

public class lecture_05{
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(7);
    
    root.left.left = new Node(3);
    root.left.right = new Node(4);

    root.right.left = new Node(10);
    root.right.right = new Node(12);

    root.left.right.left = new Node(5);
    root.left.right.left = new Node(6);

    // root.left.right.left.left =new Node(10);
    // root.left.right.left.right =new Node(10);
    // root.left.right.left.right.left =new Node(10);


    System.out.println(solution(root));
    System.out.println(checkBalance(root));
  }

  public static boolean checkBalance(Node node){
    Node leftsubtree = node.left;
    Node rightsubtree = node.right;

    int leftHeight = solution(leftsubtree);
    int rightHeight = solution(rightsubtree);

    if(Math.abs(leftHeight - rightHeight) <= 1){
      return true;
    }else{
      return false;
    }
  }


  public static int solution(Node node){
    if(node == null){
      return 0;
    }

    int left = solution(node.left);
    int right = solution(node.right);

    return 1 + Math.max(left,right);
  }
  


  public static int solution_optimal(Node node){
    if(node == null){
      return 0;
    }

    int leftHeight = solution_optimal(node.left);
    if(leftHeight == -1){
      return -1;
    }

    int rightHeight = solution_optimal(node.right);
    if(rightHeight == -1){
      return -1;
    }


    if(Math.abs(leftHeight-rightHeight) > 1) return -1;
    return 1 + Math.max(leftHeight,rightHeight);
  }
}