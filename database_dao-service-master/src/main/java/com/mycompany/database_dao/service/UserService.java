/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database_dao.service;

import com.mycompany.database_dao.DAO.UserDao;
import com.mycompany.database_dao.model.User;

/**
 *
 * @author Asus
 */
public class UserService {
    public User login(String name,String Password){
        UserDao userdao = new UserDao();
        User user = userdao.getByName(name);
        if(user != null && user.getPassword().equals(Password)){
            return user;
        }
        return null;
    }
}
