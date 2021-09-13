import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite: Data.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS data (\n"
                + " date integer NOT NULL,\n"
                + " state text NOT NULL,\n"
                + " positive integer,\n"
                + " death integer\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
