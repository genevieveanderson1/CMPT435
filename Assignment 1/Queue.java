public class Queue {
    Node head; //queue needs both head and tail 
    Node tail; 
    //these are declaring, then inside the constructor we will intiialize them 
    
    //Constructor - these turn the frameowork from the different classes into actual objects
    public Queue() {
        head = null; //They will both begin as empty
        tail = null;
    }

    //methods are lowercase, objects are uppercase
    public void enqueue(Node y) { //the parameter is a node because we will be taking a node from the stack
        if (head == null) { //if the queue was empty, then this if statement will make it so that the incoming node to the queue will become both the head and the tail
            tail = y; //making the incoming node the tail
            head = tail;  // setting the head to the tail 
        }
        else { //the else statement is for if there are already nodes in the queue
            tail.setNode(y); //opposite of the stack because in the stack we are bringining in a new node which must point to the old head, but in the queue the tail is already there and needs to be pointed to the incoming node
            tail = y; //making the incoming node the tail
        }
    }

    public Boolean isEmpty() {
        if (head == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public Node dequeue() { //you dont need a parameter for this because it will be using information from this class, not anything else
        Node oldHead = head; // creating old head makes it so that we don't completly lost the node that is getting removed from the queue
        head = head.getNext(); //this is saying that the new head is goig to be the head that was originally next in line
        if (head == null) {
            tail = null; //We are doing this because otherwise, the tail would still be pointing at the node we are returning
        }
        return oldHead; //This function requires that a Node be returned, so we will return the old head to help us verify whether or not it is a palindrome
    }
    } 
