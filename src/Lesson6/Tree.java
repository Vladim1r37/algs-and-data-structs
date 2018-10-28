package Lesson6;

public interface Tree {

    void add(int value);

    int remove(int value);

    Integer find(int value);

    boolean isEmpty();

    void display();

    int getSize();

    void traverse(TraverseMode mode);

}
