package Lesson6;

public class NodeImpl implements Node {

    private int value;

    private Node leftChild;
    private Node rightChild;

    public NodeImpl(int value) {
        this.value = value;
    }

    @Override
    public void setData(int value) {
        this.value = value;
    }

    @Override
    public int getData() {
        return value;
    }

    @Override
    public int getKey() {
        return value;
    }

    @Override
    public Node getLeftChild() {
        return leftChild;
    }

    @Override
    public Node getRightChild() {
        return rightChild;
    }

    @Override
    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public Node getChildByKey(int key) {
        if ( isLeftChild(key) ) {
            return getLeftChild();
        }
        else {
            return getRightChild();
        }
    }

    @Override
    public boolean isLeftChild(int key) {
        return key < getKey();
    }

    @Override
    public boolean isLeaf() {
        return getLeftChild() == null && getRightChild() == null;
    }

    @Override
    public void display() {
        System.out.println(getData());
    }
}
