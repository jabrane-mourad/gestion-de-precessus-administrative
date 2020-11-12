package frontOfficeP1.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import frontOfficeP1.Metier.BeansMetier.Procedure;
import frontOfficeP1.Persisstance.Connexion.ConnexionSql;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InfoChef {
    private final Connection connection = ConnexionSql.connexion();
    private String matricule;
    private String motPass;
    private ArrayList<Procedure> procedures;

    public InfoChef(String matricule, String motPass) {
        this.matricule = matricule;
        this.motPass = motPass;
    }

    public boolean isExist() {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE matricule = ? and mot_de_passe = ? and type='chef' ");
            stmt.setString(1, matricule);
            stmt.setString(2, motPass);
            ResultSet result = stmt.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public void getProcedures() {
        PreparedStatement stmt;
        ArrayList<Procedure> procedures = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM procedures where est_archive=0 and matricule = ?");
            stmt.setString(1, matricule);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                procedures.add(new Procedure(result.getInt(1), result.getString(2), result.getString(3),
                        result.getInt(4), result.getBoolean(5), result.getString(6), result.getInt(7)));
            }
            this.procedures = procedures;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void getJsonFile() throws IOException {
        try (Writer writer = new FileWriter("jsonFile/procedure.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(this.procedures, writer);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Procedure[] readJsonFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("jsonFile/procedure.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        Procedure[] procedures = gson.fromJson(br, Procedure[].class);
        return procedures;
    }
}
