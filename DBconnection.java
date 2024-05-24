/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package Sprinkles;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author DELL
 */
public class DBconnection {
    
    static Connection con=null;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/sprinkles","root",""); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
