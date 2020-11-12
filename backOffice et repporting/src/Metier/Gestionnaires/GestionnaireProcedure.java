package Metier.Gestionnaires;

import Metier.BeansMetier.Employe;
import Metier.BeansMetier.Procedure;
import Persisstance.DaoSql.DaoSqlProcedure;

import java.util.ArrayList;

public class GestionnaireProcedure {
    private Procedure procedure=new Procedure();
    private DaoSqlProcedure daoSqlProcedure=new DaoSqlProcedure();

    public Procedure recherche(String nom) {
        return daoSqlProcedure.rechercheByNom(nom);
    }

    public ArrayList<Procedure> getProcedureAffecter(String matricule) {
        return daoSqlProcedure.getProcedureAffecter(matricule);
    }

    public ArrayList<Procedure> getProcedureLibre() {
        return daoSqlProcedure.getProcedureLibres();
    }

    public Boolean retirer(int idProcedure) {
        return daoSqlProcedure.retirer(idProcedure);
    }

    public boolean ajouter(String matricule, int idProcedure) {
        return daoSqlProcedure.affecter(matricule,idProcedure);
    }

    public ArrayList<Procedure> getListProcedure(String type) {
        ArrayList<Procedure> procedures=null;
        switch (type) {
            case "Tous":
                procedures=daoSqlProcedure.getAll();
                break;
            case "Active":
                procedures=daoSqlProcedure.getActive();
                break;
            case "Archive":
                procedures=daoSqlProcedure.getArchive();
                break;
        }
        return procedures;
    }

    public boolean archiver(int id_procedure) {
        this.procedure.setIdProcedure(id_procedure);
        return daoSqlProcedure.archiver(this.procedure);
    }

    public Boolean ajouterProcedure(Procedure procedure) {
        return daoSqlProcedure.ajouter(procedure);
    }

    public Procedure getProcedureById(int id_procedure) {
       return daoSqlProcedure.getProcedureById(id_procedure);
    }

    public boolean modifier(Procedure procedure) {
        return daoSqlProcedure.modifier(procedure);
    }
}
