package Lesson3;

public class QueueManager {

    private QueueImpl queue;

    public QueueManager(QueueImpl _queue) {
        this.queue = _queue;
    }

    public String insert(int value) {
        if (!queue.isFull()) {
            queue.insert(value);
            return "Success";
        }
        else return "queue is full";
    }

    public String remove() {
        if (!queue.isEmpty())
            return String.valueOf(queue.remove());
        else return "queue is empty";
    }
}
