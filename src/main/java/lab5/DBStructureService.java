package lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBStructureService {
    final String url;
    final String username;
    final String password;
    final Connection connection;
    DBStructureService(String url, String username, String password) throws SQLException, ClassNotFoundException {
        this.url = url;
        this.username = username;
        this.password = password;
        connection = getConnection();
    }
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url,username,password);
    }

    void dropAllTables() throws ClassNotFoundException, SQLException {
        String sqlStatement[] =
                {
                        "DROP TABLE IF EXISTS client",
                        "DROP TABLE IF EXISTS worker",
                        "DROP TABLE IF EXISTS officebuilding",
                        "DROP TABLE IF EXISTS human",
                        "DROP TABLE IF EXISTS building"
                };
        Statement statement = connection.createStatement();
        for (String sqlSt:sqlStatement) {
            statement.execute(sqlSt);
        }
        System.out.println("All tables removed");
    }
    void createAllTables() throws SQLException {
        String sqlStatement[]= {
        """
        CREATE TABLE JavaDB.Building (
            Id integer NOT NULL AUTO_INCREMENT,
            Adress varchar(100) NOT NULL,
            CONSTRAINT ID PRIMARY KEY CLUSTERED (Id)
        );
        """,
        """        
        CREATE TABLE JavaDB.Human (
            Id integer NOT NULL AUTO_INCREMENT,
            Name varchar(32) NOT NULL,
            Surname varchar(32) NOT NULL,
            Birthday date NOT NULL,
            CONSTRAINT ID PRIMARY KEY CLUSTERED (Id)
        );
        """,
        """        
        CREATE TABLE JavaDB.OfficeBuilding (
            Id integer NOT NULL,
            BuildingId integer,
            CONSTRAINT Id PRIMARY KEY CLUSTERED (Id),
            FOREIGN KEY (BuildingId) REFERENCES Building(Id) ON UPDATE CASCADE ON DELETE SET NULL
        );
        """ ,
        """        
        CREATE TABLE JavaDB.Worker (
            Id integer NOT NULL AUTO_INCREMENT,
            HumanId integer,
            OfficeBuildingId integer,
            CabinetNumber integer NOT NULL,
            Salary integer NOT NULL,
            CONSTRAINT ID PRIMARY KEY CLUSTERED (Id),
            FOREIGN KEY (HumanId) REFERENCES Human(Id) ON UPDATE CASCADE ON DELETE SET NULL,
            FOREIGN KEY (OfficeBuildingId) REFERENCES OfficeBuilding(Id) ON UPDATE CASCADE ON DELETE SET NULL
        );
        """,
        """        
        CREATE TABLE JavaDB.Client (
            Id integer NOT NULL AUTO_INCREMENT,
            WorkerId integer,
            HumanId integer,
            PhoneNumber integer(10) NOT NULL,
            OrderId integer NOT NULL,
            CONSTRAINT ID PRIMARY KEY CLUSTERED (Id),
            FOREIGN KEY (WorkerId) REFERENCES Worker(Id) ON UPDATE CASCADE ON DELETE SET NULL,
            FOREIGN KEY (HumanId) REFERENCES Human(Id) ON UPDATE CASCADE ON DELETE SET NULL
        );
        """
        };

        Statement statement = connection.createStatement();
        for (String sqlSt:sqlStatement) {
            statement.execute(sqlSt);
        }
        System.out.println("All tables created");
    }
}
