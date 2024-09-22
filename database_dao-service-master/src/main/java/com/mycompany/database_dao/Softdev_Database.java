/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.database_dao;

import com.mycompany.database_dao.Helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class Softdev_Database {

    public static void main(String[] args) {
       Connection conn = null;
        String url = "jdbc:sqlite:D-Coffee.db";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been establish.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        } finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage()); 
                }
            }
        }
    }
}
