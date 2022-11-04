import java.util.Arrays;

public class Hash {

    private final int HASH_TABLE_SIZE = 250;

    String[] magicItems;
    String[] targetArray;
    Node[] hashTable = new Node[HASH_TABLE_SIZE];
    int comparisons;

    // Constructor
    public Hash(String[] magicItems, String[] targetArray) {
        this.magicItems = magicItems;
        this.targetArray = targetArray; // 42 items
        comparisons = 1; // Because we always do at least one comparison
        populate(); // Actually populating the hash table
    }

    // Function for populating the hash table
    public void populate() {
        for (int i = 0; i < magicItems.length; i++) {
            int hash = makeHashCode(magicItems[i]); // Finding a number from 0 to 250 for where to put the magic item in the hash table
            Node hashNode = new Node(magicItems[i], null); // Putting the magic items in node with null pointer
            Node currentNode = hashTable[hash]; // hash is the current spot that we are looking at
            if (currentNode == null) {
                hashTable[hash] = hashNode; // The node with the magic item - actually putting the magic items in the hash table
            }
            else { 
                while (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext(); // Getting the next item from the chain
                }
                currentNode.setNode(hashNode); // Adding magic item to the chain if something is already there 
            }
        }
    }

    // Function for finding the target value
    public int find(String target) {
        int hash = makeHashCode(target); // Getting the index of where the target should be inside the hash table
        Node currentNode = hashTable[hash];
        comparisons++;
        while (currentNode != null && !currentNode.getName().equals(target)) { // While the current node is not null and does not equal the target value
            comparisons++;
            currentNode = currentNode.getNext(); // Getting the next item from the chain
        } 
        if (currentNode == null) {
            hash = -1; // Negative number becuase we know there isnt a negative index
        }
        return hash; // Reutrning the index where the target is 
    }

    public int makeHashCode(String str) {
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;
        // Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++) {
           char thisLetter = str.charAt(i);
           int thisValue = (int)thisLetter;
           letterTotal = letterTotal + thisValue;
        }
        // Scale letterTotal to fit in HASH_TABLE_SIZE.
        int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE;  // % is the "mod" operator
        return hashCode;
    }

    // Function for toString 
    public String toString() {
        String result = ""; // Initializing result variable as empty
        int totalComparisons = 0;
        for (int i = 0; i < targetArray.length; i++) { // Beginning at 0; go until the end of target array; increment by 1
            totalComparisons += comparisons;
            comparisons = 1; // Because every get is one compare
            result += "\n" + (i+1) + ": target word: " + targetArray[i] + " which was found at index:  " + find(targetArray[i]) + " and the number of comparisons is: " + comparisons;
        }
        double average = ((double)(totalComparisons))/targetArray.length; // dobule for decimal places
        result += "\n Average: =" + String.format("%.2f", average); // Labeling average
        return result;
    }  
}
