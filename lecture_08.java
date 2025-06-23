public class lecture_08{
  public static void main(String args[]){
    Node root1 = new Node(12);
    root1.left = new Node(14);
    root1.right = new Node(15);

    Node root2 = new Node(12);
    root2.left = new Node(14);
    root2.right = new Node(15);

    System.out.println(solution(root1, root2));

  }
  public static boolean solution(Node node1,Node node2){
    if(node1 == null || node2 == null){
      return node1 == node2;
    }
    return (node1.data == node2.data) && solution(node1.left, node2.left) && solution(node1.right,node2.right);
  }
}