/**
*	Singly Linked-List implementation of Stack
*   Stack (First In First Out ~ FIFO)
*   Types of Linked-List: Singly (Only Next Reference), 
*   Doubly (Previous & Next Reference with Previous of First element & Next of Last element NULLs), 
*   Circular (Next of the Last element linked back to First element, can be
*   both Singly or Doubly)
*   Compare with Array Implementation of Stack
*/
public class LinkedStackOfStrings {
    private Node first = null;

    private class Node {
        String value;
        Node next; // Singly Linked-List
    }

    public void push(String val) {

        Node oldNode = first;
        Node newNode = new Node();
        newNode.value = val;
        newNode.next = oldNode;

        this.first = newNode;
    }

    public String pop() {
        if (first == null) return null;
        String val = first.value;

        this.first = this.first.next;

        return val; 
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean search(String term) {
        if (this.first == null) return false;
        Node node = this.first;

        if (node.next == null) {
            if (node.value != null && node.value.equals(term)) {
                return true;
            } else {
                return false;
            }
        }

        while(node.next != null) {
            if (node.value == null) {
                node = node.next;
                continue;
            }

            if (node.value.equals(term)) {
                return true;
            }
            node = node.next;
        }

        return false; 
    }

    @Override
    public String toString() {
        if (this.first == null) return "";
        Node node = this.first;

        StringBuilder str = new StringBuilder();
        int i = 0;
        while(node.next != null) {
            
            str.append("[" + String.valueOf(i) + "]" + node.value);
            node = node.next;
            i++;
        }
        return str.toString();
    }

    private static void test() {

        // linkedList storing only evens
        LinkedStackOfStrings linkedList = new LinkedStackOfStrings();
        for(int i=0; i<=100; i++) {
            linkedList.push(String.valueOf(i));

            if (i % 2 != 0) {
                linkedList.pop();
            }
        }

        // print out the stack
        System.out.println("The Stack: "+linkedList);
        // look for an odd
        System.out.println("Odd Number 99 found: " + linkedList.search("99"));
        // look for an even
        System.out.println("Odd Number 100 found: " + linkedList.search("100"));
    }

    public static void main(String[] args) {
        test();
    }


}
