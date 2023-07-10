package taskjdbc3;
import java.sql.*;

public interface DatabaseConnection {
    Connection getConnection() throws SQLException;
}