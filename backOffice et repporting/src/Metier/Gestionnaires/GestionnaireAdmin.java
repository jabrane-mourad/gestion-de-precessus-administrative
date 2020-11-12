package Metier.Gestionnaires;

import Metier.BeansMetier.Admin;
import Metier.BeansMetier.Employe;
import Persisstance.DaoSql.DaoSqlAdmin;
import Persisstance.DaoSql.DaoSqlEmploye;

import java.util.ArrayList;

public class GestionnaireAdmin {
    private Admin admin;
    private DaoSqlAdmin daoSqlAdmin = new DaoSqlAdmin();


    public boolean getAdmin(String matricule, String mot_de_passe) {

        if (daoSqlAdmin.isExist(matricule, mot_de_passe)) {
            admin = daoSqlAdmin.searchById(matricule);
            return true;
        }
        return false;

    }
    public String getName(String matricule) {
        return this.daoSqlAdmin.getFullNAme(matricule);
    }
    public String getFullName() {
        String fullName = admin.getNom() + " " + admin.getPrenom();
        return fullName;
    }


}
