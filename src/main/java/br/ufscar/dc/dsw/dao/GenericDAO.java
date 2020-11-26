package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

abstract class GenericDAO<T> {

    protected Connection connection;

    public GenericDAO() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    abstract public void insert(T t);
    
    abstract public void remove(T t);
    
    abstract public void update(T t);

    abstract List<T> listAll();
    
    protected Connection getConnection() throws SQLException{
    	return  DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "password");
    }
}