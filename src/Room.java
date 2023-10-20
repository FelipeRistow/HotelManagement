import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Room {
    private String number;
    private String type;
    private double price;

    public Room(String number, String type, double price) throws SQLException {
        setNumber(number);
        setType(type);
        setPrice(price);
        Connection connection = DatabaseManager.getConnection();
        String sql = "INSERT INTO room (number, type, price) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, number);
        preparedStatement.setString(2, type);
        preparedStatement.setFloat(3, (float) price);
        preparedStatement.executeUpdate();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
