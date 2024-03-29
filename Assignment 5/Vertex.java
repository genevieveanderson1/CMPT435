import java.util.ArrayList;

public class Vertex {
    boolean processed;
    int id;
    ArrayList<Edge> neighbors;
    Vertex predecessor;
    double value; // Starts at infinity


    // Constructor
    public Vertex() {
        id = 0;
        processed = false;
        neighbors = new ArrayList<Edge>();
        predecessor = null;
        value = Double.POSITIVE_INFINITY;
    }

    // Parameterized Constructor, if we need to make a vertex with the provided id 
    public Vertex(int id) {
        this.id = id;
        processed = false;
        neighbors = new ArrayList<Edge>();
        predecessor = null;
        if (id == 1) {
            value = 0;
        }
        else {
            value = Double.POSITIVE_INFINITY;
        }
    }

    // Function for adding edge to vertex 
    public void add(Edge e) {
        neighbors.add(e);
    }

    public Vertex getPredecessor() { 
        return predecessor; 
    }

    public double getValue() {
        return value;
    }

    public void setValue(double n) {
        value = n;
    }

    public void setPredecessor(Vertex m) { // "m" is the node that we are going to set next equal to, for the pointer
        predecessor = m; // I am using m so that the pointer is not null. the pointer will not be null until the end of the linked list.
    }

    // Function for getting the id
    public int getVertexByID() {
        return id; 
    }

    // Function to return all neighbors of a vertex
    public ArrayList<Edge> neighbors() {
        return neighbors;
    }

    // toString for printing results
    public String toString() {
        return id + ""; // Converting the value being stored to a string so that the adjList can be printed and formatted correctly
    }
}