package ru.job4j.inputoutput;

//import jdk.internal.jline.internal.Log;

import java.sql.*;

public class SqlTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/items";
        String username = "postgres";
        String password = "Password";
        Connection conn = null;
        try {
            //Class.forName("org.postgresql.Driver");
            conn =  DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from car_body" );
while (rs.next()) {
    System.out.println(String.format(rs.getString("name_car_body")) );
}
rs.close();
st.close();

        } catch (Exception e) {
           // Log.error(e.getMessage(), e);
            System.out.println(e.getMessage());
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    //Log.error(e.getMessage(), e);
                    System.out.println(e.getMessage());
                }

            }
        }
    }
}
