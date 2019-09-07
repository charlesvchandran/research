public class BinaryTree {

    Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) return false;
        if (value == current.value) return true;
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public static Node minimumElement(Node root) {
        if (root.left == null) return root;
        else return minimumElement(root.left);
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.value + " ");
        inOrder(root.right);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {

        }

        if (root.value > value) {
            root.left = deleteRecursive(root.left, value);
        } else if (root.value < value) {
            root.right = deleteRecursive(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                Node temp = root;
                Node minNodeForRight = minimumElement(temp.right);
                root.value = minNodeForRight.value;
                deleteRecursive(root.right, minNodeForRight.value);
            } else if (root.left !=null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    /*@Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
        BinaryTree bt = createBinaryTree();

        assertTrue(bt.containsNode(6));
        assertTrue(bt.containsNode(4));

        assertFalse(bt.containsNode(1));
    }*/
}
