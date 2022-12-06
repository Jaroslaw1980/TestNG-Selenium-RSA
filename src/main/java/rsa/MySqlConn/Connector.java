package rsa.MySqlConn;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Connector {

    public static void MySqlConnector(String sqlQuery, String columnLabel) throws SQLException {
        String host = "localhost";
        String port = "3306";

        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/rsa", "root", "Password1234");
        Statement s = con.createStatement();
        // example query = "select * from users_data where product = 'ZARA COAT 3'"
        ResultSet rs = s.executeQuery(sqlQuery);

        // example column label = "user_email"
        while (rs.next())
        {
            rs.getString(columnLabel);

        }
    }
}
