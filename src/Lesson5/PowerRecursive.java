package Lesson5;

public class PowerRecursive {

    public static void main(String[] args) {

        System.out.println(powR(2, 8));
    }

    private static int powR(int base, int exponent) {
        if (exponent == 1)
            return base;
        return base * powR(base, exponent - 1);
    }
}