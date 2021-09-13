import java.sql.*;

public class SelectRecords {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite: Data.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public int selectPositive(int date, String state) {
        int positive = 0;
        String sql = "SELECT positive FROM data " +
                "Where date = ? AND state = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setInt(1, date);
            pstmt.setString(2, state);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                positive = rs.getInt("positive");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return positive;
    }
    public int selectDeath(int date, String state) {
        int death = 0;
        String sql = "SELECT death FROM data " +
                "Where date = ? AND state = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setInt(1, date);
            pstmt.setString(2, state);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                death = rs.getInt("death");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return death;
    }
}
