package Persisstance.DaoSql;

import Metier.BeansMetier.Employe;
import Persisstance.Connexion.ConnexionSql;
import Persisstance.Interfaces.InEmploye;

import java.sql.*;
import java.util.ArrayList;

public class DaoSqlEmploye implements InEmploye {
    private final Connection connection = ConnexionSql.connexion();
    @Override
    public boolean add(Employe employe) {

        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("insert into fonctionnaire values" +
                    " (?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,employe.getMatricule());
            stmt.setString(2,employe.getCin());
            stmt.setString(3,employe.getNom());
            stmt.setString(4,employe.getPrenom());
            stmt.setString(5,employe.getTel());
            stmt.setString(6,employe.getAdresse());
            stmt.setString(7,employe.getPoste());
            stmt.setString(8,employe.getGrade());
            stmt.setInt(9, employe.getSalaire());
            stmt.setString(10, String.valueOf(employe.getType()));
            stmt.setBoolean(11,employe.isArchive());
            stmt.setString(12,employe.getMotDePasse());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Employe employe) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("DELETE FROM fonctionnaire WHERE matricule = ?");
            stmt.setString(1,employe.getMatricule());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteByMatricule(String matricule) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("DELETE FROM fonctionnaire WHERE matricule = ?");
            stmt.setString(1,matricule);
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    @Override
    public boolean isExist(Employe employe) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE matricule = ?");
            stmt.setString(1, employe.getMatricule());
            ResultSet result = stmt.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Employe searchById(String matricule) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE matricule = ?");
            stmt.setString(1,matricule);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return new Employe(result.getString(1),result.getString(2),result.getString(3),
                        result.getString(4),result.getString(5),result.getString(6),
                        result.getString(7),result.getString(8),result.getInt(9),
                        result.getBoolean(11),result.getString(12));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Employe searchByCin(String cin) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE cin = ?");
            stmt.setString(1,cin);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return new Employe(result.getString(1),result.getString(2),result.getString(3),
                        result.getString(4),result.getString(5),result.getString(6),
                        result.getString(7),result.getString(8),result.getInt(9),
                        result.getBoolean(11),result.getString(12));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public ArrayList<Employe> getAll() {
        Statement stmt;
        ArrayList<Employe>employes  = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM fonctionnaire");
            while (result.next()) {
                employes.add(new Employe(result.getString(1),result.getString(2),result.getString(3),
                        result.getString(4),result.getString(5),result.getString(6),
                        result.getString(7),result.getString(8),result.getInt(9),
                        result.getBoolean(11),result.getString(12)));
            }
            return employes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Employe> getActive() {
        Statement stmt;
        ArrayList<Employe>employes  = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM fonctionnaire where est_archive=0");
            while (result.next()) {
                employes.add(new Employe(result.getString(1),result.getString(2),result.getString(3),
                        result.getString(4),result.getString(5),result.getString(6),
                        result.getString(7),result.getString(8),result.getInt(9),
                        result.getBoolean(11),result.getString(12)));
            }
            return employes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Employe> getArchive() {
        Statement stmt;
        ArrayList<Employe>employes  = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM fonctionnaire where est_archive=1");
            while (result.next()) {
                employes.add(new Employe(result.getString(1),result.getString(2),result.getString(3),
                        result.getString(4),result.getString(5),result.getString(6),
                        result.getString(7),result.getString(8),result.getInt(9),
                        result.getBoolean(11),result.getString(12)));
            }
            return employes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Employe employe) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE fonctionnaire SET " +
                    " cin= ?,nom=?,prenom= ?,tel=?,adresse= ?,poste=?,garde= ?,saliare=?,type= ?,est_archive= ?,mot_de_passe=? " +
                    "WHERE matricule = ?");
            stmt.setString(1, employe.getCin());
            stmt.setString(2, employe.getNom());
            stmt.setString(3, employe.getPrenom());
            stmt.setString(4, employe.getTel());
            stmt.setString(5, employe.getAdresse());
            stmt.setString(6, employe.getPoste());
            stmt.setString(7, employe.getGrade());
            stmt.setInt(8, employe.getSalaire());
            stmt.setString(9, String.valueOf(employe.getType()));
            stmt.setBoolean(10, employe.isArchive());
            stmt.setString(11, employe.getMotDePasse());
            stmt.setString(12, employe.getMatricule());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public Employe employeNotAdmin(String cin) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE cin = ? and type ='employe'");
            stmt.setString(1,cin);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return new Employe(result.getString(1),result.getString(2),result.getString(3),
                        result.getString(4),result.getString(5),result.getString(6),
                        result.getString(7),result.getString(8),result.getInt(9),
                        result.getBoolean(11),result.getString(12));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Employe> getJustEmployes() {
        Statement stmt;
        ArrayList<Employe>employes  = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM fonctionnaire where est_archive=0 and type='employe'");
            while (result.next()) {
                employes.add(new Employe(result.getString(1),result.getString(2),result.getString(3),
                        result.getString(4),result.getString(5),result.getString(6),
                        result.getString(7),result.getString(8),result.getInt(9),
                        result.getBoolean(11),result.getString(12)));
            }
            return employes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
