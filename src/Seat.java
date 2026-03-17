public class Seat {
    private String type;
    private int count;
    private double price;

    // Constructor
    public Seat(String type, int count, double price) {
        this.type = type;
        this.count = count;
        this.price = price;
    }
    // get methods
    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalSales() {
        return count * price;
    }
}