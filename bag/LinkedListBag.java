import java.util.Iterator;
import java.util.NoSuchElementException;

/**
*   Singly Linked List Implementation of Bag
*   Important Points
*   1) A Bag is a collection where removing items are not supported
*   2) The purpose is the provide clients with the ability to collect items and then
*   iterate through the collected items
*   3) Elements can be inserted and removed entirely at random (no ordering)
*   4) Similar to Set, but Set  extends Bag in two ways. (1) Elements must be unique (2) A number of Set Operations like Intersect, Union, etc.
*/
public class LinkedListBag<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public LinkedListBag() {
        first = null;
        n = 0;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

   
    public static void test() {
        LinkedListBag<String> bag = new LinkedListBag<String>();
        for(int i=0; i<=100; i++) {
            bag.add(String.valueOf(i));
        }

        System.out.println("size of bag = " + bag.size());
        for (String s : bag) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        test();
    }
}