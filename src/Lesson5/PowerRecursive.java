package Lesson5;

public class PowerRecursive {

    public static void main(String[] args) {

        System.out.println(pow(2, 8));
        System.out.println(pow(0, 0));
        System.out.println(pow(0, 1));
        System.out.println(pow(0, 3));
        System.out.println(pow(2, -3));
        System.out.println(pow(2, 0));
    }

    private static int pow(int base, int exponent) {
        if (base == 0 && exponent == 0)
            System.out.println("Ошибка. 0 не возводится в степень 0");
        else if (exponent < 0)
            System.out.println("Ошибка. Показатель степени должен быть положительным.");
        else if (exponent == 0)
            return 1;
        else
            return powR(base, exponent);
        return -1;
    }

    private static int powR (int base, int exponent) {
        if (exponent == 1)
            return base;
        return base * powR(base, exponent - 1);
    }
}