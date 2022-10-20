import java.util.*;

public class Node {
    String name;
    Node next;
    ArrayList<Node> preferences; // array list that holds nodes, this is good because we dont need to know the sized
    //This is the class that builds the framework for the linekd list
    //Building the framework for each node. the linked list is going to be made up of several nodes.
    //Node constructor
    //Uppercase N is referring to the node class
    //Lowercase n is referring to the actual node with the information in it (could be called anything)
    public Node(String n, Node node) { //The first parameter is for the information the node is holding, the second parameter is for the pointer
        this.name = n; //Initializing the name
        this.next = null; //Initializing the pointer
        preferences = new ArrayList<Node>();
    }

    //I will now build two getters: information for the node, information for the pointer
    public String getName() { //Getting the name variable from the node, returns a string
        return name; //Returns the information from the variable name
    }

    public ArrayList<Node> getPref() { //Returning a node
        return preferences; //Next because we are calling the pointer next, returns the node from the variable next
    }

    //I will now build two setters: setting the name, and setting the pointer
    //Void because it isnt going to return anything
    public void setName(String n) { //Parameters always go inside parenthesis, I am only updating the name value, so we only need one parameter
        name = n;
    }

    public void setPref(Node m) { //"m" is the node that we are going to set next equal to, for the pointer
        preferences.add(m); // adding m to the array list
         //I am using m so that the pointer is not null. the pointer will not be null until the end of the linked list.
    }

    //toString so that the program prints what is actually inside the node rather than the object identifier
    public String toString() {
        String result = name; //setting a string equal to what is inside the node
        result += ": " + Arrays.toString(preferences.toArray());
        return result;
    }
}
