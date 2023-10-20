import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Reservation {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Client client;
    private String status;
    private String room;

    public Reservation(LocalDate checkInDate, LocalDate checkOutDate, String room) throws SQLException {
        setCheckInDate(checkInDate);
        setCheckOutDate(checkOutDate);
        setRoom(room);
        setStatus("CONFIRMED");
        Connection connection = DatabaseManager.getConnection();
        String sql = "INSERT INTO reservation (checkin_date, checkout_date, status) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(checkInDate));
        preparedStatement.setString(2, String.valueOf(checkOutDate));
        preparedStatement.setString(3, room);
        preparedStatement.setString(4, "CONFIRMED");
        preparedStatement.executeUpdate();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
