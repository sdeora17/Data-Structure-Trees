// Using Iteration Do PostOrder, InOrder, PreOrder  

import java.util.Stack;
import java.util.ArrayList;
public class lecture_03 {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(7);
    
    root.left.left = new Node(3);
    root.left.right = new Node(4);


    root.left.right.left = new Node(5);
    root.left.right.left = new Node(6);

    iterativePostUsingOneStack(root);
  }

  public static void iterativePre(Node node){
    Stack<Node> stackTemp = new Stack<>();
    
    if(node == null){
      return;
    }

    stackTemp.push(node);

    while(!stackTemp.isEmpty()){
      Node temp = stackTemp.pop();
      System.out.println(temp.data);

      if(temp.right != null){
        stackTemp.push(temp.right);
      }

      if(temp.left != null){
        stackTemp.push(temp.left);
      }
    }
  }

  public static void iterativeIn(Node node){
    Stack<Node> stackTemp = new Stack<>();
    ArrayList<Node> answer = new ArrayList<>();


    Node temp = node;

    while(true){
      if(temp!=null){
        stackTemp.push(temp);
        temp = temp.left;
      }else{
        if(stackTemp.isEmpty()){
          break;
        }
        temp = stackTemp.pop();
        answer.add(temp);
        temp = temp.right;
      }
    }

    for(Node temperature:answer){
      System.out.println(temperature.data);
    }
  }
  public static void iterativePost(Node node){
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();

    ArrayList<Node> answer = new ArrayList<>();

    if(node == null){
      return;
    }

    stack1.push(node);
    while(!stack1.isEmpty()){
      Node temp = stack1.pop();
      stack2.add(temp);

      if(temp.left!=null){
        stack1.add(temp.left);
      }

      if(temp.right!=null){
        stack1.add(temp.right);
      }
    }

    while(!stack2.isEmpty()){
      answer.add(stack2.pop());
    }

    for(Node ans:answer){
      System.out.println(ans.data);
    }
  }

  public static void iterativePostUsingOneStack(Node node){
    Stack<Node> stack = new Stack<>();
    ArrayList<Node> answer = new ArrayList<>();

    Node current = node;

    while(current!=null || !stack.isEmpty()){
      if(current!=null){
        stack.push(current);
        current = current.left;
      }else{
        Node temp = stack.peek().right;
        if(temp == null){
          temp = stack.pop();
          answer.add(temp);
          while(!stack.isEmpty() && stack.peek().right == temp){
            temp = stack.pop();
            answer.add(temp);
          }
        }else{
          current = temp;
        }
      }
    }

    for(Node nod:answer){
      System.out.print(nod.data+" ");
    }
  }
}
