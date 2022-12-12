package lab5;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3306/javadb";
        String username = "root";
        String password = "Sql$$uck$";
        DBStructureService service = new DBStructureService(url,  username, password);
        service.getConnection();
        service.createAllTables();
        //service.dropAllTables();
    }
}
