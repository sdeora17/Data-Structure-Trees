public class lecture_01{  
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    
    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.left = new Node(7);
    root.right.right = new Node(8);

    root.left.right.left = new Node(8);
    root.right.right.left = new Node(9);
    root.right.right.right = new Node(10);

    System.out.println();
    int ans = preTraversal(root);
    System.out.println(    );
    System.out.println("Number "+--ans);
    System.out.println();
    ans = postTraversal(root);
    System.out.println();
    System.out.println("Number "+--ans);
    inOrder(root);
  }
  public static int preTraversal(Node node){
    if(node == null){
      return 1;
    }
    int count = 0;
    System.out.print(node.data+"=>");

    count+=preTraversal(node.left);
    count+=preTraversal(node.right);

    return count;
  }

  public static int postTraversal(Node node){
    if(node == null){
      return 1;
    }

    int count = 0;

    count+=postTraversal(node.left);
    count+=postTraversal(node.right);
    System.out.print(node.data+"=>");
    return count;
  }

  public static void inOrder(Node node){
    if(node == null){
      return;
    }

    inOrder(node.left);
    System.out.print(node.data+"=>");
    inOrder(node.right);
  }
}

