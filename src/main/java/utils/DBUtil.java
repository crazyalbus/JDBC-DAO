package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String mySqlUser = "root";
    private static final String mySqlPwd = "password";
    private static final String mySqlCS = "jdbc:mysql://localhost:3306/JDBCDAOLab";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(mySqlCS, mySqlUser, mySqlPwd);
        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        }
        return conn;
    }

    public static void showErrorMessage(SQLException e){
        System.err.println("Error :" + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
    }

}
