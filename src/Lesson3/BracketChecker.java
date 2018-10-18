package Lesson3;

public class BracketChecker {

    private String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    public void check() {
        StackImpl stack = new StackImpl(this.input.length());

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '[':
                case '(':
                case '{':
                    stack.push(ch);
                    break;
                case ']':
                case ')':
                case '}':
                    if (stack.isEmpty()) {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    else {
                        char topChar = stack.pop();
                        if (topChar == '[' && ch != ']'
                                || topChar == '(' && ch != ')'
                                || topChar == '{' && ch != '}') {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}