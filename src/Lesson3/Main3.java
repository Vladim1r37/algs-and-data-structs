package Lesson3;

public class Main3 {
    public static void main(String[] args) {

        // тестируем BracketChecker
        testBracketChecker();

        // работаем с очередью целых чисел
        testQueueManager();
    }

    private static void testQueueManager() {
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
