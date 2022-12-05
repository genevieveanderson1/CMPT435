public class Edge {
    Vertex v1;
    Vertex v2;
    int weight;

    // Constructor
    public Edge() {
        v1 = null;
        v2 = null;
        weight = 0;
    }

    // Parameterized constructor
    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Vertex getv1() {
        return v1;
    }

    public Vertex getv2() {
        return v2;
    }

    public int getWeight() {
        return weight;
    }
}
