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

public class ConstructBinaryTreeFromPreAndIn {
    static Map<Integer,Integer> map=new HashMap<>();
    static int preIndex=0;


    public static Node buildTree(int preOrder[],int inOrder[],int indexSt,int indexEnd){

        if(indexSt>indexEnd){
            return null;
        }

        //find root from preOrder
        int rootValue=preOrder[preIndex++];
        Node root=new Node(rootValue);

        //now pick root index from inOder
        int rootIndex=map.get(rootValue);

        //now move to left and right subtree
        root.left=buildTree(preOrder, inOrder, indexSt, rootIndex-1);
        root.right=buildTree(preOrder, inOrder, rootIndex+1, indexEnd);

        return root;

    }

    public static void preOrder(Node root){

        if(root==null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }


   public static void main(String[] args) {
       int preOrder[]={2,5,4,1,3};
       int inOrder[]={1,4,5,2,3};
       
       //store inorder indices in map
       for(int i=0;i<inOrder.length;i++){
           map.put(inOrder[i],i);
       }

       Node root=buildTree(preOrder,inOrder,0,inOrder.length-1);

       preOrder(root);
   } 
}
