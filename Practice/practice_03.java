import java.util.ArrayList;
import java.util.Stack;

public class practice_03 {
  public static void main(String[] args) {
    Node node = new Node(14);
    node.left = new Node(12);
    node.right = new Node(18);

    node.left.left = new Node(10);
    node.left.right = new Node(13);

    node.right.left = new Node(17);
    node.right.right = new Node(22);
    
    iterativePostTwoStack(node);
  }
  public static void iterativePrePractice(Node node){
    Stack<Node> tempStack = new Stack<>();
    ArrayList<Node> Answers = new ArrayList<>();
    tempStack.push(node);

    while(!tempStack.isEmpty()){
      Node temp = tempStack.pop();

      if(temp.right!=null){
        tempStack.push(temp.right);
      }

      if(temp.left != null){
        tempStack.push(temp.left);
      }

      Answers.add(temp);
    }
    System.out.print("[");
    for(Node nod:Answers){
      System.out.print(nod.data+" ");
    }
    System.out.print("]");
    System.out.println();
  }

  public static void itertaiveInPractice(Node node){
    Stack<Node> tempStack = new Stack<>();
    ArrayList<Node> Answer = new ArrayList<>();


    while(true){
      if(node!=null){
        tempStack.push(node);
        node = node.left;

      }else{
        if(tempStack.isEmpty()){
          break;
        }
        Node temp = tempStack.pop();
        Answer.add(temp);
        node = temp.right;
      }
    }

    for(Node ans:Answer){
      System.out.println(ans.data);
    }

  }

  public static void iterativePostTwoStack(Node node){
    Stack<Node> s1 = new Stack<>();
    Stack<Node> s2 = new Stack<>();
    ArrayList<Node> answer = new ArrayList<>();
  

    s1.push(node);
  
    while(!s1.isEmpty()){
      Node temp = s1.pop();
      s2.push(temp);
      
      System.out.println(temp.data);
      if(temp.left!=null){
        System.out.print(temp.left.data+" ");
        s1.push(temp.left);
      }

      if(temp.right!=null){
        System.out.print(temp.right.data+" ");
        s1.push(temp.right);
      }
      System.out.println();
    }

    while(!s2.isEmpty()){
      answer.add(s2.pop());
    }
    System.out.println();
    for(Node tem:answer){
      System.out.print(tem.data+" ");
    }

  }



}
