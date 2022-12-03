package dbconnect;
import java.sql.*;

public class userCommon {
    private final String Driver = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://192.168.56.3:4567/db_project";
    private final String UID = "jjlee";
    private final String UPW = "root";

    private static userCommon instance;
    private userCommon(){

    }
    public static userCommon getInstance(){
        if(instance == null)
            instance = new userCommon();
        return instance;
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,UID,UPW);
    }
    public void close(AutoCloseable... autoCloseables){
        try{
            for(AutoCloseable ac: autoCloseables){
                if(ac!=null)
                    ac.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
