class RBNode {
    int data;
    RBNode left, right, parent;
    boolean isRed;

    RBNode(int data) {
        this.data = data;
        this.isRed = true; // New nodes are red by default
        left = right = parent = null;
    }
}

class DeletionInRedBlackTree {
    private final RBNode NIL;
    private RBNode root;

    public DeletionInRedBlackTree() {
        NIL = new RBNode(-1);
        NIL.isRed = false; // NIL nodes are black
        root = NIL;
    }

    // Helper: Left Rotate
    private void leftRotate(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != NIL) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    // Helper: Right Rotate
    private void rightRotate(RBNode y) {
        RBNode x = y.left;
        y.left = x.right;
        if (x.right != NIL) x.right.parent = y;
        x.parent = y.parent;
        if (y.parent == null) root = x;
        else if (y == y.parent.left) y.parent.left = x;
        else y.parent.right = x;
        x.right = y;
        y.parent = x;
    }

    // Find the node with minimum value
    private RBNode minimum(RBNode node) {
        while (node.left != NIL) node = node.left;
        return node;
    }

    // Transplant subtree u with v
    private void transplant(RBNode u, RBNode v) {
        if (u.parent == null) root = v;
        else if (u == u.parent.left) u.parent.left = v;
        else u.parent.right = v;
        v.parent = u.parent;
    }

    // Delete a node
    public void delete(int key) {
        RBNode z = search(root, key);
        if (z == NIL) return; // Node not found

        RBNode y = z;
        RBNode x;
        boolean yOriginalColor = y.isRed;

        if (z.left == NIL) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == NIL) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.isRed;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.isRed = z.isRed;
        }

        if (!yOriginalColor) fixDelete(x);
    }

    // Fix Red-Black properties after deletion
    private void fixDelete(RBNode x) {
        while (x != root && !x.isRed) {
            if (x == x.parent.left) {
                RBNode w = x.parent.right;
                if (w.isRed) {
                    w.isRed = false;
                    x.parent.isRed = true;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }
                if (!w.left.isRed && !w.right.isRed) {
                    w.isRed = true;
                    x = x.parent;
                } else {
                    if (!w.right.isRed) {
                        w.left.isRed = false;
                        w.isRed = true;
                        rightRotate(w);
                        w = x.parent.right;
                    }
                    w.isRed = x.parent.isRed;
                    x.parent.isRed = false;
                    w.right.isRed = false;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                RBNode w = x.parent.left;
                if (w.isRed) {
                    w.isRed = false;
                    x.parent.isRed = true;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if (!w.left.isRed && !w.right.isRed) {
                    w.isRed = true;
                    x = x.parent;
                } else {
                    if (!w.left.isRed) {
                        w.right.isRed = false;
                        w.isRed = true;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.isRed = x.parent.isRed;
                    x.parent.isRed = false;
                    w.left.isRed = false;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.isRed = false;
    }

    // Search a node by key
    private RBNode search(RBNode node, int key) {
        while (node != NIL && key != node.data) {
            if (key < node.data) node = node.left;
            else node = node.right;
        }
        return node;
    }

    // Inorder Traversal
    public void inorder() {
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(RBNode node) {
        if (node != NIL) {
            inorderHelper(node.left);
            System.out.print(node.data + " ");
            inorderHelper(node.right);
        }
    }

    // Insert (needed to test deletion)
    public void insert(int key) {
        RBNode node = new RBNode(key);
        node.left = node.right = NIL;

        RBNode y = null;
        RBNode x = root;

        while (x != NIL) {
            y = x;
            if (node.data < x.data) x = x.left;
            else x = x.right;
        }

        node.parent = y;
        if (y == null) root = node;
        else if (node.data < y.data) y.left = node;
        else y.right = node;

        node.isRed = true;
        fixInsert(node);
    }

    private void fixInsert(RBNode k) {
        RBNode u;
        while (k.parent != null && k.parent.isRed) {
            if (k.parent == k.parent.parent.left) {
                u = k.parent.parent.right;
                if (u != null && u.isRed) {
                    k.parent.isRed = false;
                    u.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    rightRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.left;
                if (u != null && u.isRed) {
                    k.parent.isRed = false;
                    u.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    leftRotate(k.parent.parent);
                }
            }
        }
        root.isRed = false;
    }

    public static void main(String[] args) {
        DeletionInRedBlackTree tree = new DeletionInRedBlackTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);
        tree.inorder(); // 10 15 20 25 30

        tree.delete(20);
        tree.inorder(); // 10 15 25 30
    }
}
