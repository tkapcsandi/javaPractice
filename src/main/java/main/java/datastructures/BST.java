package main.java.datastructures;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents a Binary Search Tree
 * <p>
 * In computer science, a binary search tree (BST), also called an ordered or sorted binary tree,
 * is a rooted binary tree whose internal nodes each store a key greater than all the keys in the node's
 * left subtree and less than those in its right subtree. A binary tree is a type of data structure for
 * storing data such as numbers in an organized way. Binary search trees allow binary search for fast lookup,
 * addition and removal of data items, and can be used to implement dynamic sets and lookup tables.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Binary_search_tree">Read more</a>
 * </p>
 * </br>
 * <p>Operations:</p>
 * <ul>
 *     <li>insertion</li>
 *     <li>deletion</li>
 *     <li>lookup</li>
 * </ul>
 */
public class BST {
    private Node root;

    public BST() {
        this.root = null;
    }

    /**
     * Insert a value in the tree
     * <p>
     * A new key is always inserted at the leaf. We start searching a key from the root until we hit a leaf node.
     * Once a leaf node is found, the new node is added as a child of the leaf node.
     * </p>
     *
     * @param value value to be stored in the tree
     */
    public void insert(Integer value) {
        if (root == null) {
            root = new Node(value);
        } else {
            append(root, value);
        }
    }

    /**
     * Append a value to a given node
     * <ul>
     *     <li>If {@code value} equals to the value stored in the {@code Node} "Value is already stored"</li>
     *     <li>If {@code value} less than the value stored in the {@code Node} append to the left.
     *     <li>If {@code value} greater than the value stored in the {@code Node} append to the right.
     * </ul>
     *
     * @param node  node to append
     * @param value value to append
     *
     * @throws IllegalArgumentException if value is already stored
     */
    private void append(Node node, int value) {
        checkIsNodesEquals(node, value);
        if (node.hashCode() > value) {
            appendLeft(node, value);
        } else {
            appendRight(node, value);
        }
    }

    private void checkIsNodesEquals(Node node, int value) {
        if (node.hashCode() == value) {
            throw new IllegalArgumentException("This objects is already stored in the tree");
        }
    }

    private void appendLeft(Node node, int value) {
        if (node.getLeft() == null) {
            node.setLeftChild(new Node(value, node));
        } else {
            append(node.getLeft(), value);
        }
    }

    private void appendRight(Node node, int value) {
        if (node.getRight() == null) {
            node.setRightChild(new Node(value, node));
        } else {
            append(node.getRight(), value);
        }
    }

    /**
     * Travers throughout the tree according to the Node keys
     *
     * @return the {@code Collection} of {@code Nodes} stored in the tree
     */
    public Collection<Node> inOrder() {
        final ArrayList<Node> nodes = new ArrayList<>();
        return getSubtree(root, nodes);
    }

    /**
     * Get the subtree if the given root
     *
     * @param root  root node
     * @param nodes fills up this Collection
     *
     * @return the collection of child nodes of the root
     */
    private ArrayList<Node> getSubtree(final Node root, ArrayList<Node> nodes) {
        if (root != null) {
            getSubtree(root.getLeft(), nodes);
            nodes.add(root);
            getSubtree(root.getRight(), nodes);
        }
        return nodes;
    }

    /**
     * Access tot he tree
     *
     * @return the root of the tree
     */
    public Node getRoot() {
        return root;
    }

    @Override
    public int hashCode() {
        return root.hashCode() * root.getLeft().hashCode() * root.getRight().hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return hashCode() == obj.hashCode();
    }
}
