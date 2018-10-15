package Lesson2;

import java.util.concurrent.TimeUnit;

public class ArrayTest {
    public static void main(String[] args) {
        // Создаю массив на 1000000 элементов внутри класса, работающего с массивом
        ArrayManaged myArray = new ArrayManaged(100000);

        // Заполняю массив случайными числами
        myArray.fillRandom(30000);

        // Пытаюсь добавить новое значение в полный массив
        System.out.println("Добавить число 100 в массив - " + myArray.add(100));

        // Ищу число 100 в массиве
        System.out.println("Есть ли число 100 в массиве - " + myArray.find(100));

        // Поиск числа бинарным поиском
        System.out.println("Есть ли число 100 в массиве - " + myArray.binarySearch(100));


        // Такое число есть. Удаляю 100
        System.out.println("Удалить число 100 из массива - " + myArray.remove(100));

        // Добавляю число 100 в массив
        System.out.println("Добавить число 100 в массив - " + myArray.add(100));

        //Тест сортировки пузырьковым методом
        System.out.println("sort bubble");
        long start = System.nanoTime();
        ArrayUtils.sortBubble(myArray.getData());
        System.out.println("Время сортировки - " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " миллисекунд");
        myArray.fillRandom(30000);

        //Тест сортировки методом выбора
        System.out.println("sort select");
        start = System.nanoTime();
        ArrayUtils.sortSelect(myArray.getData());
        System.out.println("Время сортировки - " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " миллисекунд");
        myArray.fillRandom(30000);

        //Тест сортировки методом вставки
        System.out.println("sort insert");
        start = System.nanoTime();
        ArrayUtils.sortInsert(myArray.getData());
        System.out.println("Время сортировки - " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " миллисекунд");

    }
}