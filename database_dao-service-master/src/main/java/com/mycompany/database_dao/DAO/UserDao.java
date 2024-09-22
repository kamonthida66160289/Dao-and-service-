    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database_dao.DAO;

import com.mycompany.database_dao.Helper.DatabaseHelper;
import com.mycompany.database_dao.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class UserDao implements DAO<User>{

    @Override
    public User get(int ID) {
        User user = null;
        String sql = "SELECT * FROM User WHERE User_ID = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,ID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                user = new User();
                user.fromRS(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        ArrayList<User> list = new ArrayList();
        
        String sql = "SELECT * FROM User";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.fromRS(rs);
                
                list.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<User> getAll(String where ,String Order) {
        ArrayList<User> list = new ArrayList();
        
        String sql = "SELECT * FROM User WHERE " + where + " ORDER BY " + Order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt("User_ID"));
                user.setName(rs.getString("User_Name"));
                user.setRole(rs.getInt("User_Role"));
                user.setGender(rs.getString("User_Gender"));
                user.setPassword(rs.getString("User_Password"));
                
                list.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public User save(User obj) {
        String sql = "INSERT INTO user (User_Name , User_Gender , User_Password , User_Role)"
                + "VALUES(?,?,?,?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,obj.getName());
            stmt.setString(2,obj.getGender());
            stmt.setString(3,obj.getPassword());
            stmt.setInt(4,obj.getRole());
            stmt.executeUpdate() ;
            int ID = DatabaseHelper.getInsertID(stmt);
            obj.setID(ID);
           
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public User update(User obj) {
         String sql = "UPDATE User"
                + " SET User_Name = ? , User_Gender = ? , User_Password = ? , User_Role = ? "
                + " Where User_ID = ? ";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,obj.getName());
            stmt.setString(2,obj.getGender());
            stmt.setString(3,obj.getPassword());
            stmt.setInt(4,obj.getRole());
            stmt.setInt(5,obj.getID());
            int ret =  stmt.executeUpdate() ;
            System.err.println(ret);
            return obj;       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int delete(User obj) {
        String sql = " DELETE FROM User WHERE user_ID = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getID());
            int ret = stmt.executeUpdate();
            return ret;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }
    
    public User getByName(String name) {
        User user = null;
        String sql = "SELECT * FROM User WHERE User_Name = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                user = new User();
                user.fromRS(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
    
}
