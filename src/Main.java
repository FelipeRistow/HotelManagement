import java.time.LocalDate;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Principal");
            System.out.println("1. Criar um Cliente");
            System.out.println("2. Criar uma Reserva");
            System. out.println("3. Criar um Quarto");
            System.out.println("4. Sair");

            System.out.print("Digite sua escolha: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String clientName = scanner.nextLine();
                    System.out.print("E-mail do cliente: ");
                    String clientEmail = scanner.nextLine();
                    System.out.print("E-mail do cliente: ");
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
