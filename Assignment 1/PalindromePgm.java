import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class  PalindromePgm {
    public static void main (String[] args) {//write this everytime in a main program
       try { //trying to find the file
        File file = new File("magicitems.txt");
        Scanner sc = new Scanner(file);
       
        while (sc.hasNextLine()) {
            String item = sc.nextLine();
            item = item.toUpperCase(); //Changing everything to lowercase
           item = item.replaceAll("\\s+",""); //replacing the spaces with no space
           System.out.println(item); //seperating the file one line at a time
       }
       }
       catch (FileNotFoundException e) { //if we cant find the file
            e.printStackTrace();
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
    } 
}