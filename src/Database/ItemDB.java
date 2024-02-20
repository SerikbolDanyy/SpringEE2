package Database;

import Connector.Item;
import jakarta.servlet.jsp.tagext.TryCatchFinally;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDB {
        private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/springEE21";
        private static final String JDBC_USER = "postgres";
        private static final String JDBC_PASSWORD = "postgre";

        public static List<Item> getAllItems() {
            List<Item> items = new ArrayList<>();

            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM items")) {

                while (resultSet.next()) {
                    Item item = new Item();
                    item.setId(resultSet.getLong("id"));
                    item.setName(resultSet.getString("name"));
                    item.setDescription(resultSet.getString("description"));
                    item.setPrice(resultSet.getDouble("price"));
                    items.add(item);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return items;
        }

    public static void addItem(Item item) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "INSERT INTO items (name, description, price) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, item.getName());
                preparedStatement.setString(2, item.getDescription());
                preparedStatement.setDouble(3, item.getPrice());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Item getItemById(long itemId) {
        Item item = null;

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?")) {

            statement.setLong(1, itemId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = new Item();
                    item.setId(resultSet.getLong("id"));
                    item.setName(resultSet.getString("name"));
                    item.setDescription(resultSet.getString("description"));
                    item.setPrice(resultSet.getDouble("price"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    public static void deleteItem(long itemId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?")) {

            statement.setLong(1, itemId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateItem(Item item) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE items SET name = ?, description = ?, price = ? WHERE id = ?")) {

            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setLong(4, item.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}