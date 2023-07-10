package taskjdbc3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class ProductDataRetrieval implements DataRetrieval {
	private final Statement statement;

	ProductDataRetrieval(Statement statement) {
		this.statement = statement;
	}

	@Override
	public void retrieveAllRecords() throws SQLException {
		String selectQuery = "SELECT * FROM product3";
		ResultSet resultSet = statement.executeQuery(selectQuery);
		while (resultSet.next()) {
			int no = resultSet.getInt("product_no");
			String name = resultSet.getString("product_name");
			int quantity = resultSet.getInt("product_quantity");
			int price = resultSet.getInt("product_price");
			System.out
					.println("Product No: " + no + ", Name: " + name + ", Quantity: " + quantity + ", Price: " + price);
		}
		resultSet.close();
	}

	@Override
	public void retrieveOneRecord() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the product number to retrieve: ");
		int no = scanner.nextInt();
		String selectQuery = "SELECT * FROM product3 WHERE product_no = " + no;
		ResultSet resultSet = statement.executeQuery(selectQuery);
		if (resultSet.next()) {
			String name = resultSet.getString("product_name");
			int quantity = resultSet.getInt("product_quantity");
			int price = resultSet.getInt("product_price");
			System.out
					.println("Product No: " + no + ", Name: " + name + ", Quantity: " + quantity + ", Price: " + price);
		} else {
			System.out.println("Record not found.");
			System.out.println("-----------------------------");
		}
		resultSet.close();
	}
}