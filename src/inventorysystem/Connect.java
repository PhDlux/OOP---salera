/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem;

/**
 *
 * @author Lance Salera
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Connect {
    Connection connect = null;
    
    public Connect() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorysystem", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createAccount(Account a) {
        Statement stmt;
        String sql;
        ResultSet rs;
        try {
            stmt = connect.createStatement();
            sql = "select * from account where username = '"+a.getUsername()+"'";
            rs = stmt.executeQuery(sql);
            if(!rs.next()) {
                sql = "insert into account values('"+a.getUsername()+"', '"+a.getPassword()+"', '"+a.getAccountType()+"')";
                stmt.executeUpdate(sql);
            } else {
                throw new IllegalArgumentException("Username already exists");
            }
            
        }catch(SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void subscribe(Subscriber s) {
        Statement stmt;
        String sql;
        ResultSet rs;
        try {
            stmt = connect.createStatement();
            sql = "select * from subscriber where subscriptionID = '"+s.getSubscriptionID()+"'";
            rs = stmt.executeQuery(sql);
            if(!rs.next()) {
                sql = "insert into subscriber (username, subscriptionType, subscriptionPeriod) values('"+s.getUsername()+"', '"+s.getSubscriptionType()+"', "+s.getSubscriptionPeriod()+")";
                stmt.executeUpdate(sql);
            } else {
                throw new IllegalArgumentException("ID already exists");
            }
            
        }catch(SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
