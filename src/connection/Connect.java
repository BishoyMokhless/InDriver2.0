package connection;
import User.User;

import java.sql.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.Executor;

public class Connect {


    public  static Connection establish_connection() throws SQLException, ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/sprint1";
        //\connect root@localhost
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection(url,"root","fouad9111999");
        //   System.out.println("good");
        return conn;
    }
    public static void read_drivers() throws SQLException, ClassNotFoundException {

        Connection conn= establish_connection();
        String query="SELECT * FROM driver";
        Statement st=conn.createStatement();
        ResultSet re=st.executeQuery(query);
        while(re.next())
        {
            System.out.println(re.getString("username"));
        }
    }
    public static void setter(String column , String rowData, User obj) throws SQLException, ClassNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        int queryResult= 0;
        String type = "";
        Connect C1 = new Connect();
        C1.establish_connection();
        if(obj.getClass().getName().equals("Driver"))
            type = "driver";
        else
            type = "client";

        String query = "update " + type + " set " + column + " = ?";
        PreparedStatement preparedStmt = C1.establish_connection().prepareStatement(query);
        preparedStmt.setString(1, rowData);
        preparedStmt.executeUpdate();
        C1.establish_connection().close();
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
