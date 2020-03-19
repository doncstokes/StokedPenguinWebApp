/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stokedpenguin.webapp.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Helper to open database connection.
 * @author don
 */
public class Database {
    
    private static final String connStr = "jdbc:"
        +"mysql://"
        +"localhost:3306"
        +"/StokedPenguin?serverTimezone=UTC"
        +"&user=SpUser&password=tinaGetSomeHam"
        ;
    
    Connection conn;
    
    public Database() throws Exception {
        conn = DriverManager.getConnection(connStr);
    }
    
    public void terminate() throws Exception {
        conn.close();
    }

    public Connection getConnection() {
        return conn;
    }
}
