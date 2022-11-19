import java.util.ArrayList;

public class Vertex {
    boolean processed;
    int id;
    ArrayList<Vertex> neighbors;
    Vertex next;

    // Constructor
    public Vertex() {
        id = 0;
        processed = false;
        neighbors = new ArrayList<Vertex>();
        next = null;
    }

    // Parameterized Constructor, if we need to make a vertex with the provided id 
    public Vertex(int id) {
        this.id = id;
        processed = false;
        neighbors = new ArrayList<Vertex>();
        next = null;
    }

    // Function for adding edge to vertex 
    public void add(Vertex v) {
        neighbors.add(v);
    }

    // Function for changing processed
    public void isProcessed() {
        processed = true;
    } 

    public Vertex getNext() { //Returning a node
        return next; //Next because we are calling the pointer next, returns the node from the variable next
    }

    public void setNext(Vertex m) { //"m" is the node that we are going to set next equal to, for the pointer
        next = m; //I am using m so that the pointer is not null. the pointer will not be null until the end of the linked list.
    }

    // Function for getting the id
    public int getVertexByID() {
        return id; 
    }

    // Function for checking edge
    public boolean haveEdge(int id) {
        boolean check = false; 
        for (int i = 0; i < neighbors.size(); i++) {
            if (neighbors.get(i).getVertexByID() == id) {
                check = true; // means there is an edge
            }    
        }
        return check;
    }

    // Function to return all neighbors of a vertex
    public ArrayList<Vertex> neighbors() {
        return neighbors;
    }

    // toString for printing results
    public String toString() {
        return id + ""; // Converting the value being stored to a string so that the adjList can be printed and formatted correctly
    }
}