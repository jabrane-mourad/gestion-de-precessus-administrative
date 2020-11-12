package Persisstance.DaoSql;

import Metier.BeansMetier.Chef;
import Persisstance.Connexion.ConnexionSql;
import Persisstance.Interfaces.InfChef;

import java.sql.*;
import java.util.ArrayList;

public class DaoSqlChef implements InfChef {
        private final Connection connection = ConnexionSql.connexion();


        @Override
        public boolean add(Chef chef) {
            PreparedStatement stmt;
            try {
                stmt = connection.prepareStatement("insert into fonctionnaire values" +
                        " (?,?,?,?,?,?,?,?,?,?,?,?)");
                stmt.setString(1,chef.getMatricule());
                stmt.setString(2,chef.getCin());
                stmt.setString(3,chef.getNom());
                stmt.setString(4,chef.getPrenom());
                stmt.setString(5,chef.getTel());
                stmt.setString(6,chef.getAdresse());
                stmt.setString(7,chef.getPoste());
                stmt.setString(8,chef.getGrade());
                stmt.setInt(9, chef.getSalaire());
                stmt.setString(10, String.valueOf(chef.getType()));
                stmt.setBoolean(11,chef.isArchive());
                stmt.setString(12,chef.getMotDePasse());
                return stmt.executeUpdate() != 0;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }

        @Override
        public boolean delete(Chef chef) {
            PreparedStatement stmt;
            try {
                stmt = connection.prepareStatement("DELETE FROM fonctionnaire WHERE matricule = ?");
                stmt.setString(1,chef.getMatricule());
                return stmt.executeUpdate() != 0;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }

        @Override
        public boolean isExist(Chef chef) {
            PreparedStatement stmt;
            try {
                stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE matricule = ? and type='chef' ");
                stmt.setString(1, chef.getMatricule());
                ResultSet result = stmt.executeQuery();
                return result.next();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }

        @Override
        public Chef searchById(Object o) {
            PreparedStatement stmt;
            try {
                stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE matricule = ? and type='chef'");
                stmt.setString(1, ((Chef) o).getMatricule());
                ResultSet result = stmt.executeQuery();
                if (result.next()) {
                    return new Chef(result.getString(1),result.getString(2),result.getString(3),
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
    public Chef searchByCin(String cin) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE cin = ? and type='chef'");
            stmt.setString(1,cin);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return new Chef(result.getString(1),result.getString(2),result.getString(3),
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
        public ArrayList<Chef> getAll() {
            Statement stmt;
            ArrayList<Chef> chefs = new ArrayList<>();
            try {
                stmt = connection.createStatement();
                ResultSet result = stmt.executeQuery("SELECT * FROM fonctionnaire where type='chef'");
                while (result.next()) {
                    chefs.add(new Chef(result.getString(1),result.getString(2),result.getString(3),
                            result.getString(4),result.getString(5),result.getString(6),
                            result.getString(7),result.getString(8),result.getInt(9),
                            result.getBoolean(11),result.getString(12)));
                }
                return chefs;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

        @Override
        public boolean update(Chef chef) {
            PreparedStatement stmt;
            try {
                stmt = connection.prepareStatement("UPDATE fonctionnaire SET " +
                        " cin= ?,nom=?,prenom= ?,tel=?,adresse= ?,poste=?,grade= ?,salaire=?,type= ?,archive= ?,motDePasse=? " +
                        "WHERE matricule = ?");
                stmt.setString(1, chef.getCin());
                stmt.setString(2, chef.getNom());
                stmt.setString(3, chef.getPrenom());
                stmt.setString(4, chef.getTel());
                stmt.setString(5, chef.getAdresse());
                stmt.setString(6, chef.getPoste());
                stmt.setString(7, chef.getGrade());
                stmt.setInt(8, chef.getSalaire());
                stmt.setString(9, String.valueOf(chef.getType()));
                stmt.setBoolean(10, chef.isArchive());
                stmt.setString(11, chef.getMotDePasse());
                stmt.setString(12, chef.getMatricule());
                return stmt.executeUpdate() != 0;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }

    public boolean chefToEmpploye(String matricule) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE fonctionnaire SET  type='employe' WHERE matricule = ?");
            stmt.setString(1,matricule);
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean employeToChef(String matricule) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE fonctionnaire SET  type='chef' WHERE matricule = ?");
            stmt.setString(1,matricule);
            return stmt.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

