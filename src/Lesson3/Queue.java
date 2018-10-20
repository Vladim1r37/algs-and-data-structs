package Lesson3;

public interface Queue {

    void insert(int value);

    int remove();

    int peek();

    boolean isEmpty();

    boolean isFull();

    int getSize();

    void display();
}
