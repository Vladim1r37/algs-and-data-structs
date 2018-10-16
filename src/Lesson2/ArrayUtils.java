package Lesson2;

public class ArrayUtils {

    public static void sortBubble(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    changeElements(array, j, j + 1);
                }
            }
        }
    }

    public static void sortSelect(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minElementIndex])
                    minElementIndex = j;
            }
            changeElements(array, i, minElementIndex);
        }
    }

    public static void sortInsert(int[] array) {
        int in, out;
        for (out = 1; out < array.length; out++) {
            int temp = array[out];
            in = out;
            while (in > 0 && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                in--;
            }
            array[in] = temp;
        }
    }

    private static void changeElements(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}
