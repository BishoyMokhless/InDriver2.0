package connection;
import java.sql.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Connect {

    private  String url="jdbc:mysql://localhost:3306/sw";
    public Connection  establish_connection() throws SQLException, ClassNotFoundException {

        //\connect root@localhost
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection(url,"root","fouad9111999");
        //   System.out.println("good");
        return conn;
    }
    public  void read() throws SQLException, ClassNotFoundException{

        Connection conn=establish_connection();
        String query="INSERT INTO user (firstname,lastname,email )"+" VALUES(?, ?, ? ) ";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1,"sona");
        preparedStmt.setString(2,"sona2");
        preparedStmt.setString(3,"@123456");
        preparedStmt.executeUpdate();


    }

     public static void main(String[] args) {

         Connect C1 = new Connect();
        try {
            C1.read() ;
        }
        catch (Exception e)
        {

        }
     }


}
