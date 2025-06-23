// Diameter of the tree

// Longest Path between 2 nodes
// path does not need to pass via the root

import java.util.Arrays;

public class lecture_06 {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    
    root.right.left = new Node(4);
    root.right.right = new Node(6);

    root.right.left.left = new Node(5);
    root.right.left.left.left = new Node(9);

    root.right.right.right = new Node(7);
    root.right.right.right.right = new Node(8);

    System.out.println(solution(root, 0));
    // int diameter[] = {0};

   System.out.println( Arrays.toString(diameter(root)));
  }  
  public static int solution(Node node,int max){
    if(node == null){
      return 0;
    }

    int leftHeight = findHeight(node.left);
    int rightHeight = findHeight(node.right);
    max = Math.max(max,leftHeight+rightHeight+1);
    solution(node.left,max);
    solution(node.right,max);
    return max;
  }
  public static int findHeight(Node node){
    if(node == null){
      return 0;
    }

    int lh = findHeight(node.left);
    int rh = findHeight(node.right);

    return 1 + Math.max(lh,rh);
  }

  public static int[] diameter(Node node){
    int diameter[] = new int[1];
    diameter[0] = 0;
    optimal(node, diameter);
    return diameter;
  }


  public static int optimal(Node node,int max[]){
    if(node == null){
      return 0;
    }

    int leftH = optimal(node.left, max);
    int rightH = optimal(node.right, max);
    max[0] = Math.max(max[0],leftH+rightH);
    return 1 + Math.max(leftH, rightH);
  }
}
