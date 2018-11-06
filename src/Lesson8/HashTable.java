package Lesson8;

import java.util.LinkedList;

public class HashTable {

    private LinkedList<Item>[] hashArray;
    private int currentSize;

    public HashTable(int maxSize) {
        this.hashArray = new LinkedList[maxSize];
        this.currentSize = 0;
    }

    public void insert(Item item) {
        int index = hashFunc(item);
        if (hashArray[index] == null) {
            hashArray[index] = new LinkedList<>();
        }
        hashArray[index].push(item);
        currentSize++;
    }

    public boolean remove(Item item) {
        return remove(item.getData()) != null;
    }

    public Item remove(int key) {
        int index = hashFunc(key);
        if (hashArray[index] != null) {
            for (int i = 0; i < hashArray[index].size(); i++) {
                if (hashArray[index].get(i).getData() == key) {
                    return hashArray[index].remove(i);
                }
            }
        }
        return null;
    }

    public Item find(int key) {
        int index = hashFunc(key);
        if (hashArray[index] != null) {
            for (int i = 0; i < hashArray[index].size(); i++) {
                if (hashArray[index].get(i).getData() == key) {
                    return hashArray[index].get(i);
                }

            }
        }

        return null;
    }

    public int hashFunc(Item item) {
        return hashFunc(item.hashCode());
    }

    public int hashFunc(int key) {
        return key % hashArray.length;
    }


    public void display() {
        for (int i = 0; i < hashArray.length; i++) {
                System.out.println(hashArray[i]);
        }
    }
}
