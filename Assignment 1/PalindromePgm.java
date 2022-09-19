import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class  PalindromePgm {
    public static void main (String[] args) {//write this everytime in a main program
        //Create a new queue, declare and initialize for holding all the magic items
        Queue magicItems = new Queue(); //making a variable of the queue data type
        try { //trying to find the file
        File file = new File("magicitems.txt");
        Scanner sc = new Scanner(file);
       
        while (sc.hasNextLine()) {
            String item = sc.nextLine();
            item = item.toUpperCase(); //Changing everything to lowercase
            item = item.replaceAll("\\s+",""); //replacing the spaces with no space
            Node magicItemsNode = new Node(item, null); //We must put the string of magic items in a node because the queue method takes nodes not strings - parameters are the string, then the pointer. the pointer is null because this node is on its own because it is just a list of all the magic items
            magicItems.enqueue(magicItemsNode); //calling enqueue from Queue class, the parameter item is because we must indicate that each phrase is on its own 
       }
       }
       catch (FileNotFoundException e) { //if we cant find the file
            e.printStackTrace();
       }
       
       //Prior, put all the magic items into their own queue so that we can access them in the program
       //First push characheters into stack, queue charachters into queue
       //Then, pop charachters out of stack, dequeue charachters out of queue
       //Then, compare resukts to see whether or not the word is a palindrome

       //make a loop so that it keeps going and doesnt just do one phrase
       while (magicItems.isEmpty() == false) { //while the queue is not empty so that we know that we can take charachters from it
            Node phraseNode = magicItems.dequeue(); //creating a new node to put the dequeed magic items in
            Boolean palindromeBoolean = palindromeCheck(phraseNode); //passing the phrase into the check method to see if its a palindrome and returns the result of whether or not it was a palindrome
            if (palindromeBoolean == true) {
                System.out.println(phraseNode.getName()); //if it is a palindrome, then we will print it
            }
       } 
        
    } 

    //creating a new method to check whether or not it is a palindrome 
    public static Boolean palindromeCheck(Node y) { //parameter is a node, because we are using dequeue items which are in a Node 
        Boolean palindromeCheck = true; //initializing the checker to true, while checking for palindromes it will change based on whether or not it is a palindrome
        String phraseString = y.getName(); //Putting the node that contains the dequeued items into a string so that we can seperate it charachter by charachter
        Stack palindromeStack = new Stack(); //intializing the stack to check whether its palindrome
        Queue palindromeQueue = new Queue(); //initializing the queue to check whether its a palindrom
        for (int i = 0; i < phraseString.length(); i++) { //int i = 0 so that it starts at the beginning of the string, i < length to make sure it doesn't go past one phrase at a time, i++ so that increments by 1
            String phraseCharachter = phraseString.substring(i, i+1); //String that contains the charachters of each phrase
            Node charachterNode = new Node(phraseCharachter, null); //creating a new node with only the charachter
            palindromeStack.push(charachterNode); //pushing the single charachter node into the stack
            palindromeQueue.enqueue(charachterNode); //enqueueing the single charachter into the queue
        } 

        while (palindromeStack.isEmpty() == false) { //while the stack with the charachters is not empty, we will continue to check the word for whether or not it is a palindrome
            Node checkStack = palindromeStack.pop(); //Simultaneously popping and dequeuing from the stack and queue to check whether its a palindrome
            Node checkQueue = palindromeQueue.dequeue();
            if (checkStack.getName().equals(checkQueue.getName()) == false) { //.equals is function for comparing strings 
                palindromeCheck = false; //only one equal sign because we are actually setting it to false
            }  
        }
        return palindromeCheck; //showing the result of the comparison
    }
}



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