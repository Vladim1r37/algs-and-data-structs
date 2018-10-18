package Lesson3;

public class Main3 {
    public static void main(String[] args) {

        // тестируем BracketChecker
        testBracketChecker();
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
