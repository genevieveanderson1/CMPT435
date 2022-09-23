import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Thought process prior to writing main program
    //Put all the magic items into their own queue so that we can access them in the program
    //Simultaneously push charachters into stack, queue charachters into queue
    //Simultaneously pop charachters out of stack, dequeue charachters out of queue
    //While popping and dequeueing, compare results to see whether or not the word is a palindrome

public class  Main {
    public static void main (String[] args) { //Write this everytime in a main program
        //Create a new queue, declare and initialize for holding all the magic items
        Queue magicItems = new Queue(); //Making a variable magicItems of the queue data type
        try { //Trying to find the file
            File file = new File("magicitems.txt");
            Scanner sc = new Scanner(file);
       
            while (sc.hasNextLine()) {
                String item = sc.nextLine();
                item = item.toUpperCase(); //Changing everything to upper case
                item = item.replaceAll("\\s+",""); //Replacing the spaces with no space
                //We must put the string of magic items in a node because the queue method takes nodes not strings
                Node magicItemsNode = new Node(item, null); //Parameters are the string of magic items, then the null pointer - null because this node is only a list of the magic items. Making a new node to put the phrase into.
                magicItems.enqueue(magicItemsNode); //Calling enqueue from Queue class, the parameter is because we must indicate that each phrase is on its own
            }
        }
       catch (FileNotFoundException e) { //If we cant find the file
            e.printStackTrace();
        }
   
       //While loop so the program accounts for the entire file of magic items - not just one phrase
       while (magicItems.isEmpty() == false) { //While the queue is not empty, so that we know that we can take charachters from it
            Node phraseNode = magicItems.dequeue(); //Creating a new node to put the dequeed magic items in
            Boolean palindromeBoolean = palindromeCheck(phraseNode); //Passing the phrase into the check method to see if its a palindrome and returns the result of whether or not it was a palindrome
            if (palindromeBoolean == true) {
                System.out.println(phraseNode.getName()); //If it is a palindrome, then we will print it
            }
        }  
    }

    //Function to check whether or not the phrase is a palindrome
    public static Boolean palindromeCheck(Node y) { //Parameter is a node, because we are using dequeue items which are in a Node
        Boolean palindromeCheck = true; //Initializing the checker to true, while checking for palindromes it will change based on whether or not it is a palindrome
        String phraseString = y.getName(); //Putting the node that contains the dequeued items into a string so that we can seperate it charachter by charachter
        Stack palindromeStack = new Stack(); //intializing the stack to check whether its palindrome
        Queue palindromeQueue = new Queue(); //initializing the queue to check whether its a palindrom
        for (int i = 0; i < phraseString.length(); i++) { //int i = 0 so that it starts at the beginning of the string, i < length to make sure it doesn't go past one phrase at a time, i++ so that increments by 1
            String phraseCharachter = phraseString.substring(i, i+1); //String that contains the charachters of each phrase, i +1
            Node charachterNode = new Node(phraseCharachter, null); //Creating a new node with only the charachter
            palindromeStack.push(charachterNode); //Pushing the single charachter node into the stack
            palindromeQueue.enqueue(charachterNode); //Enqueueing the single charachter node into the queue
        }

        while (palindromeStack.isEmpty() == false) { //While the stack with the charachters is not empty, continue to check the word for whether or not it is a palindrome
            Node checkQueue = palindromeQueue.dequeue(); //Simultaneously dequeuing and popping from the stack and queue to check whether its a palindrome
            Node checkStack = palindromeStack.pop();
            if (!(checkStack.getName().equals(checkQueue.getName()))) { //.equals function for comparing strings
                palindromeCheck = false; //Only one equal sign because we are actually setting the checker to false
            }
        }
        return palindromeCheck; //Providing the result of the comparison
    }
}

//Note: tested if program worked on blank.txt file

//Old code from when I was checking if my stack queue and node classes worked
/*Node nodeOne = new Node("a", null);
        Node nodeTwo = new Node("b", null);
        Node nodeThree = new Node("c", null);

        Node nodeFour = new Node("a", null);
        Node nodeFive = new Node("b", null);
        Node nodeSix = new Node("c", null);


        Stack stackOne = new Stack(); //initializing a stack
        stackOne.push(nodeOne);
        stackOne.push(nodeTwo);
        stackOne.push(nodeThree);

        while (stackOne.isEmpty() == false) {
            Node popped = stackOne.pop(); //Telling the system we are popping a node
            System.out.println(popped); //Printing what was in the node that was popped
        }

        Queue queueOne = new Queue(); //initializing a queue
        queueOne.enqueue(nodeFour);
        queueOne.enqueue(nodeFive);
        queueOne.enqueue(nodeSix);

        while (queueOne.isEmpty() == false) {
            Node queued = queueOne.dequeue();
            System.out.println(queued);
        } */

//Miscellaneous comments
    //Constructors turn the frameowork from the different classes into actual objects
    //Two equal signs if boolean
    //&& is how you say and (Boolean)
    //When biulding a function, after "public", always say the data type we are going to return (Node, Boolean, String, etc.)
    //global variable - applies to the entire class
    //regular variable - only applies to the specific functin its within
