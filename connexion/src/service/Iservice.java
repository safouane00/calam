/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
/**
 *
 * @author safouane
 */
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
public interface Iservice <T>{
    void ajouter (T t)throws SQLException ;
    InputStream im();
    void update ( T t) throws SQLException;
    void supprimer (T t ) throws SQLException;
    List<T> readall() throws SQLException ;
    List<T> readall1() throws SQLException ;
    List<T> readall2() throws SQLException ;
    List<T> readall4(String mail1) throws SQLException ;
}
