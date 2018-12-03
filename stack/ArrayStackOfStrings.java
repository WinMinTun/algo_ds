/**
*   Array Implementation of Stack
*   Stack (First In First Out ~ FIFO)
*   Compare with LinkedList implementation of Stack
*/
public class ArrayStackOfStrings {

    private String[] stack;
    private int n = 0;

    public ArrayStackOfStrings(int size) {
        stack = new String[size];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(String val) {
        stack[n++] = val;
    }

    public String pop() {
        return stack[--n];
    }

    private static void test() {

    }

    public static void main(String[] args) {
        test();
    }

}