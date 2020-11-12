package Persisstance.DaoSql;

import Metier.BeansMetier.Etape;
import Metier.BeansMetier.Procedure;
import Persisstance.Connexion.ConnexionSql;
import Persisstance.Interfaces.InEtape;

import java.sql.*;
import java.util.ArrayList;

public class DaoSqlEtape implements InEtape {
    private final Connection connection = ConnexionSql.connexion();

    @Override
    public Boolean ajouterEtape(Etape etape) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("insert into etape (id_etape,nom,ordre,id_procedure) values (?,?,?,?)");
            stmt.setInt(1,etape.getId_etape());
            stmt.setString(2,etape.getNom());
            stmt.setInt(3,etape.getOrdre());
            stmt.setInt(4,etape.getId_procedure());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean supprimerEtape(Etape etape) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("DELETE FROM etape WHERE id_etape = ?");
            stmt.setInt(1,etape.getId_etape());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean modifierEtape(Etape etape) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE etape SET " +
                    "nom=?,ordre= ?,id_procedure= ?,matricule=? " +
                    "WHERE id_etape = ?");
            stmt.setString(1,etape.getNom());
            stmt.setInt(2,etape.getOrdre());
            stmt.setInt(3,etape.getId_procedure());
            stmt.setString(4,etape.getMatricule());
            stmt.setInt(5
                    ,etape.getId_etape());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Etape> getEtapesLibres() {
        Statement stmt;
        ArrayList<Etape> etapes = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("select * from etape where matricule is null");
            while (result.next()) {
                etapes.add(new Etape(result.getInt(1), result.getString(2),result.getInt(3),
                        result.getInt(4), result.getString(5)));
            }
            return etapes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Etape> getEtapesAffecter(String matricule) {
        PreparedStatement stmt;
        ArrayList<Etape> etapes = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM etape where  matricule = ?");
            stmt.setString(1,matricule);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                etapes.add(new Etape(result.getInt(1), result.getString(2),result.getInt(3),
                        result.getInt(4), result.getString(5)));
            }
            return etapes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean affecter(String matricule, int idEtape) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE etape SET matricule= ? WHERE id_etape = ?");
            stmt.setString(1,matricule);
            stmt.setInt(2,idEtape);
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean retirer(int idEtape) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE etape SET matricule= null WHERE id_etape = ?");
            stmt.setInt(1,idEtape);
            return stmt.executeUpdate() != 0;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public ArrayList<Etape> getListEtapeDeProcedure(int id_procedure) {
        PreparedStatement stmt;
        ArrayList<Etape> etapes = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM etape where  id_procedure = ? order by ordre");
            stmt.setInt(1,id_procedure);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                etapes.add(new Etape(result.getInt(1), result.getString(2),result.getInt(3),
                        result.getInt(4), result.getString(5)));
            }
            return etapes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int nombreEtapeDeProcedure(int id_procedure) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM etape where  id_procedure = ?");
            stmt.setInt(1,id_procedure);
            ResultSet result = stmt.executeQuery();
            result.last();
            return result.getRow();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public Etape getEtapeById(int idEtape) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM etape WHERE id_etape = ?");
            stmt.setInt(1,idEtape);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return new Etape(result.getInt(1), result.getString(2), result.getInt(3),
                        result.getInt(4), result.getString(5));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean miseAjour(Etape etape) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE etape SET " +
                    "nom=?,ordre= ?,id_procedure= ?,matricule=? " +
                    "WHERE id_etape = ?");
            stmt.setString(1,etape.getNom());
            stmt.setInt(2,etape.getOrdre());
            stmt.setInt(3,etape.getId_procedure());
            stmt.setString(4,etape.getMatricule());
            stmt.setInt(5,etape.getId_etape());
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    @Override
    public boolean setEtapeOrdreMoins(int ordre, int idEtape) {
        PreparedStatement stmt;
        int ordreM=ordre-1;
        try {
            stmt = connection.prepareStatement("UPDATE etape SET ordre= ? WHERE ordre= 0");
            stmt.setInt(1,ordreM);
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean setZeroOrde(int ordre, int idEtape){
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE etape SET ordre=0 WHERE id_etape = ? and ordre= ?");
            stmt.setInt(1,idEtape);
            stmt.setInt(2,ordre);
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean setEtapeOrdrePlus(int ordre, int idEtape) {
        PreparedStatement stmt;
        int ordreM=ordre-1;
        try {
            stmt = connection.prepareStatement("UPDATE etape SET ordre= ? WHERE ordre=?");
            stmt.setInt(1,ordre);
            stmt.setInt(2,ordreM);
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }


    public Etape recherche(String nom) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM etape WHERE nom = ?");
            stmt.setString(1,nom);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return new Etape(result.getInt(1), result.getString(2), result.getInt(3),
                        result.getInt(4), result.getString(5));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
