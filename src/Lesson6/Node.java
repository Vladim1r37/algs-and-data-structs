package Lesson6;

public interface Node {

    void setData(int value);
    int getData();

    int getKey();

    Node getLeftChild();
    Node getRightChild();

    void setRightChild(Node rightChild);
    void setLeftChild(Node leftChild);

    Node getChildByKey(int key);

    boolean isLeftChild(int key);

    boolean isLeaf();

    void display();

}
