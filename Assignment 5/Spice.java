public class Spice {
    String color;
    double totalPrice;
    int quantity;
    double unitPrice; // Calculate myself

    // Constructor
    public Spice() {
        color =  "";
        totalPrice = 0;
        quantity = 0;
        unitPrice = 0;
    }

    // Parameterized constructor
    public Spice(String color, double totalPrice, int quantity) {
        this.color =  color;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        unitPrice = totalPrice/quantity;
    }
}
