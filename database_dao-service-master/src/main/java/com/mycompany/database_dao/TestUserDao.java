/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database_dao;

import com.mycompany.database_dao.DAO.UserDao;
import com.mycompany.database_dao.Helper.DatabaseHelper;
import com.mycompany.database_dao.model.User;

/**
 *
 * @author Asus
 */
public class TestUserDao {
        public static void main(String[] args) {
        UserDao userdao = new UserDao();
        User user1 = userdao.get(3);
        //User Newuser = new User("user3","password",1,"M");
        for(User u: userdao.getAll()){
           System.err.println(u);
        }
        
        //User InsertedUser = userdao.save(Newuser);
        //System.out.println(InsertedUser);
        
        //InsertedUser.setGender("M");
        //user1.setGender("F");
        //userdao.update(user1);
        //User Updateuser = userdao.get(user1.getID());
        //System.err.println(Updateuser);
        
        //userdao.delete(user1);
        //for(User u: userdao.getAll()){
        //   System.err.println(u);
        //}
        for(User u: userdao.getAll("User_Name like 'u%' ", "User_name asc , User_Gender desc ")){
           System.err.println(u);
        }
    }
}

