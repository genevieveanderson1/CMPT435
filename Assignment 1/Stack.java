//Building framework for the stack
public class Stack {
    //I am declaring that there is a head in the stack, the head will be initialized in the constructor
    Node top; //Uppercase Node is referring to the Node class I made prior
   
    //Stack constructor
    public Stack() { //This is a default constructor since there are no parameters
        top = null; //Initiailizing that the stack is empty to begin
    }

    //I will build a function for push, pop, and seeing if the stack is empty
    //The stack is made up of nodes, the node is made up of information and information and a pointer
   
    //Function for push
    //Nothing will be returned in this function since we are only adding a node to the stack
    //For the push function, we needed to return a node becuase that is how we will check whether it is a palindrome
    public void push(Node newNode) { //Parameter is Node because there is a new node coming in to the top of the stack, and we must take it from the linked list
        newNode.next = top; //Telling the new node to point to the next node, so that the new node can soon become the new top
        top = newNode; //Setting the new node to the top of the stack
    }

    //Function for pop
    public Node pop() { //No parameter needed because the function is only using information from the class
        Node prevTop = null; //If there is nothing in the stack, then we will return null, prevTop will save the old node so that we don't completly lose it
        if(isEmpty() == false) {
            prevTop = new Node(top.name, top.next); //I created a new node in order to make sure there were not any extra pointers pointing to something other than the next node in the stack
            top = top.getNext(); //Setting the new head to the next node in the stack, since it is now on the top
        }
        return prevTop; //Returning the node that was taken off
    }

     //Function for checking if the stack is empty
     public Boolean isEmpty() {
        if(top == null) {
            return true;
        }
        else {
            return false;
        }
    }
}


//Miscellaneous comments
    //Constructors turn the frameowork from the different classes into actual objects
    //Two equal signs if boolean
    //&& is how you say and (Boolean)
    //When biulding a function, after "public", always say the data type we are going to return (Node, Boolean, String, etc.)
    //global variable - applies to the entire class
    //regular variable - only applies to the specific functin its within
