package activity;


import java.sql.*;

public class JDBC {

    private Connection con;
    private Statement stat;
    private ResultSet result;

    public void createConnection() {
        try {
            Class.forName(ActivityHourSettings.getDbDriver());            
            con = DriverManager.getConnection(ActivityHourSettings.getDbUrl(), ActivityHourSettings.getDbUser(), ActivityHourSettings.getDbPassword());            
        } catch (Exception ex) {
        }
    }  

    public void createConnection(String driver, String url) {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url);
        } catch (Exception ex) {
        }
    }

    public void createConnection(String driver, String dataSource, String userName, String password) {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dataSource, userName, password);
        } catch (Exception ex) {
        }
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }

    public boolean updateRecord(String strSQL) throws SQLException {            
            stat = con.createStatement();

            int status = stat.executeUpdate(strSQL);
            if (status == 1) {
                return true;
            } else {
                return false;
            }
        
    }

    public ResultSet queryRecord(String strSQL) throws SQLException {                         
            stat = con.createStatement();
            result = stat.executeQuery(strSQL);
            return result;
        
    }   
    
}