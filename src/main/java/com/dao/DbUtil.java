package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by abdul on 11/7/2016.
 */
public class DbUtil {
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
    }
}
