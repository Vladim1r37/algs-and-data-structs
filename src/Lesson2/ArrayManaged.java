package Lesson2;

import java.util.Random;

public class ArrayManaged {

    protected int[] data;
    protected int size;

    public ArrayManaged(int maxSize) {
        this.data = new int[maxSize];
        this.size = 0;
    }

    public boolean add(int value) {
        if (isFull())
            return false;

        data[size++] = value;
        return true;
    }

    protected boolean isFull() {
        return data.length == size;
    }

    public boolean remove(int value) {
        int index = indexOf(value);
        return removeByIndex(index);
    }

    public boolean removeByIndex(int index) {
        if (index < 0 || index >= size)
            return false;

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        return true;
    }

    protected int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value)
                return i;
        }

        return -1;
    }

    public boolean find(int value) {
        return indexOf(value) != -1;
    }

    public void fillRandom(int maxValue) {
        Random rnd = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = rnd.nextInt(maxValue);
        }
        size = data.length;
    }

    public int[] getData() {
        return data;
    }
}