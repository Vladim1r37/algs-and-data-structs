package Lesson6;

import java.util.Stack;

public class TreeImpl implements Tree {

    private Node root;

    private int size;

    public TreeImpl() {
        this.size = 0;
    }

    @Override
    public void add(int value) {
        Node node = new NodeImpl(value);
        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            current = current.getChildByKey(value);
        }

        if (parent.isLeftChild(value)) {
            parent.setLeftChild(node);
        }
        else {
            parent.setRightChild(node);
        }
        size++;
    }


    @Override
    public int remove(int value) {
        NodeAndParent nodeAndParent = getNodeAndParentByKey(value);

        Node current = nodeAndParent.current;
        Node parent = nodeAndParent.parent;

        if (current == null) {
            return 0;
        }

        if (current.isLeaf()) {
            removeLeafNode(value, parent);
        }

        else if (current.getLeftChild() == null || current.getRightChild() == null) {
            removeNodeWithSingleChild(current, parent);
        }
        else {
            removeNodeWithBothChildren(value, current, parent);
        }

        size--;

        return current.getData();
    }

    private void removeNodeWithBothChildren(int value, Node current, Node parent) {
        Node successor = getSuccessor(current);
        if (current == root) {
            root = successor;
        }
        else if ( parent.isLeftChild(value) ) {
            parent.setLeftChild(successor);
        }
        else {
            parent.setRightChild(successor);
        }

        successor.setLeftChild(current.getLeftChild());
    }

    private Node getSuccessor(Node node) {
        Node successor = node;
        Node successorParent = node;
        Node current = node.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != node.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }

        return successor;
    }

    private void removeNodeWithSingleChild(Node current, Node parent) {
        Node childNode = current.getLeftChild() != null ? current.getLeftChild() : current.getRightChild();
        if ( parent.isLeftChild(current.getKey()) ) {
            parent.setLeftChild(childNode);
        }
        else {
            parent.setRightChild(childNode);
        }
    }

    private void removeLeafNode(int value, Node parent) {
        if (parent == null) {
            root = null;
        }
        else if (parent.isLeftChild(value)) {
            parent.setLeftChild(null);
        }
        else {
            parent.setRightChild(null);
        }
    }

    private NodeAndParent getNodeAndParentByKey(int value) {
        Node current = root;
        Node parent = null;

        while (current != null) {
            if (current.getKey() == value) {
                break;
            }

            parent = current;
            current = current.getChildByKey(value);
        }

        return new NodeAndParent(parent, current);
    }

    @Override
    public Integer find(int value) {
        Node current = root;

        while (current != null) {
            if (current.getKey() == value) {
                return current.getData();
            }

            current = current.getChildByKey(value);
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getKey());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();
            nBlanks /= 2;

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }


        }
        System.out.println("................................................................");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
            default:
                throw new IllegalArgumentException("Invalid traverse mode = " + mode);
        }
    }

    private class NodeAndParent {
        Node parent;
        Node current;

        public NodeAndParent(Node parent, Node current) {
            this.parent = parent;
            this.current = current;
        }
    }

    private void postOrder(Node root) {
        if (root != null) {
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
            root.display();
        }
    }

    private void preOrder(Node root) {
        if (root != null) {
            root.display();
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            root.display();
            inOrder(root.getRightChild());
        }
    }

    public Node getRoot() {
        return root;
    }
}
