/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;

/**
 *
 * @author kyle
 */
public interface BasicDAO<T> {
    final int ROW_LIMIT = 100;
    List<T> getAll();
    T getById(int id);
    T getById(String id);
    void insert(T item);
}
