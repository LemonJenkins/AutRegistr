import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.*;

public class DataBaseUse {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    private static boolean openConection() {
        try {
            Context initcon = new InitialContext();
            Context envContext = (Context) initcon.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/user");
            connection = ds.getConnection();
            return true;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return false;
        } catch (NamingException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean closeConection() {
        try {
            resultSet.close();
            statement.close();
            connection.close();
            return true;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return false;
        }
    }

    private static boolean validLogin(String login) {
        ResultSet valid = null;
        String logInD = "select login from names where login = '" + login + "'";
        try {
            statement = connection.createStatement();
            valid = statement.executeQuery(logInD);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return true;
        }
        try{
           return valid.next();
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
            return false;
        }
    }

    public static boolean authentificate(String login, String pass) {
        String queryAut = "select Passwords from names where login = '" + login + "'";
        if (openConection()) {
            try {
                resultSet = statement.executeQuery(queryAut);
                if (resultSet.next()) {
                    String realPass = resultSet.getString("Passwords");
                    if (pass.equals(realPass)) {
                        return true;
                    }
                }
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                return false;
            } finally {
                return closeConection();
            }
        } else {
            return false;
        }
    }

    public static boolean registraited(String login, String pass) {
        int resault;
        //String queryAut = "select Passwords from names where login = '" + login + "'";
        String queryAdd = "INSERT INTO names(login, Passwords) VALUES ('" + login + "', '" + pass + "')";
        if (openConection() && !validLogin(login)) {
            try {
                statement = connection.createStatement();
                resault = statement.executeUpdate(queryAdd);
                return true;
            } catch (SQLException e) {
                System.err.println("PIZDEC 2");
                return false;
            }
        } else {
            System.out.println("AAAAAAAA PIZDEC");
            return false;
        }
    }

}
