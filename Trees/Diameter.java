import java.util.*;

class Node{
    int data;
    Node right,left;

    Node(int data){
        this.data=data;
        right=left=null;
    }
}

class Diameter{
    static Scanner sc=new Scanner(System.in);
    static int diameter=0;
    public static Node CreateTree(){
        
        System.out.println("Enter a number or -1(for stop):");
        int data=sc.nextInt();

        if(data==-1){
            return null;
        }

        Node root=new Node(data);

        root.left=CreateTree();
        root.right=CreateTree();

        return root;
    }

    public static int height(Node root){

        if(root==null){
            return -1;
        }

        int left=height(root.left);
        int right=height(root.right);

        //update diameter check at each node
        diameter=Math.max(diameter,left+right+2);

        return Math.max(left,right)+1;
    }
public static void main(String args[]){

    Node root=CreateTree();
    
    //height of that tree
    height(root);
    System.out.println("Diameter of Tree: "+diameter);
      
}
}