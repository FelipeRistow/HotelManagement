public class Room {
    private int number;
    private RoomType type;
    private double price;

    public Room(int number, RoomType type, double price) {
        setNumber(number);
        setType(type);
        setPrice(price);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
