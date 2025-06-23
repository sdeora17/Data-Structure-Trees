public class practice_08 {
  public static void main(String[] args) {
    Node node1 = new Node(12);
    node1.left = new Node(10);
    node1.right = new Node(15);


    Node node2 = new Node(12);
    node2.left = new Node(10);
    node2.right = new Node(15);

    System.out.println(solution(node1, node2));
  }
  public static boolean solution(Node node1,Node node2){
    if(node1 == null || node2 == null){
      return node1 == node2;
    }

    return node1.data == node2.data && solution(node1.left,node1.left) && solution(node2.right, node2.right);
  }
}
