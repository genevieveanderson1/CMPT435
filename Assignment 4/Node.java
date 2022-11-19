// Building the framework for each node
public class Node { 
    String name = ""; // Declaring and initializing the name inside the node
    Node left = null; 
    Node right = null; 

    // Node constructor
    public Node(String n) { // The first parameter is for the information the node is holding, the second parameter is for the pointer
        this.name = n; // Initializing the name
        this.left = null; 
        this.right = null;
    }

    // Getters
    public String getName() { // Getting the name variable from the node, returns a string
        return name; // Returns the information from the variable name
    }

    public Node getLeft() { 
        return left; 
    }

    public Node getRight() { 
        return right; 
    }

    // Setters
    public void setName(String n) { 
        name = n;
    }

    public void setLeft(Node m) { 
        left = m; 
    }

    public void setRight(Node m) { 
        right = m; 
    }

    // toString so that the program prints what is actually inside the node rather than the object identifier
    public String toString() {
        String result = name; // Setting a string equal to what is inside the node
        return result;
    }
}