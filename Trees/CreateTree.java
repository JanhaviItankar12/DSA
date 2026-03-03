
import java.util.*;

class Node{
    int data;
    Node left,right;

    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class CreateTree {
    static Scanner sc=new Scanner(System.in);
    public static Node createTree(){
        
        
        System.out.println("Enter a Number:");
        int data=sc.nextInt();
        
        if(data==-1){
            return null;
        }

        Node root=new Node(data);

        root.left=createTree();
        root.right=createTree();

        return root;

    }

    public static void preOrder(Node root) {
        
        if(root==null){
            return;
        }
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
        
    }

      public static void main(String[] args) {
          Node root=createTree();
          System.out.println("Tree Created Successfully!");

          //traversal-preorder
          preOrder(root);
      }
}
