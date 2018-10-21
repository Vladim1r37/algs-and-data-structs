package Lesson3;

public class PriorityQueueManager {

    private PriorityQueue pQueue;

    public PriorityQueueManager(PriorityQueue _queue) {
        this.pQueue = _queue;
    }

    public String insert(int value) {
        if (!pQueue.isFull()) {
            pQueue.insert(value);
            return "Success";
        }
        else return "queue is full";
    }

    public String insert(int value, int priority) {
        if (!pQueue.isFull()) {
            pQueue.insert(value, priority);
            return "Success";
        }
        else return "queue is full";
    }

    public String remove() {
        if (!pQueue.isEmpty())
            return String.valueOf(pQueue.remove());
        else return "queue is empty";
    }
}
