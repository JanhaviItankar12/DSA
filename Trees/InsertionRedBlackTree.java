class RBNode{
    int data;
    RBNode left,right,parent;
    boolean isRed;
    RBNode(int data){
        this.data=data;
        this.isRed=true;    //new node is always true
        left=right=parent=null;
    }
}
class RedBlackTree{
    private RBNode root;
    private final RBNode NIL;
    public RedBlackTree(){
        NIL=new RBNode(-1);
        NIL.isRed=false;
        NIL.left = NIL.right = NIL.parent = NIL; 
        root=NIL;
    }
    public void insert(int key){
        RBNode node=new RBNode(key);
        node.left=node.right=NIL;
        RBNode parent=null;
        RBNode current=root;
        while(current!=NIL){
            parent=current;
            if(key<current.data){
                current=current.left;
            }
            else{
                current=current.right;
            }
        }
        node.parent=parent;
        if(parent==null){
            root=node;
            node.parent = NIL; 
        }
        else if(key<parent.data){
            parent.left=node;
        }
        else{
            parent.right=node;
        }
        fixInsert(node);
    }
    private void fixInsert(RBNode node) {
    while(node != root && node.parent.isRed){
        RBNode grand = node.parent.parent;
        if(node.parent == grand.left){
            RBNode uncle = grand.right;
            if(uncle.isRed){
                // Case 1
                node.parent.isRed = false;
                uncle.isRed = false;
                grand.isRed = true;
                node = grand;
            } else {
                if(node == node.parent.right){
                    node = node.parent;
                    leftRotate(node); // Case 2
                }
                node.parent.isRed = false;
                grand.isRed = true;
                rightRotate(grand); // Case 3
            }
        } else {
            RBNode uncle = grand.left;
            if(uncle.isRed){
                // Case 1 mirror
                node.parent.isRed = false;
                uncle.isRed = false;
                grand.isRed = true;
                node = grand;
            } else {
                if(node == node.parent.left){
                    node = node.parent;
                    rightRotate(node); // Case 2 mirror
                }
                node.parent.isRed = false;
                grand.isRed = true;
                leftRotate(grand); // Case 3 mirror
            }
        }
    }
    root.isRed = false;
}
    private void leftRotate(RBNode x) {
    RBNode y = x.right;
    x.right = y.left;
    if (y.left != NIL) y.left.parent = x;
    y.parent = x.parent;
    if (x.parent == NIL) {   
        root = y;
    } else if (x == x.parent.left) {
        x.parent.left = y;
    } else {
        x.parent.right = y;
    }
    y.left = x;
    x.parent = y;
}

private void rightRotate(RBNode y) {
    RBNode x = y.left;
    y.left = x.right;
    if (x.right != NIL) x.right.parent = y;
    x.parent = y.parent;
    if (y.parent == NIL) {   
        root = x;
    } else if (y == y.parent.left) {
        y.parent.left = x;
    } else {
        y.parent.right = x;
    }
    x.right = y;
    y.parent = x;
}
    // Inorder traversal
    public void inorder(RBNode node) {
        if (node != NIL) {
            inorder(node.left);
            System.out.print(node.data + (node.isRed ? "(R) " : "(B) "));
            inorder(node.right);
        }
    }
    public void display() {
        inorder(root);
        System.out.println();
    }
}
public class InsertionRedBlackTree {
     public static void main(String[] args) {
         DeletionInRedBlackTree tree=new DeletionInRedBlackTree();
         int values[]={10,20,30,50,49,90,35};
         for(int v:values){
            tree.insert(v);
            System.out.println("InOrder traversal of Red-Black Tree:");
            tree.display();
         }
     }
}
