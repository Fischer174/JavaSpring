package base.example.Mod4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "Mod4";
    private final String LOGIN = "root";
    private final String PASS = "";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        if (dbConn == null || dbConn.isClosed()) {
            String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        }
        return dbConn;
    }

    public void createTables() throws SQLException, ClassNotFoundException {
        try (Statement statement = getDbConnection().createStatement()) {

            // Создание таблицы users

            String usersTable = "CREATE TABLE IF NOT EXISTS users " +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "login VARCHAR(50), " +
                    "pass VARCHAR(100))";
            statement.execute(usersTable);

            // Создание таблицы items

            String itemsTable = "CREATE TABLE IF NOT EXISTS items " +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "title VARCHAR(255), " +
                    "price DECIMAL(10, 2), " +
                    "category VARCHAR(50))";
            statement.execute(itemsTable);

            // Создание таблицы orders

            String ordersTable = "CREATE TABLE IF NOT EXISTS orders " +
                    "(order_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "user_id INT, " +
                    "item_id INT, " +
                    "FOREIGN KEY (user_id) REFERENCES users(id), " +
                    "FOREIGN KEY (item_id) REFERENCES items(id))";
            statement.execute(ordersTable);
        }
    }

    public void printOrdersForJohn() throws SQLException, ClassNotFoundException {
        String query = "SELECT u.login, i.title " +
                "FROM orders o " +
                "JOIN users u ON o.user_id = u.id " +
                "JOIN items i ON o.item_id = i.id " +
                "WHERE u.login = 'john' " +
                "ORDER BY o.item_id ASC";  // Сортировка по item_id

        try (Statement statement = getDbConnection().createStatement();
             ResultSet res = statement.executeQuery(query)) {

            System.out.println("Все заказы:");
            while (res.next()) {
                String login = res.getString("login");
                String title = res.getString("title");
                System.out.println(login + " - " + title);
            }
        }
    }
}

