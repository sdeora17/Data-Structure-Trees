// Height of the Tree

public class practice_06 {
  public static void main(String args[]){
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(7);
    
    root.left.left = new Node(3);
    root.left.right = new Node(4);

    root.right.left = new Node(10);
    root.right.right = new Node(12);

    // root.left.right.left = new Node(5);
    // root.left.right.right = new Node(6);

    // root.left.right.right.left = new Node(9);
    // root.left.right.right.right = new Node(13);

    
    System.out.println(solution(root));
    System.out.println(checkBalance(root));
    System.out.println(checkHeight(root));
  }
  public static int solution(Node node){
    if(node == null){
      return 0;
    }

    int leftHeight = solution(node.left);
    int rightHeight = solution(node.right);

    return 1 + Math.max(leftHeight,rightHeight);
  }

  public static boolean checkBalance(Node node){
    if(checkHeight(node) == -1){
      return false;
    }
    return true;
  }

  public static int checkHeight(Node node){
    if(node == null){
      return 0;
    }

    Node leftSubtree = node.left;    
    int lheight = checkHeight(leftSubtree);
    if(lheight == -1){
      return -1;
    }
    Node rightSubTree = node.right;
    int rheight = checkHeight(rightSubTree);
    if(rheight == -1){
      return -1;
    }

    if(Math.abs(lheight-rheight)>=1){
      return -1;
    }

    return 1 + Math.max(lheight,rheight);

  }
}
