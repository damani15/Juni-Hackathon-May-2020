import com.github.cliftonlabs.json_simple.JsonException;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class InsertRecords {

    private static Connection connect() {
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


    public void insert(Integer date, String state, Integer positive, Integer death) {
        String sql = "INSERT INTO data(date, state, positive, death) VALUES(?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, date.intValue());
            pstmt.setString(2, state);
            pstmt.setInt(3, positive.intValue());
            pstmt.setInt(4, death.intValue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertAllData() throws IOException, JsonException, SQLException {
        Connection conn = connect();
        int count =0;
        Statement stmt3 = conn.createStatement();
        ResultSet rs3 = stmt3.executeQuery("SELECT COUNT(*) AS total FROM data");
        while(rs3.next()){
            count = rs3.getInt("total");
        }
        if(count == 0){
            InsertRecords app = new InsertRecords();
            JsonParser getData = new JsonParser();
            // insert three new rows
            List<Day> allData = JsonParser.getAllDays();
            Day currentDay = null;
            for (int i = 0; i < allData.size(); i++) {
                currentDay = allData.get(i);
                currentDay.checkNull();
                app.insert(currentDay.getDate(), currentDay.getState(), currentDay.getPositive(), currentDay.getDeath());
            }
        }
    }
}