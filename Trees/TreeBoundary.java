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

public class TreeBoundary {


     
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Integer> res=new ArrayList<>();
    public static Node createTree(){
         System.out.println("Enter a Node value or -1 for stop:");
         int data=sc.nextInt();

         if(data==-1){
            return null;
         }

         Node root=new Node(data);

         root.left=createTree();
         root.right=createTree();
         return root;


    }

    public static boolean isLeafNode(Node root){
        if(root.left==null && root.right==null){
            return true;
        }

        return false;
    }

    public static void addLeftBoundary(Node root){
        Node curr=root.left;

        while(curr!=null){
          
            if(!isLeafNode(curr)){
                res.add(curr.data);
            }

            if(curr.left!=null){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }

        }
    }

    public static void addRightBoundary(Node root){
        Node curr=root.right;
        Stack<Integer> st=new Stack<>();

        while(curr!=null){
          
            if(!isLeafNode(curr)){
                st.push(curr.data);
            }

            if(curr.right!=null){
                curr=curr.right;
            }
            else{
                curr=curr.left;
            }

        }

        while(!st.isEmpty()){
            res.add(st.pop());
        }
    }

    public static void addLeafNode(Node root){
         if(root==null){
            return;
         }

         if(isLeafNode(root)){
            res.add(root.data);
         }

         addLeafNode(root.left);
         addLeafNode(root.right);
    }


    public static void main(String args[]){
        Node root=createTree();

        if(root==null){
            System.out.println(res);
        }

        if(!isLeafNode(root)){
        res.add(root.data);
        }

        addLeftBoundary(root);
        addLeafNode(root);
        addRightBoundary(root);
        
        System.out.println(res);

    }
}
