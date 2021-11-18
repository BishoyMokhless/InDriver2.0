package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DataBaseConnect {
    public static Connection establish_connection() throws SQLException, ClassNotFoundException
    {
        String url="jdbc:mysql://localhost:3306/sprint1";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url,"root","fouad9111999");
        return connection;
    }
}
