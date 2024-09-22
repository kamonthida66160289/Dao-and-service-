/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database_dao;

import com.mycompany.database_dao.model.User;
import com.mycompany.database_dao.service.UserService;

/**
 *
 * @author Asus
 */
public class TestUserService {
    public static void main(String[] args) {
        UserService userservice = new UserService();
        User user = userservice.login("1","password");
        if(user!=null){
            System.err.println("Welcome_user :" + user.getName());
        }else{
            System.out.println("Error");
                    }
                
    }
}
