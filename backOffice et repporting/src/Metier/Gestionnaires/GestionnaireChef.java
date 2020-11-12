package Metier.Gestionnaires;

import Metier.BeansMetier.Chef;
import Metier.BeansMetier.Employe;
import Persisstance.DaoSql.DaoSqlChef;
import Persisstance.DaoSql.DaoSqlEmploye;

import java.util.ArrayList;

public class GestionnaireChef {
    private DaoSqlChef daoSqlChef=new DaoSqlChef();
    private DaoSqlEmploye daoSqlEmploye=new DaoSqlEmploye();
    public ArrayList<Chef> getListAdmin() {
        return daoSqlChef.getAll();
    }

    public Chef recherche(String cin) {
        return daoSqlChef.searchByCin(cin);
    }

    public boolean chefToEmploye(String matricule) {
        return daoSqlChef.chefToEmpploye(matricule);
    }

    public Employe rechercheEmploye(String cin) {
        return daoSqlEmploye.employeNotAdmin(cin);
    }

    public ArrayList<Employe> getListEmployes() {
        return daoSqlEmploye.getJustEmployes();
    }

    public boolean employeToChef(String matricule) {
        return daoSqlChef.employeToChef(matricule);
    }
}
