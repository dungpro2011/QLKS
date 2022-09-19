package qlks.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class MyConnection {
    private String user = "root";
    private String password = "12345678";
    private String url = "jdbc:mysql://localhost:3306/quanlykhachsan?useUnicode=true&characterEncoding=UTF-8";
    private Connection connection;
    private Statement statement;
    
    public MyConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "1: "+e);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "2: "+ex);
        }
    }
    
    public ResultSet executeQuery(String query){
        try{
            statement = connection.createStatement();
            return statement.executeQuery(query);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "3: "+e);
            return null;
        }
    }
    
    public boolean executeUpdate(String query){
        try{
            statement = connection.createStatement();
            statement.executeUpdate(query);
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "4: "+e);
            return false;
        }
    }
    
    public boolean close(){
        try{
            if(connection!=null){
                connection.close();
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "5 "+e);
            return false;
        }
    }
}
