import java.util.*;

public class Quick { 
    String[] magicItems; // Declaring that there is a string array of magic items
    int comparisons = 0; // Declaring comparisons
    
    // Quick sort constructor
    public Quick(String[] magicItems) {
        this.magicItems = magicItems;
    }

    // Thought process
        // First, choose random value as pivot
        // Compare all other values to the pivot and store them in arrays for lesser values, and greater values
        // Repeat this process until the magic items are fully sorted

    // To preseve O(nlogn) I will attempt to choose a pivot which is not the highest or lowest value
    public void choosePivot(String[] A, int low, int high) { // 
        Random random = new Random();
        int pivot = random.nextInt(high - low) + low; // Doesn't allow for pivot value of the highest or lowest value, but rather a random value inbetween
        String temp = A[pivot]; // Setting the temporary variable to pivot
        A[pivot] = A[high]; // Swapping
        A[high] = temp;
    }

    // Function for swapping
    public void swap(String[] A, int lesserIndex, int greaterIndex) { // Array that will be used for swapping, the index of the lesser value, the index of the greater value
        String temp = A[lesserIndex]; // Setting the temporary variable to lesser index
        A[lesserIndex] = A[greaterIndex]; // Swapping 
        A[greaterIndex] = temp; 
    }

    // Function for partition
    // Splitting the magic items around the pivot into lesser and greater arrays 
    public int partition(String[] A, int low, int high) { 
        choosePivot(A, low, high); // Choosing pivot value 
        String pivot = A[high]; // Setting pivot value
        int i = low - 1;
        for (int j = low; j < high; j++) { 
            if (A[j].compareTo(pivot) < 0) { // If the second value is less than the last item in the array (pivot)
                i = i + 1; 
                swap(A, i, j); // Swapping the value located at i, with a smaller value
            }
            comparisons++; // Counting comparisons here
        }
        swap(A, i + 1, high); // Swapping so that the pivot value is where it belongs
        return i + 1;
    }

    // Function for quick sort
    public void quick(String[] originalA, int startIndex, int endIndex) { // Parameters start and end index so that when the array is getting split we can reference where to split
        if (startIndex < endIndex) {
            int split = partition(originalA, startIndex, endIndex);
            // Recursion
            quick(originalA, startIndex, split - 1); // Quick method from 1 to end of the values before the pivot value
            quick(originalA, split+1, endIndex); // Quick method from first value after the pivot to the end of the array
        }
    }

    //Function for toString 
    public String toString() {
        String result = ""; // Initializing result variable as empty
        /*for (int i = 0; i < magicItems.length; i++) { // Beginning at 0; go until the end of magic items; increment by 1
            // Setting result to a string of all of the magic items 
            result += magicItems[i] + "\n"; //+= is adding each result on to the previous result, \n is so that it gets split up by line 
        }*/
        result += "Quick sort comparisons: " + comparisons; // Labeling the comparisons
        return result;
    }  
}

/*
Old code for choosing a random value

int randomOne = (int)(Math.random()*A.length); // Using math library, casting the random value as an integer
        int randomTwo = (int)(Math.random()*A.length);
        int randomThree = (int)(Math.random()*A.length);
        int pivot = 0;
        if (randomTwo < randomThree && randomTwo > randomOne) {
            pivot = randomTwo;
        }
        else if (randomTwo < randomOne && randomTwo > randomThree) {
            pivot = randomTwo;
        }
        else if (randomOne < randomTwo && randomOne > randomThree) {
            pivot = randomOne;
        }
        else if (randomOne < randomThree && randomOne > randomTwo) {
            pivot = randomOne;
        }
        else if (randomThree < randomOne && randomThree > randomTwo) {
            pivot = randomThree;
        }
        else if (randomThree < randomTwo && randomThree > randomOne) {
            pivot = randomThree;
        } 
        return pivot; 



When I tried to quick sort using a queue and it was a bad idea

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
    int n = (int)(Math.random()*magicItems.length); // After choosing a random value from magicItems, it will become an integer (casting)
    String pivot = magicItems[n]; // Setting the pivot value to the actual phrase 
    Queue less = new Queue(); // Queue for storing values less than the pivot
    Queue greater = new Queue(); // Queue for storing values greater than the pivot
    firstPass(less, greater, pivot); // Executing the first pass of the sort, populates less and greater arrays
    less.tail.setNode(greater.head); // Combining the two queues to prepare for another round of quick sort
    magicQueue = less;
    less = new Queue(); // Re-initializing the queues so that they can be re used in the next round of sorting
    greater = new Queue();       
}

public Queue tbd(Queue magicQueue) {
    while (magicQueue.isEmpty() == false){
        Node value = new Node(magicQueue.dequeue().getName(), null); // Making a new node, from the node that was dequeued, and putting the phrase inside the new node. The purpose of this is to clear any pointers that were pointing to the old node. 
        if (value.getName().compareTo(pivot) < 0) { // seeing if the magic items are less than the pivot value
            less.enqueue(value); // Putting the value into the less queue
        } 
        else {
            greater.enqueue(value); // Putting the value into the greater queue
        }
    }
}

public String getPivot(Queue magicQueue) {
    Queue temp = new Queue();
    temp = (Queue)magicQueue.clone(); 
    int n = (int)(Math.random()*magicItems.length); 
    int count = 0;
    while (count < n) {
        
    }
}*/