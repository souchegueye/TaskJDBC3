package taskjdbc3;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class ProductDataInsertion implements DataInsertion {
	private final Statement statement;
	private final Scanner scanner;

	ProductDataInsertion(Statement statement, Scanner scanner) {
		this.statement = statement;
		this.scanner = scanner;
	}

	@Override
	public void insertData() throws SQLException {
		for (int i = 0; i < 2; i++) {
			System.out.println("Enter the product number: ");
			int no = scanner.nextInt();
			scanner.nextLine(); 
			System.out.println("Enter the product name: ");
			String name = scanner.nextLine();
			System.out.println("Enter the quantity: ");
			int quantity = scanner.nextInt();
			System.out.println("Enter the price: ");
			int price = scanner.nextInt();
			String insertQuery = "INSERT INTO product3 VALUES (" + no + ", '" + name + "', " + quantity + ", " + price
					+ ")";
			System.out.println(insertQuery);
			int result = statement.executeUpdate(insertQuery);
			if (result == 0) {
				System.out.println("Failed to insert the record.");
			} else {
				System.out.println("Record inserted successfully.");
				System.out.println("-----------------------------");
			}
		}
	}
}
