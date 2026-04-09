class FibNode {
    int key, degree;
    FibNode parent, child, left, right;
    boolean mark;

    public FibNode(int key) {
        this.key = key;
        this.degree = 0;
        this.parent = this.child = null;
        this.left = this.right = this;
        this.mark = false;
    }
}

class FibonacciHeap {
    private FibNode min;
    private int n;

    public FibonacciHeap() {
        min = null;
        n = 0;
    }

    // Insert
    public void insert(int key) {
        FibNode node = new FibNode(key);

        if (min == null) {
            min = node;
        } else {
            // add to root list
            node.left = min;
            node.right = min.right;
            min.right.left = node;
            min.right = node;

            if (node.key < min.key)
                min = node;
        }
        n++;
    }

    // Find Minimum
    public int getMin() {
        if (min == null)
            return -1;
        return min.key;
    }

    // Extract Minimum
    public int extractMin() {
        FibNode z = min;

         if (z == null) return -1;

        if (z != null) {
            // add children to root list
            if (z.child != null) {
                FibNode child = z.child;
                do {
                    FibNode next = child.right;

                    // add child to root list
                    child.left.right = child.right;
                    child.right.left = child.left;

                    child.left = min;
                    child.right = min.right;
                    min.right.left = child;
                    min.right = child;

                    child.parent = null;
                    child = next;
                } while (child != z.child);
            }

            // remove z from root list
            z.left.right = z.right;
            z.right.left = z.left;

            if (z == z.right) {
                min = null;
            } else {
                min = z.right;
                consolidate();
            }

            n--;
        }
        return z.key;
    }

    // Consolidate trees
 private void consolidate() {

    int size = (int) (Math.log(n) / Math.log(2)) + 5;
    FibNode[] degreeTable = new FibNode[size];

    // Step 1: Store all root nodes safely
    java.util.List<FibNode> rootList = new java.util.ArrayList<>();
    FibNode temp = min;

    if (temp != null) {
        do {
            rootList.add(temp);
            temp = temp.right;
        } while (temp != min);
    }

    // Step 2: Process safely
    for (FibNode w : rootList) {
        FibNode x = w;
        int d = x.degree;

        while (degreeTable[d] != null) {
            FibNode y = degreeTable[d];

            if (x.key > y.key) {
                FibNode t = x;
                x = y;
                y = t;
            }

            link(y, x);
            degreeTable[d] = null;
            d++;
        }

        degreeTable[d] = x;
    }

    // Step 3: Rebuild root list
    min = null;

    for (FibNode node : degreeTable) {
        if (node != null) {
            if (min == null) {
                min = node;
                node.left = node.right = node;
            } else {
                node.left = min;
                node.right = min.right;
                min.right.left = node;
                min.right = node;

                if (node.key < min.key)
                    min = node;
            }
        }
    }
}

    // Link trees
    private void link(FibNode y, FibNode x) {
        // remove y from root list
        y.left.right = y.right;
        y.right.left = y.left;

        // make y child of x
        y.parent = x;

        if (x.child == null) {
            x.child = y;
            y.left = y.right = y;
        } else {
            y.left = x.child;
            y.right = x.child.right;
            x.child.right.left = y;
            x.child.right = y;
        }

        x.degree++;
        y.mark = false;
    }
}

public class FibnacciHeap {
    public static void main(String[] args) {

        	FibonacciHeap heap = new FibonacciHeap();
            heap.insert(10);
            heap.insert(3);
            heap.insert(15);
            heap.insert(6);
    
            System.out.println("Minimum: " + heap.getMin()); // Should print 3
            System.out.println("Extracted Minimum: " + heap.extractMin()); // Should print 3
            System.out.println("New Minimum: " + heap.getMin()); // Should print 6
        
    }
}
