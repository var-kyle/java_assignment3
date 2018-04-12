/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import transferobjects.Title;

/**
 *
 * @author kylem
 */
public interface TitleDAO extends BasicDAO<Title> {
    Title getById(int empNo);
}
