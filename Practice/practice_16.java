// Check if tree is symmetric

public class practice_16 {
  public static void main(String[] args) {
    Node tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(2);

    tree.left.right = new Node(3);
    tree.left.left = new Node(4); 

    tree.right.left = new Node(3);
    tree.right.right = new Node(4);
    System.out.println(solution(tree));
    
  }
  public static boolean solution(Node node){
    return node == null || isSymmetric(node.left, node.right);
  }

  public static boolean isSymmetric(Node tree1,Node tree2){
    if(tree1 == null || tree2 == null){
      return tree1 == tree2;
    }

    if(tree1.data != tree2.data){
      return false;
    }

    return isSymmetric(tree1.left, tree2.right) && isSymmetric(tree1.right, tree2.left);

  }
}
