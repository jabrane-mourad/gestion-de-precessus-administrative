package Persisstance.DaoSql;

import Metier.BeansMetier.Procedure;
import Persisstance.Connexion.ConnexionSql;
import Persisstance.Interfaces.InProcedure;

import java.sql.*;
import java.util.ArrayList;

public class DaoSqlProcedure implements InProcedure {
    private final Connection connection = ConnexionSql.connexion();

    @Override
    public Boolean ajouter(Procedure procedure) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("insert into procedures values" +
                    " (?,?,?,?,?,?,?)");
            stmt.setInt(1,procedure.getIdProcedure());
            stmt.setString(2,procedure.getNom());
            stmt.setString(3,procedure.getDescription());
            stmt.setInt(4,procedure.getNombre_etapes());
            stmt.setBoolean(5,procedure.isEst_archive());
            stmt.setString(6,procedure.getMatricule());
            stmt.setInt(7,procedure.getNbrDocument());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean supprimer(Procedure procedure) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("DELETE FROM procedures WHERE id_procedure = ?");
            stmt.setInt(1,procedure.getIdProcedure());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean modifier(Procedure procedure) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE procedures SET nom=?,description= ?,nombre_etapes=?,est_archive= ?,matricule=? , nbr_doc= ? WHERE id_procedure = ?");
            stmt.setString(1,procedure.getNom());
            stmt.setString(2,procedure.getDescription());
            stmt.setInt(3,procedure.getNombre_etapes());
            stmt.setBoolean(4,procedure.isEst_archive());
            stmt.setString(5,procedure.getMatricule());
            stmt.setInt(6,procedure.getNbrDocument());
            stmt.setInt(7,procedure.getIdProcedure());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean archiver(Procedure procedure) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE procedures SET est_archive= 1 WHERE id_procedure = ?");;
            stmt.setInt(1,procedure.getIdProcedure());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean desArchiver(Procedure procedure) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE procedures SET est_archive= 0 WHERE id_procedure = ?");;
            stmt.setInt(1,procedure.getIdProcedure());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean EstArchiver(Procedure procedure) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("select * from procedures where est_archive= 0 WHERE id_procedure = ?");
            stmt.setInt(1,procedure.getIdProcedure());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Procedure> getProcedureLibres() {
        Statement stmt;
        ArrayList<Procedure> procedures = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("select * from procedures where est_archive=0 and matricule is null");
            while (result.next()) {
                procedures.add(new Procedure(result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getBoolean(5), result.getString(6),result.getInt(7)));
            }
            return procedures;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ArrayList<Procedure> getProcedureAffecter(String matricule) {
        PreparedStatement stmt;
        ArrayList<Procedure> procedures = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM procedures where est_archive=0 and matricule = ?");
            stmt.setString(1,matricule);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                procedures.add(new Procedure(result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getBoolean(5), result.getString(6),result.getInt(7)));
            }
            return procedures;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean affecter(String matricule, int idPrcedure) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE procedures SET matricule= ? WHERE id_procedure = ?");
            stmt.setString(1,matricule);
            stmt.setInt(2,idPrcedure);
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean retirer(int idProcedure) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE procedures SET matricule= null WHERE id_procedure = ?");
            stmt.setInt(1,idProcedure);
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Procedure rechercheByNom(String nom) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM procedures WHERE nom = ?");
            stmt.setString(1,nom);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return new Procedure(result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getBoolean(5), result.getString(6),result.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Procedure> getAll() {
        PreparedStatement stmt;
        ArrayList<Procedure> procedures = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM procedures");
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                procedures.add(new Procedure(result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getBoolean(5), result.getString(6),result.getInt(7)));
            }
            return procedures;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Procedure> getActive() {
        PreparedStatement stmt;
        ArrayList<Procedure> procedures = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM procedures where est_archive=0");
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                procedures.add(new Procedure(result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getBoolean(5), result.getString(6),result.getInt(7)));
            }
            return procedures;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Procedure> getArchive() {
        PreparedStatement stmt;
        ArrayList<Procedure> procedures = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM procedures where est_archive=1");
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                procedures.add(new Procedure(result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getBoolean(5), result.getString(6),result.getInt(7)));
            }
            return procedures;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Procedure getProcedureById(int id_procedure) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM procedures WHERE id_procedure = ?");
            stmt.setInt(1,id_procedure);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return new Procedure(result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getBoolean(5), result.getString(6),result.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
