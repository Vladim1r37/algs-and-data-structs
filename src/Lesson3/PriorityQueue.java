package Lesson3;

public class PriorityQueue implements Queue {

    private int[] data;
    private int[] priority;
    private int size;

    public PriorityQueue(int maxSize) {
        this.data = new int[maxSize];
        this.priority = new int[maxSize];
        this.size = 0;
    }

    @Override
    public void insert(int value) {
        int index = 0;
        int priorityOfValue = 20; // приоритет по умолчанию
        if (isEmpty()) {
            priority[size] = priorityOfValue;
            data[size++] = value;
        }
        else {
            for (index = size - 1; index >= 0; index--) {
                // числа с одинаковым приоритетом сортируются по порядку добавления в очередь
                if (priorityOfValue >= priority[index]) {
                    data[index + 1] = data[index];
                    priority[index + 1] = priority[index];
                }
                else break;
            }
            data[index + 1] = value;
            priority[index + 1] = priorityOfValue;
            size++;
        }
    }

    public void insert(int value, int priorityOfValue) {
        int index = 0;
        if (isEmpty()) {
            priority[size] = priorityOfValue;
            data[size++] = value;
        }
        else {
            for (index = size - 1; index >= 0; index--) {
                if (priorityOfValue >= priority[index]) {
                    data[index + 1] = data[index];
                    priority[index + 1] = priority[index];
                }
                else break;
            }
            data[index + 1] = value;
            priority[index + 1] = priorityOfValue;
            size++;
        }
    }

    @Override
    public int remove() {
        return data[--size];
    }

    @Override
    public int peek() {
        return data[size];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void display() {
        int currentSize = size;
        while (currentSize > 0) {
            System.out.println(data[--currentSize]);
        }
    }
}
