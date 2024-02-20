package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DatabaseConnectionTest {
        public static void main(String[] args) {
            String jdbcUrl = "jdbc:postgresql://localhost:5432/springEE21";
            String username = "postgres";
            String password = "postgre";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                System.out.println("Connection successful. Database is reachable.");
            } catch (SQLException e) {
                System.err.println("Connection failed. Check your connection parameters.");
                e.printStackTrace();
            }
            String jdbcUrl1 = "jdbc:postgresql://localhost:5432/springEE22";

            try (Connection connection1 = DriverManager.getConnection(jdbcUrl1, username, password)) {
                System.out.println("Connection successful. Database is reachable.");
            } catch (SQLException e) {
                System.err.println("Connection failed. Check your connection parameters.");
                e.printStackTrace();
            }
        }
    }
