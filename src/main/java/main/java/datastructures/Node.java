package main.java.datastructures;

/**
 * Represents a single node is a three
 *
 * <ul>
 *      <li>{@code key} according to this value is the node is stored in the tree</li>
 *      <li>{@code value} the value that we want to store in the tree</li>
 *      <li>{@code parent} parent element of the node (if {@code null}, then that is a root)</li>
 *      <li>{@code left} left child element of the node</li>
 *      <li>{@code right} right child element of the node</li>
 * </ul>
 */
public class Node {
    private final int key;
    private final Object value;
    private Node parent;
    private Node left;
    private Node right;

    public Node(final Object value) {
        this.value = value;
        this.key = hashCode();
    }

    public Node(final Object value, final Node parent) {
        this.value = value;
        this.parent = parent;
        this.key = hashCode();
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Object getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public int getKey() {
        return key;
    }

    public void setLeftChild(final Node left) {
        this.left = left;
    }

    public void setRightChild(final Node right) {
        this.right = right;
    }

    public void setParent(final Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        String leftStr = this.getLeft() == null ? "null" : String.valueOf(this.getLeft().getKey());
        String rightStr = this.getRight() == null ? "null" : String.valueOf(this.getRight().getKey());

        return "Node{" +
            "key=" + key +
            ", parent=" + parent.getKey() +
            ", left=" + leftStr +
            ", right=" + rightStr +
            '}';
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Node node = (Node) obj;
        return hashCode() == node.hashCode();
    }
}
