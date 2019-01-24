/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobs;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mahes
 */
public class DbConnection {

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = ("jdbc:mysql:///easyjobs");
            conn = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

}
