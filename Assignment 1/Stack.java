//building framework for the stack 
//global variable - applies to the entire class
//regular variable - only applies to the specific functin its within
public class Stack {
    Node head; //uppercase Node is referring to the Node class I made before
    
    //constructor
    public Stack() { // because this has no parameters, this is a default constructor
        head = null; //initiailizing that the stack is empty to begin
    }

    //function 
    //next I will build a function for pop, and a function for push
    public Node pop() { //after public, always say the data type we are going to return
        Node prevHead = null; //if there is nothing in the stack, then we will return null
        if(head != null) { //&& is how you say and (Boolean) 
            prevHead = head; //after popping the top node, return that node
            head = head.getNext(); //setting the new head to the next node in the stack because it is now on the top
        }
        return prevHead; //returning the node that was taken off, returning outside the if statement because we have to return something, not just if the "if" conditions are met
    }
    
    // function for checking if the stack is empty 
    public Boolean isEmpty() {
        if(head == null) { //two equal signs because it is boolean
            return True;
        }
        else {
            return False;
        }
    }
}