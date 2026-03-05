import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int data;
    Node left,right;

    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public class View {
    static Scanner sc=new Scanner(System.in);
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

    public static  ArrayList leftView(Node root){

         ArrayList<Integer> res=new ArrayList<>();
         if(root==null){
            return res;
         }

         Queue<Node> q=new LinkedList<>();
         q.add(root);

         while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                Node curr=q.poll();

                if( i==0){
                    res.add(curr.data);
                }

                if(curr.left!=null){
                    q.add(curr.left);
                }

                if(curr.right!=null){
                    q.add(curr.right);
                }
            }

         }

         return res;
    }


     public static  ArrayList RightView(Node root){

         ArrayList<Integer> res=new ArrayList<>();
         if(root==null){
            return res;
         }

         Queue<Node> q=new LinkedList<>();
         q.add(root);

         while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                Node curr=q.poll();

                if( i==0){
                    res.add(curr.data);
                }

                if(curr.right!=null){
                    q.add(curr.right);
                }

                if(curr.left!=null){
                    q.add(curr.left);
                }
            }

         }

         return res;
    }

    
    public static void main(String[] args) {
        Node root=createTree();
        System.out.println("Tree Created Successfully!");
        
        //left view
        ArrayList<Integer> resLeft=leftView(root);
        System.out.println("Left View: "+resLeft);

        //right view
        ArrayList<Integer> resRight=RightView(root);
        System.out.println("Right View: "+resRight);

    }
}
