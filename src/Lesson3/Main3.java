package Lesson3;

public class Main3 {
    public static void main(String[] args) {

        // тестируем BracketChecker
        testBracketChecker();

        // работаем с очередью целых чисел
        testQueueManager();

        // проверяем приоритетную очередь
        testPtiorityQueue();

        // тест программы переворачивания строки
        testStringReverse();
    }

    private static void testStringReverse() {
        System.out.println("test StringReverse:");
        StringReverse.StringReverse("попугай");
        System.out.println("\n");
        System.out.println("finish StringReverse:");

    }

    private static void testPtiorityQueue() {
        System.out.println("test PriorityQueue:");
        PriorityQueue queue = new PriorityQueue(5);
        PriorityQueueManager pQManager = new PriorityQueueManager(queue);
        // приоритет чисел должен быть в пределах 0-20. Наивысший приоритет - 0
        System.out.println(pQManager.insert(10, 0));
        System.out.println(pQManager.insert(20, 10));
        System.out.println(pQManager.insert(30, 10));
        System.out.println(pQManager.insert(40, 20));
        System.out.println(pQManager.insert(50));
        System.out.println(pQManager.insert(60));
        System.out.println("\n");
        System.out.println(pQManager.remove());
        System.out.println(pQManager.remove());
        System.out.println("\n");
        System.out.println(pQManager.insert(20, 0));
        System.out.println(pQManager.insert(60, 20));
        System.out.println("\n");
        queue.display();
        System.out.println("finish test PriorityQueue:");

    }

    private static void testQueueManager() {
        System.out.println("test QueueManager:");
        // создаем экземпляр очереди
        QueueImpl queue = new QueueImpl(5);
        // создаем экземпляр класса для безопасной работы с очередью
        QueueManager queueManager = new QueueManager(queue);
        // добавляем элементы в очередь
        System.out.println("\n");
        System.out.println(queueManager.insert(1));
        System.out.println(queueManager.insert(2));
        System.out.println(queueManager.insert(3));
        System.out.println(queueManager.insert(4));
        System.out.println(queueManager.insert(5));
        // добавляем шестой элемент в очередь размером 5 элементов
        System.out.println("\n");

        System.out.println(queueManager.insert(6));
        // удаляем элементы из очереди
        System.out.println("\n");
        System.out.println(queueManager.remove());
        System.out.println(queueManager.remove());
        System.out.println(queueManager.remove());
        // добавляем еще несколько элементов
        System.out.println("\n");
        System.out.println(queueManager.insert(6));
        System.out.println(queueManager.insert(7));
        System.out.println(queueManager.insert(8));
        System.out.println(queueManager.insert(9));
        // выводим на экран очередь
        System.out.println("\n");
        queue.display();
        // снова удаляем элементы, тестируем переход метки front в начало массива
        System.out.println("\n");
        System.out.println(queueManager.remove());
        System.out.println(queueManager.remove());
        System.out.println(queueManager.remove());
        // проверяем метод чтения элемента, первого на выдачу в очереди
        System.out.println("\n");
        System.out.println(queue.peek());
        System.out.println("finish test QueueManager:");
    }

    private static void testBracketChecker() {
        System.out.println("test BracketChecker:");
        String in = "public void push(char i) {\n" +
                "        stackArr[++top] = i;\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public char pop() {\n" +
                "        return stackArr[top--];";
        new BracketChecker(in).check();
        System.out.println("finish check BracketChecker");
    }
}
