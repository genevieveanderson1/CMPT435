//Building the framework for the queue
public class Queue {
    //I am declaring the head and tail inside the queue, then initialize them in the constructor
    Vertex head; //Queue needs both head and tail, whereas the stack only needed a head
    Vertex tail;  
   
    //Queue constructor
    public Queue() {
        head = null; //Initializing the head
        tail = null; //Initializing the tail
    }

    // I will build a function for pop, push, and seeing if the stack is empty
    // The stack is made up of Vertexs, the Vertex is made up of information and information and a pointer
    // Function for enqueue
    public void enqueue(Vertex y) { //Parameter is a Vertex because we will be a new Vertex being enqueued in the queue
        if (head == null) { //If the queue was empty, then the if loop will make it so that the incoming Vertex to the queue will become both the head and the tail
            tail = y; //Setting the incoming Vertex to the tail
            head = tail;  //Setting the head to the tail
        }
        else { //The else statement is for if there are already Vertexs in the queue
            tail.setNext(y); //Opposite of the stack because in the stack we are bringining in a new Vertex which must point to the old head, but in the queue the tail is already there and needs to be pointed to the incoming Vertex
            tail = y; //Setting the incoming Vertex to the tail
        }
    }

    //Function for dequeue
    public Vertex dequeue() { //No parameter needed because the function is only using information from the class
        Vertex oldHead = head; //Creating old head makes it so that we don't completly lose the Vertex that is getting removed from the queue
        head = head.getNext(); //The new head is goig to be the head that was originally next in line
        if (head == null) { //If the head is null, then the tail should also be null
            tail = null; //Doing this because otherwise, the tail would still be pointing at the Vertex we are returning
        }
        return oldHead; //Return the old head to help us verify whether or not it is a palindrome in the main program
    }

    //Function for checking is the queue is empty
    public Boolean isEmpty() {
        if (head == null) {
            return true;
        }
        else {
            return false;
        }
    }
}
