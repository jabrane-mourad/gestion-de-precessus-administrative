package Persisstance.DaoSql;

import Metier.BeansMetier.Admin;
import Metier.BeansMetier.Chef;
import Persisstance.Connexion.ConnexionSql;
import Persisstance.Interfaces.InAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoSqlAdmin implements InAdmin {
    private final Connection connection = ConnexionSql.connexion();

    @Override
    public boolean isExist(String matricule, String mot_de_passe) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE matricule = ? and mot_de_passe = ? and type='admin' ");
            stmt.setString(1, matricule);
            stmt.setString(2, mot_de_passe);
            ResultSet result = stmt.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Admin searchById(String matricule) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE matricule = ?");
            stmt.setString(1,matricule);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return new Admin(result.getString(1),result.getString(2),result.getString(3),
                        result.getString(4),result.getString(5),result.getString(6),
                        result.getString(7),result.getString(8),result.getInt(9),
                        result.getBoolean(11),result.getString(12));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String getFullNAme(String matricule) {
        PreparedStatement stmt;
        String fullNAme="";
        try {
            stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE matricule = ? ");
            stmt.setString(1, matricule);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                fullNAme=result.getString(3)+" "+result.getString(4);
                return fullNAme;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    return null;}
}
