import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = DatabaseManager.getConnection();

        while (true) {
            System.out.println("Menu Principal");
            System.out.println("1. Criar um Cliente");
            System.out.println("2. Criar uma Reserva");
            System.out.println("3. Criar um Quarto");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Listar Reservas");
            System.out.println("6. Listar Quartos");
            System.out.println("7. Sair");

            System.out.print("Digite sua escolha: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String clientName = scanner.nextLine();
                    System.out.print("E-mail do cliente: ");
                    String clientEmail = scanner.nextLine();
                    System.out.print("Telefone do cliente: ");
                    String clientPhone = scanner.nextLine();
                    Client client = new Client(clientName, clientEmail, clientPhone);
                    System.out.println("Cliente criado.");
                    break;

                case 2:
                    System.out.print("Data de check-in (dd/mm/aaaa): ");
                    LocalDate checkInDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Data de check-out (dd/mm/aaaa): ");
                    LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Número do quarto: ");
                    String roomSelected = scanner.nextLine();
                    Reservation reservation = new Reservation(checkInDate, checkOutDate, roomSelected);
                    System.out.println("Reserva criada.");
                    break;

                case 3:
                    System.out.print("Número do quarto: ");
                    String roomNumber = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Tipo do quarto: ");
                    String roomType = scanner.nextLine();
                    System.out.print("Preço do quarto: ");
                    double roomPrice = scanner.nextDouble();
                    Room room = new Room(roomNumber, roomType, roomPrice);
                    System.out.println("Quarto criado.");
                    // Save the room instance to the database
                    // Database.saveRoom(room);
                    break;

                case 4:
                    String sql = "SELECT * FROM client";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();

                    System.out.println("Lista de clientes:");
                    while (resultSet.next()) {
                        int clientId = resultSet.getInt("client_id");
                        String clientFoundName = resultSet.getString("name");
                        String clientFoundEmail = resultSet.getString("email");
                        String clientFoundPhone = resultSet.getString("phone");

                        System.out.println("Cliente " + clientId + ": " + clientFoundName + ", " + clientFoundEmail + ", " + clientFoundPhone);
                        System.out.println();
                    }

                    resultSet.close();
                    statement.close();
                case 5:
                    String reservationSql = "SELECT * FROM reservation";
                    PreparedStatement reservationStatement = connection.prepareStatement(reservationSql);
                    ResultSet reservationResultSet = reservationStatement.executeQuery();

                    System.out.println("Lista de reservas:");
                    while (reservationResultSet.next()) {
                        int reservationId = reservationResultSet.getInt("reservation_id");
                        String reservationIn = String.valueOf(reservationResultSet.getDate("checkin_date"));
                        String reservationOut = String.valueOf(reservationResultSet.getDate("checkout_date"));
                        String reservationRoom = reservationResultSet.getString("room");
                        String reservationStatus = reservationResultSet.getString("room");

                        System.out.println("Reserva " + reservationId + ": " + reservationIn + ", " + reservationOut + ", " + reservationRoom + ", " + reservationStatus);
                        System.out.println();
                    }

                    reservationResultSet.close();
                    reservationStatement.close();
                case 6:
                    String roomSql = "SELECT * FROM room";
                    PreparedStatement roomStatement = connection.prepareStatement(roomSql);
                    ResultSet roomResultSet = roomStatement.executeQuery();

                    System.out.println("Lista de quartos:");
                    while (roomResultSet.next()) {
                        int roomId = roomResultSet.getInt("room_id");
                        String roomFoundNumber = roomResultSet.getString("number");
                        String roomFoundType = roomResultSet.getString("type");
                        String roomFoundPrice = String.valueOf(roomResultSet.getFloat("price"));

                        System.out.println("Quarto " + roomId + ": " + roomFoundNumber + ", " + roomFoundType + ", " + roomFoundPrice);
                        System.out.println();
                    }

                    roomResultSet.close();
                    roomStatement.close();

                case 7:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    DatabaseManager.closeConnection();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Escolha inválida. Por favor, tente novamente.");
            }
        }
    }
}
