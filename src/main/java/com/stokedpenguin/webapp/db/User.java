/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stokedpenguin.webapp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author don
 */
public class User {

    private int id;
    private String username;
    private String password;
    private int fmt;
    
    public static User fromUsernamePassword(String username, String password, Connection conn) throws Exception{
        User user = null;
        PreparedStatement stmnt = conn.prepareStatement(
            "SELECT * FROM User WHERE username = ? AND pw = PASSWORD(?)");
        stmnt.setString(1, username);
        stmnt.setString(2, password);
        ResultSet rslt = stmnt.executeQuery();
        if (rslt.next()) {
            user = new User();
            user.id = rslt.getInt("id");
            user.username = rslt.getString("username");
            user.password = rslt.getString("pw");
            user.fmt = rslt.getInt("fmt");
        }
        return user;
    }
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getFmt() {
        return fmt;
    }
}
