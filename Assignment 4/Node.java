// Format for linked list
// Building the framework for each node. the linked list is going to be made up of several nodes.
public class Node { // Creating the node for the linked list  
    String name = ""; // Declaring and initializing the name inside the node
    Node left = null; 
    Node right = null; 


    // Node constructor
    // Uppercase N is referring to the node class
    // Lowercase n is referring to the actual node with the information in it (could be called anything)
    public Node(String n) { // The first parameter is for the information the node is holding, the second parameter is for the pointer
        this.name = n; // Initializing the name
        this.left = null; // Initializing the pointer
        this.right = null;
    }

    // I will now build two getters: information for the node, information for the pointer
    public String getName() { // Getting the name variable from the node, returns a string
        return name; // Returns the information from the variable name
    }

    public Node getLeft() { // Returning a node
        return left; 
    }

    public Node getRight() { // Returning a node
        return right; 
    }

    // I will now build two setters: setting the name, and setting the pointer
    // Void because it isnt going to return anything
    public void setName(String n) { // Parameters always go inside parenthesis, I am only updating the name value, so we only need one parameter
        name = n;
    }

    public void setLeft(Node m) { // "m" is the node that we are going to set next equal to, for the pointer
        left = m; // I am using m so that the pointer is not null. the pointer will not be null until the end of the linked list.
    }

    public void setRight(Node m) { // "m" is the node that we are going to set next equal to, for the pointer
        right = m; // I am using m so that the pointer is not null. the pointer will not be null until the end of the linked list.
    }

    // toString so that the program prints what is actually inside the node rather than the object identifier
    public String toString() {
        String result = name; // setting a string equal to what is inside the node
        return result;
    }
}