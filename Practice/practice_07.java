public class practice_07 {
  public static void main(String[] args) {
    Node node = new Node(12); 
    node.left = new Node(-10);
    node.right = new Node(15);
    
    node.left.left = new Node(7);
    node.left.left = new Node(9);

    node.right.left = new Node(13);
    node.right.right = new Node(19);



    System.out.println(starter(node));
  }
  public static int starter(Node node){
    int max[] = {0};
    solution(node,max);

    return max[0];
  }


  public static int solution(Node node,int max[]){
    if(node == null){
      return 0;
    }

    int leftSum = Math.max(0,solution(node.left,max));
    int rightSum = Math.max(0,solution(node.right,max));

    max[0] = Math.max(max[0],node.data+leftSum+rightSum);

    return Math.max(leftSum,rightSum) + node.data;

  }
}
