/**
*	Singly Linked-List implementation of Queue
*   Queue (Last In First Out ~ LIFO)
*   Types of Linked-List: Singly (Only Next Reference), 
*   Doubly (Previous & Next Reference with Previous of First element & Next of Last element NULLs), 
*   Circular (Next of the Last element linked back to First element, can be
*   both Singly or Doubly)
*/
public class LinkedQueueOfStrings {

    private Node first, last;

    private class Node {
        String value;
        Node next;
    }

    public void queue(String val) {
        Node oldLast = last;
        last = new Node();
        last.value = val;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public String dequeue() {
        String val = first.value;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
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
        // linkedListQueue storing only evens
        LinkedQueueOfStrings linkedList = new LinkedQueueOfStrings();
        for(int i=0; i<=100; i++) {
            linkedList.queue(String.valueOf(i));

            if (i % 2 != 0) {
                linkedList.dequeue();
            }
        }

        // print out the Queue
        System.out.println("The Queue: "+linkedList);
        // look for 99
        System.out.println("Number 99 found: " + linkedList.search("99"));
        // look for 100
        System.out.println("Number 100 found: " + linkedList.search("100"));
    }

    public static void main(String[] args) {
        test();
    }
}