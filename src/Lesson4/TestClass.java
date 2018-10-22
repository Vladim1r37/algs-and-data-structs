package Lesson4;

import Lesson3.Queue;

public class TestClass {
    public static void main(String[] args) {

        testSimpleLinkedListImpl();
        testTwoSideLinkedListImpl();
        testLinkedStackInt();
        testLinkedQueue();

    }

    private static void testLinkedQueue() {
        System.out.println("Started test LinkedQueueImpl");

        Queue queue = new LinkedQueueImpl();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        queue.display();

        System.out.println("Remove");
        queue.remove();
        queue.remove();

        queue.display();

        System.out.println("Display and clear");

        while (!queue.isEmpty())
            System.out.println(queue.remove());

        System.out.println("queue is empty: " + queue.isEmpty());

        System.out.println("Finished test LinkedQueueImpl");

    }

    private static void testLinkedStackInt() {
        System.out.println("Started test LinkedStackIntImpl");

        StackInt stack = new LinkedStackImpl();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();
        stack.pop();

        System.out.println("Peek: " + stack.peek());

        System.out.println("Display:");
        stack.display();

        System.out.println("Finished test LinkedStackIntImpl");




    }

    private static void testTwoSideLinkedListImpl() {
        System.out.println("Started test TwoSideLinkedListImpl");

        TwoSideLinkedList list = new TwoSideLinkedListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.addLast(0);
        list.addLast(-1);

        list.display();

        System.out.println(list.remove());
        System.out.println(list.remove(3));
        System.out.println(list.remove(9));

        list.display();

        System.out.println("Find 2: " + list.search(2));
        System.out.println("Find 7: " + list.search(7));

        System.out.println("Finished test TwoSideLinkedListImpl");
        System.out.println();

    }

    private static void testSimpleLinkedListImpl() {
        System.out.println("Started test SimpleLinkedListImpl");
        LinkedList list = new SimpleLinkedListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.display();

        System.out.println(list.remove());
        System.out.println(list.remove(3));
        System.out.println(list.remove(9));

        list.display();

        System.out.println("Find 2: " + list.search(2));
        System.out.println("Find 7: " + list.search(7));

        System.out.println("Finished test SimpleLinkedListImpl");
        System.out.println();

    }
}
