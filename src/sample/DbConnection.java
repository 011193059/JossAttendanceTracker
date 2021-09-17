package sample;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    public String date = new SimpleDateFormat("dd-MM-yyyy-HH-mm").format(new Date());
    private final String createTable = "CREATE TABLE \"" + date + "\" (id INT, data VARCHAR(100));";
    private static final int LoginTimeout = 10;

    public Connection createConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties prop = new Properties();
        System.out.println("JDBC Connector Test " + date);
        String host = "jdbc:postgresql://ec2-34-247-151-118.eu-west-1.compute.amazonaws.com:5432/d80m7e3hrbuv1s";
        String username = "fdomgisfxzhxjm";
        String password = "5550678451034b0536758e225e76b46a730785cce597812f5509eecb0186ee54";
        System.out.println("host: " + host + "\nusername: " + username + "\npassword: " + password);

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(host, username, password);
        System.out.println("CONNECTION: " + connection);
        return connection;
    }

    public String runSqlStatement() {
        String result = "";
        try {
            Statement statement = createConnection().createStatement();
            System.out.println("SQL query: " + createTable);
            statement.execute(createTable);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception occurred: " + ex);
            result = ex.getMessage();
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = ex.getMessage();
        }
        return result;
    }
}