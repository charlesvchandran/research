


import java.io.*;
import java.util.*;

// The following class has been declared
//class Node {
//    // For the example, all variables are public
//    // no need to use any getter methods.
//    public Node left;
//
//    public Node right;
//
//    public int value;
//
//    public Node(int value) {
//        this.value = value;
//    }
//}


/*

Imagine we have a sorted binary tree as below:
 Initial Tree 
      8 <-- root
     / \
    5   12
   /   /  \
  1   10   18
            \
            25
            
    
      8 <-- root
     / \
    5   12
   /   /  \
  1   10   18
          /  \ 
         13  25
    
    
Please implement the methods below, pseudo code
similar to Java is totally fine. The key is to 
explain over the phone your thinking process.
*/

class SortedBinaryTree {
    public static void main(String[] args) {
        Node node = new Node(8);
        node.left = new Node(5);
        node.left.left = new Node(1);
        node.right = new Node(12);
        node.right.left = new Node(10);
        node.right.right = new Node(18);
        //node.right.right.left = new Node(13);
        node.right.right.right = new Node(25);

        System.out.println("insert :: "+ SortedBinaryTree.insert(node, 17).value);
        Node foundNode = SortedBinaryTree.findNode(node, 17);
        System.out.println("findNode :: "+ foundNode);
        if (foundNode != null) System.out.println("findNode :: "+ foundNode.value);

        System.out.println("depth :: "+ SortedBinaryTree.depth(node));
        System.out.println("deleteNode :: "+ SortedBinaryTree.deleteNode(node, 17).value);
    }

    // 1. Implement the method that return the Node with the
    // specified value, or null if not found
    public static Node findNode(Node rootNode, int value) {

        Node tnode = rootNode;
        while(tnode != null) {
            if (tnode.value < value)  {
                tnode = tnode.right;
            }
            else if (tnode.value > value) tnode = tnode.left;
            else break;
        }
        return tnode;
    }

    // 2. Implement the 'depth' method which will return how 
    // deep the tree is. In the example above, the method
    // should be returning 4
    public static int depth(Node rootNode) {
        if (rootNode == null) return 0;
        else {
            int leftDepth = depth(rootNode.left);
            int rightDepth = depth(rootNode.right);
            if (leftDepth > rightDepth) return leftDepth + 1;
            return rightDepth + 1;
        }
    }


    // 3. Method to add a new node with the value 'value' based on 
    // the 'rootNode' provided. The method should return the Node 
    // inserted 
    // Before implementing please explain where the 
    // new Node with value 13 will be added in the example tree

    //if the value already existing in any node, will insert left side of the node.

    public static Node insert(Node rootNode, int value) {

        if (rootNode == null) return new Node(value);

        if (rootNode.value < value) rootNode.right = insert(rootNode.right, value);

        else if (rootNode.value > value) rootNode.left = insert(rootNode.left, value);

        else return rootNode;

        return findNode(rootNode, value);
    }


    // 4. Implement the 'delete' method which delete
    // the node with the specified value. It will return 
    // the node that was deleted, or null if not found
    public static Node deleteNode(Node rootNode, int value) {
        Node tnode = rootNode;
        Node toDeleteNodePred = null;
        while(tnode != null) {
            if (tnode.value < value)  {
                toDeleteNodePred = tnode;
                tnode = tnode.right;
            }
            else if (tnode.value > value) {
                toDeleteNodePred = tnode;
                tnode = tnode.left;
            }
            else break;
        }
        if (tnode != null) {
            toDeleteNodePred.left = tnode.left;
            toDeleteNodePred.right = tnode.right;
        }
        return tnode;
    }
}