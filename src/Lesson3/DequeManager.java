package Lesson3;


public class DequeManager {

    private DequeImpl deque;

    public DequeManager(DequeImpl _deque) {
        this.deque = _deque;
    }

    public String insertRight(int value) {
        if (!deque.isFull()) {
            deque.insertRight(value);
            return "Success";
        }
        else return "deque is full";
    }

    public String removeLeft() {
        if (!deque.isEmpty())
            return String.valueOf(deque.removeLeft());
        else return "queue is empty";
    }

    public String insertLeft(int value) {
        if (!deque.isFull()) {
            deque.insertLeft(value);
            return "Success";
        }
        else return "deque is full";
    }

    public String removeRight() {
        if (!deque.isEmpty())
            return String.valueOf(deque.removeRight());
        else return "queue is empty";
    }

    public void displayLeftToRight() {

        int currentSize = deque.size;
        int currentFront = deque.front;
        while (currentSize > 0) {
            System.out.println(deque.data[currentFront++]);
            if (currentFront == deque.data.length)
                currentFront = QueueImpl.DEFAULT_FRONT;
            currentSize--;
        }
    }

    public void displayRightToLeft() {

        int currentSize = deque.size;
        int currentRear = deque.rear;
        while (currentSize > 0) {
            System.out.println(deque.data[currentRear--]);
            if (currentRear < 0)
                currentRear = deque.data.length - 1;
            currentSize--;
        }

    }
}
