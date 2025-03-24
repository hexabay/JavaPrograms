import java.sql.*;
import java.util.Properties;

class DBConnection {
    Connection connection = null;
    ResultSet rs;

    DBConnection() {
        if (connection == null) {
            String jdbcUrl = "jdbc:postgresql://localhost:5432/hinamiLibrary";
            String username = "postgres";
            String password = "admin123";
            try {
                connection = DriverManager.getConnection(jdbcUrl, username, password);
            } catch (Exception e) {
            }
        }
    }

    ResultSet executeSQL(String sql) {
        try {
            Statement st = connection.createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
        }
        return rs;
    }

    void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
        }
    }
}

class Library{
    String name;
    String author;

    String getBookName(){
        return name;
    }

    Library(){
        DBConnection db = new DBConnection();
        ResultSet rs;

        rs = db.executeSQL("Select name from bookdetails");
        try {
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            System.out.println(rs);
        } catch(Exception e) {}

        db.closeConnection();
    }

}
class firstSqlConnection {
    public static void main(String[] args) throws Exception{

        System.out.println("Please work!");

        Library l = new Library();

    }
}