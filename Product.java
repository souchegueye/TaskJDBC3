package taskjdbc3;

import java.sql.*;
import java.util.Scanner;

public class Product {
	private final DatabaseConnection connection;
	private final Scanner scanner;
	private boolean continueLoop;

	public Product(DatabaseConnection connection) {
		this.connection = connection;
		this.scanner = new Scanner(System.in);
		this.continueLoop = true;
	}

	public void start() {
		try (Connection dbConnection = connection.getConnection();
				Statement statement = dbConnection.createStatement()) {
			TableCreation tableCreation = new ProductTableCreation(statement);
			DataInsertion dataInsertion = new ProductDataInsertion(statement, scanner);
			DataRetrieval dataRetrieval = new ProductDataRetrieval(statement);
			DataUpdate dataUpdate = new ProductDataUpdate(statement, scanner);

			while (continueLoop) {
				showMenu();
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					tableCreation.createTable();
					askToContinue();
					break;
				case 2:
					dataInsertion.insertData();
					//askToContinue();
					break;
				case 3:
					dataRetrieval.retrieveAllRecords();
					askToContinue();
					break;
				case 4:
					dataRetrieval.retrieveOneRecord();
					askToContinue();
					break;
				case 5:
					dataUpdate.updateRecord();
					askToContinue();
					break;
				case 6:
					continueLoop = false;
					System.out.println("Exit, bye!");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					System.out.println("-----------------------------");
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("An error occurred: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private void showMenu() {
		System.out.println("Menu:");
		System.out.println("1. Create Table");
		System.out.println("2. Insert Data");
		System.out.println("3. Retrieve All Records");
		System.out.println("4. Retrieve One Record");
		System.out.println("5. Update Record");
		System.out.println("6. Exit");
		System.out.println("-----------------------------------------------------------------------");
		System.out.print("Enter your choice: ");
	}

	private void askToContinue() {
		System.out.print("Do you want to continue? (yes/no): ");
		String choice = scanner.nextLine().toLowerCase();

		if (choice.equals("no")) {
			continueLoop = false;
			System.out.println("Thank you!");
		}
	}

	public static void main(String[] args) {
		DatabaseConnection connection = new MySqlConnection("jdbc:mysql://localhost:3306/studentdb", "root",
				"Godsaveus57");
		Product product = new Product(connection);
		product.start();
	}
}
