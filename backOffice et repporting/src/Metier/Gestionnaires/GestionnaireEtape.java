package Metier.Gestionnaires;

import Metier.BeansMetier.Etape;
import Persisstance.DaoSql.DaoSqlEtape;

import java.util.ArrayList;

public class GestionnaireEtape {
    private Etape etape = new Etape(0);
    DaoSqlEtape daoSqlEtape = new DaoSqlEtape();

    public ArrayList<Etape> getEtapesAffecter(String matricule) {
        return daoSqlEtape.getEtapesAffecter(matricule);
    }

    public ArrayList<Etape> getEtapesLibre() {
        return daoSqlEtape.getEtapesLibres();
    }

    public boolean ajouter(String matricule, int idEtape) {
        return daoSqlEtape.affecter(matricule, idEtape);
    }

    public boolean retirer(int idEtape) {
        return daoSqlEtape.retirer(idEtape);
    }

    public Etape recherche(String nom) {
        return daoSqlEtape.recherche(nom);
    }

    public ArrayList<Etape> getListEtapeDeProcedure(int id_procedure) {
        return daoSqlEtape.getListEtapeDeProcedure(id_procedure);
    }

    public boolean supprimer(int idEtape) {
        this.etape.setId_etape(idEtape);
        return daoSqlEtape.supprimerEtape(this.etape);
    }

    public int getNombreEtapes(int id_procedure) {
        return daoSqlEtape.nombreEtapeDeProcedure(id_procedure);
    }

    public boolean ajouterEtape(Etape etape) {
        return daoSqlEtape.ajouterEtape(etape);
    }

    public Etape getEtapeById(int idEtape) {
        return daoSqlEtape.getEtapeById(idEtape);
    }

    public boolean miseAjour(Etape etape) {
        return daoSqlEtape.miseAjour(etape);
    }

    public boolean setOrdreEtape(int ordre, int idEtape) {
        try {
            daoSqlEtape.setZeroOrde(ordre, idEtape);
            daoSqlEtape.setEtapeOrdrePlus(ordre, idEtape);
            daoSqlEtape.setEtapeOrdreMoins(ordre, idEtape);
            return true;
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return false;
    }
}
