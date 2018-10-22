package Lesson3;

public class DequeImpl extends QueueImpl implements Deque {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public void insertRight(int value) {
        super.insert(value);
    }

    @Override
    public int removeLeft() {
        return super.remove();
    }

    @Override
    public void insertLeft(int value) {
        if (front - 1 < 0)
            front = data.length;

        data[--front] = value;
        size++;
    }

    @Override
    public int removeRight() {
        if (rear < 0)
            rear = data.length - 1;

        int value = data[rear--];
        size--;
        return value;
    }
}
