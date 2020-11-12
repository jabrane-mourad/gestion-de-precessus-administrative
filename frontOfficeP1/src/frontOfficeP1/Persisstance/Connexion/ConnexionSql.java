package frontOfficeP1.Persisstance.Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionSql {
    private static final String JdbcDriver = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/gst_procedureDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "mourad@XJ123";
    private static ConnexionSql connexionSql;
    private static Connection connection;

    public ConnexionSql() {
        try {
            Class.forName(JdbcDriver);
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Impossible d'enregistrer le pilote jdbc:" + e.getMessage());
            System.exit(1);
        } catch (SQLException e) {
            System.out.println("Impossible d'obtenir la connexion DB");
            System.exit(1);
        }
    }

    public static Connection connexion() {
        if (connexionSql == null)
            connexionSql = new ConnexionSql();
        return connection;
    }
}
