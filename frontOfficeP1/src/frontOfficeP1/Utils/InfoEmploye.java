package frontOfficeP1.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import frontOfficeP1.Metier.BeansMetier.Etape;
import frontOfficeP1.Persisstance.Connexion.ConnexionSql;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InfoEmploye {
    private final Connection connection = ConnexionSql.connexion();
    private String matricule;
    private String motPass;
    private ArrayList<Etape> etapes;

    public InfoEmploye(String matricule, String motPass) {
        this.matricule = matricule;
        this.motPass = motPass;
    }

    public boolean isExist() {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM fonctionnaire WHERE matricule = ? and mot_de_passe = ?");
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

    public void getEtapes() {
        PreparedStatement stmt;
        ArrayList<Etape> etapesL = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM etape where  matricule = ?");
            stmt.setString(1, matricule);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                etapesL.add(new Etape(result.getInt(1), result.getString(2), result.getInt(3),
                        result.getInt(4), result.getString(5)));
            }
            this.etapes = etapesL;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void getJsonFile() throws IOException {
        try (Writer writer = new FileWriter("jsonFile/etape.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(this.etapes, writer);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Etape[] readJsonFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("jsonFile/etape.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        Etape[] etapes = gson.fromJson(br, Etape[].class);
        return etapes;
    }
}
