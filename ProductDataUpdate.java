package taskjdbc3;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class ProductDataUpdate implements DataUpdate {
	private final Statement statement;
	private final Scanner scanner;

	ProductDataUpdate(Statement statement, Scanner scanner) {
		this.statement = statement;
		this.scanner = scanner;
	}

	@Override
	public void updateRecord() throws SQLException {
		System.out.println("Enter the product number to update: ");
		int no = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the new product name: ");
		String newName = scanner.nextLine();
		System.out.println("Enter the new quantity: ");
		int newQuantity = scanner.nextInt();
		System.out.println("Enter the new price: ");
		int newPrice = scanner.nextInt();
		String updateQuery = "UPDATE product3 SET product_name = '" + newName + "', product_quantity = " + newQuantity
				+ ", product_price = " + newPrice + " WHERE product_no = " + no;
		int result = statement.executeUpdate(updateQuery);
		if (result == 0) {
			System.out.println("Failed to update the record.");
		} else {
			System.out.println("Record updated successfully.");
			System.out.println("-----------------------------");
		}
	}
}