
//building the framework for each node. the linked list is going to be made up of several nodes. 
public class Node { //creating the node for the linked list  
    String name = ""; // declaring and initializing the name
    Node next = null; // declaring and initializing the node

    //uppercase N is referring to the node class
    //lowercase n is referring to the actual node with the information in it (could be called anything)
    public Node(String n,Node node) { //constructor using two parameteres: the string and the node
        name = n;
        next = node;
    } 

    // need two getters: information for the node, information for the pointer
    public String getName() { // getting the name variable from the node 
        return name;
    }

    //returning a node this time, not a string
    public Node getNode() {
        return next; //next because we are calling the pointer next
    }

    // void because it isnt going to return anything
    public void setName(String n) { //parameters always go inside parenthesis, we are only updating the name value in this one so we only need one parameter
        name = n; //only one equal sign because we are setting variable
    }

    public void setNode(Node m) { //m is the node that we are going to set next equal to, for the pointer
        next = m; // I am using m so that the pointer is not null. the pointer will not be null until the end of the linked list.
    } 
}


