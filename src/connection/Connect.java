package connection;
import java.sql.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Connect {

    private  String url="jdbc:mysql://localhost:3306/sprint1";
    public Connection  establish_connection() throws SQLException, ClassNotFoundException {

        //\connect root@localhost
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection(url,"root","fouad9111999");
        //   System.out.println("good");
        return conn;
    }
    public void read_drivers() throws SQLException, ClassNotFoundException {
        Connection conn=establish_connection();
        String query="SELECT * FROM driver";
        Statement st=conn.createStatement();
        ResultSet re=st.executeQuery(query);
        while(re.next())
        {
            System.out.println(re.getString("username"));
        }
    }

     public static void main(String[] args) {


          /////////test database
         Connect C1 = new Connect();
         try {
             C1.read_drivers() ;
         }
         catch (Exception E)
         {
             System.out.println(E);
         }
     }


}
