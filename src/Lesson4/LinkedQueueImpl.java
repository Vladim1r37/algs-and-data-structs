package Lesson4;

import Lesson3.Queue;

public class LinkedQueueImpl implements Queue {

    private TwoSideLinkedList linkedList;

    public LinkedQueueImpl() {
        this.linkedList = new TwoSideLinkedListImpl();
    }

    @Override
    public void insert(int value) {
        linkedList.addLast(value);
    }

    @Override
    public int remove() {
        return linkedList.remove().getData();
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public void display() {
        linkedList.display();

    }
}
