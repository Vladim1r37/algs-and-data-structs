package Lesson3;

public interface Stack {

    void push(char value);

    char pop();

    char peek();

    boolean isEmpty();

    boolean isFull();

    int getSize();

    void display();
}
