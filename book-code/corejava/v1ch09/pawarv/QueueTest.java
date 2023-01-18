package pawarv;

import java.util.PriorityQueue;

import treeSet.Item;
// import set.Item;



public class QueueTest {
    public static void main(String[] args) {

        var queue = new PriorityQueue<Item>();

        queue.add(new Item("Electronic", 5555));
        queue.add(new Item("Book", 2222));
        queue.add(new Item("Abacus", 1111));
        queue.add(new Item("Computer", 3333));
        queue.add(new Item("Gadget", 7777));
        queue.add(new Item("Fridge", 6666));
        queue.add(new Item("Digital", 4444));


        // Note that the order of the elements is not the same as the order in which they were added
        System.out.println(queue);

        // Note that the elements are shown in the order in which they are removed
        System.out.println("\n***********Iterating over elements . . .");
        for (Item item : queue) {
            System.out.println(item);
        }

        // remove elements
        System.out.println("\n***********Removing elements . . .");
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

        

        
    }
}
