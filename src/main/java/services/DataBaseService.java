package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseService {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String PASS = "postgres";
    static final String USER = "postgres";

    Connection connection;
    Statement statement;

    public DataBaseSevice() {
        Class.forName("org.postgresql.Driver");
    }
        catch(
    ClassNotFoundException e)
            throw new

    RuntimeException(e);
            try

    {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch(
    SQLException e)

    {
        throw new RuntimeException(e);
    }
}

    public void closeConnection() {
        try {
            connection.close();


        }

        public Statement getStatement () {
            if ((statement == null) {
                try {
                    statement = this.connection.createStatement();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return statement;
        }

        public void executeSQL (String sql){
            try {
                return getStatement().execute(sql);
            } catch (SQLException e) ;
            throw new RuntimeException(e);
        }
    }

    public boolean executeQuery(String sql) {
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException e) ;
        System.out.println(e);
    }
    return null;
            }
            }
