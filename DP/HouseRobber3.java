class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int d){
        this.val=d;
        this.left=null;
        this.right=null;
    }
}

public class HouseRobber3 {

    public static int[] solve(TreeNode root){

        if(root==null){
            return new int[]{0,0};
        }

        int left[]=solve(root.left);
        int right[]=solve(root.right);

        //now rob
        int rob=root.val+left[0]+right[0];

        int skip=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return new int[]{skip,rob};
    }
    public static void main(String args[]){
       
         TreeNode root=new TreeNode(5);

         root.left=new TreeNode(56);
         root.right=new TreeNode(16);
         root.left.left=new TreeNode(89);
         root.left.right=new TreeNode(45);
         root.right.left=new TreeNode(23);
         root.right.right=new TreeNode(34);

         int res[]=solve(root);
         System.out.println(Math.max(res[0],res[1]));

    }
}
