package taskjdbc3;

import java.sql.SQLException;
import java.sql.Statement;

class ProductTableCreation implements TableCreation {
	private final Statement statement;

	ProductTableCreation(Statement statement) {
		this.statement = statement;
	}

	@Override
	public void createTable() throws SQLException {
		String createTableQuery = "CREATE TABLE product3 (product_no INT, product_name VARCHAR(50), product_quantity INT, product_price INT)";
		statement.executeUpdate(createTableQuery);
		System.out.println("Table 'product3' created successfully.");
		System.out.println("-----------------------------");
	}
}