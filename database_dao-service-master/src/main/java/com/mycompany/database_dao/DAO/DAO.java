/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.database_dao.DAO;

import com.mycompany.database_dao.model.User;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface DAO<T> {
    T get(int ID);
    List<T> getAll();
    T save(T obj);
    T update(T obj);
    int delete(T obj);
    List<T> getAll(String where,String Order);
}
