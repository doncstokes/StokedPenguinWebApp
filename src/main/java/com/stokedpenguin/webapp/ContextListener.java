/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stokedpenguin.webapp;

import com.stokedpenguin.webapp.db.Database;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author don
 */
/*
    <listener>
        <description>ServletContextListener</description>
        <listener-class>com.stokedpenguin.webapp.ContextListener</listener-class>
    </listener>
*/

@WebListener
public class ContextListener implements ServletContextListener {
    
    public static final String attrDatabase = "database";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("StokedPengin Initializing");
        try {
            Database db = new Database();
            System.out.println("StokedPengin database open");
            sce.getServletContext().setAttribute(attrDatabase, db);
        } catch (Exception e) {
            System.out.println("StokedPengin caught: " + e.toString());
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("StokedPengin Terminating");
        Database db = (Database)sce.getServletContext().getAttribute(attrDatabase);
        try {
            db.terminate();
            System.out.println("StokedPengin database closed");
        } catch (Exception e) {
            System.out.println("StokedPengin caught: " + e.toString());
            e.printStackTrace(System.err);
        }
    }
}
