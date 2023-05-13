package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project_hw","root", "");
        } catch (ClassNotFoundException | SQLException e) {
            
        }
    }
    public Connection getConnection() {
        return con;
    }
}
