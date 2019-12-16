package sample;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {
    public static void main(String[] args) {
        Database prog = new Database();
        prog.createConnection();
    }
    void createConnection(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "rajabov99j");
            System.out.println("SUCCESS!");
            Statement stmt = conn.createStatement();
            ResultSet rs =  stmt.executeQuery("SELECT * FROM USERS");
            while (rs.next())
            {
                String name = rs.getString("name_user");
                System.out.println(name);
            }

        }catch (SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
