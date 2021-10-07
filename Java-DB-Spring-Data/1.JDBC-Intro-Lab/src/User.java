import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class User {

    private String username;
    private String password;
    private String databaseName;
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/";

    public Connection getConnection(){

        Properties connectionProps = new Properties();
        connectionProps.setProperty("user", this.username);
        connectionProps.setProperty("password", this.password);

        Connection connection = null;
        try {
             connection = DriverManager.getConnection(CONNECTION_URL + this.databaseName, connectionProps);
            System.out.println("Connected to database");
        }catch (Exception e){
            System.out.println("Connection failed.");
        }
        return connection;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }


}
