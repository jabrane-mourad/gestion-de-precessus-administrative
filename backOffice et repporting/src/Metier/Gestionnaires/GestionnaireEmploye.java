package Metier.Gestionnaires;

import Metier.BeansMetier.Employe;
import Persisstance.DaoSql.DaoSqlEmploye;

import java.util.ArrayList;

public class GestionnaireEmploye {
    private DaoSqlEmploye daoSqlEmploye = new DaoSqlEmploye();
    private Employe employe;

    public void creationEmploye(String matricule, String cin, String nom, String prenom, String tel, String adresse, String poste,
                                String grade, int salaire, String motDePasse, boolean archive) {

        this.employe = new Employe(matricule, cin, nom, prenom, tel, adresse, poste, grade, salaire, archive, motDePasse);
    }

    public boolean ajouter() {
        return daoSqlEmploye.add(this.employe);
    }

    public boolean miseAjour() {
        return daoSqlEmploye.update(this.employe);
    }

    public ArrayList<Employe> getListEmployes(String type) {
        ArrayList<Employe> employes = daoSqlEmploye.getAll();
        switch (type) {
            case "Tous":
                employes = daoSqlEmploye.getAll();
                break;
            case "Active":
                employes = daoSqlEmploye.getActive();
                break;
            case "Archive":
                employes = daoSqlEmploye.getArchive();
                break;
        }
        return employes;
    }

    public boolean deleteByMatricule(String matricule) {
        return daoSqlEmploye.deleteByMatricule(matricule);
    }

    public Employe recherche(String cin) {
        return daoSqlEmploye.searchByCin(cin);
    }

    public Employe getEmployeByMatricule(String matricule) {
        return daoSqlEmploye.searchById(matricule);
    }
}
