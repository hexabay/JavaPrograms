import java.sql.*;

class firstSqlConnection {
    public static void main(String[] args) throws Exception{

        String jdbcUrl = "jdbc:postgresql://localhost:5432/hinamiLibrary";
        String username = "postgres";
        String password = "admin123";

        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM BookDetails");

        System.out.println("Please work!");

        while (resultSet.next())
        {
            String columnValue = resultSet.getString("name");
            System.out.println("Column Value: " + columnValue);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}