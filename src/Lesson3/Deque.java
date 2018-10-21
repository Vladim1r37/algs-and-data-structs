package Lesson3;

public interface Deque extends Queue {

    void insertRight(int value);
    int removeLeft();

    void insertLeft(int value);
    int removeRight();
}
