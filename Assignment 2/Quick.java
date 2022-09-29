import java.util.*;

public class Quick {
    Queue magicQueue; // Queue to put the original list of all the magic items in 
    String[] magicItems;
    
    public Quick(String[] magicItems) {
        this.magicItems = magicItems;
    }

    public void firstPass(Queue less, Queue greater, String pivot) { // Will go through one pass of the quick sort, then pass it on the next queue
        for (int i = 0; i < magicItems.length; i++) {
            Node value = new Node(magicItems[i], null); // putting the value that is being compared into a node, no pointer is needed
            if (magicItems[i].compareTo(pivot) < 0) { // seeing if the magic items are less than the pivot value
                less.enqueue(value); // Putting the value into the less queue
            } 
            else {
                greater.enqueue(value); // Putting the value into the greater queue
            }
        }
    }

    public void quick(){
        int n = (int) (Math.random()*magicItems.length); // After choosing a random value from magicItems, it will become an integer (casting)
        String pivot = magicItems[n]; // Setting the pivot value to the actual phrase 
        Queue less = new Queue(); // Queue for storing values less than the pivot
        Queue greater = new Queue(); // Queue for storing values greater than the pivot
        firstPass(less, greater, pivot); // Executing the first pass of the sort, populates less and greater arrays
        less.tail.setNode(greater.head); // Combining the two queues to prepare for another round of quick sort
        magicQueue = less;
        less = new Queue(); // Re-initializing the queues so that they can be re used in the next round of sorting
        greater = new Queue(); 
        int count = 0;
        while (magicQueue.isEmpty() == false) {
            System.out.println(magicQueue.dequeue());
            count++;
        }
        System.out.println(count);
    }






}
