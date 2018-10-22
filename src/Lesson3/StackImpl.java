package Lesson3;

public class StackImpl implements Stack {

    private int maxSize;
    private char[] stackArr;
    private int top;


    public StackImpl(int size) {
        this.maxSize = size;
        this.stackArr = new char[size];
        this.top = -1;

    }

    @Override
    public void push(char i) {
        stackArr[++top] = i;

    }

    @Override
    public char pop() {
        return stackArr[top--];
    }

    @Override
    public char peek() {
        if (!isEmpty())
            return stackArr[top];
        return '\u0000';
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);

    }

    @Override
    public boolean isFull() {
        return top >= stackArr.length - 1;
    }

    @Override
    public int getSize() {
        return top + 1;
    }

    @Override
    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArr[i]);
        }
    }
}

