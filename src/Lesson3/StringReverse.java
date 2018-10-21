package Lesson3;

public class StringReverse {

    public static void StringReverse(String string) {

        Stack stack = new StackImpl(string.length());
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }
}
