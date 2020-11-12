package Persisstance.Interfaces;

import Metier.BeansMetier.Etape;

import java.util.ArrayList;

public interface InEtape {

    public Boolean ajouterEtape(Etape etape);

    public Boolean supprimerEtape(Etape etape);

    public Boolean modifierEtape(Etape etape);


    public ArrayList<Etape> getEtapesLibres();

    public ArrayList<Etape> getEtapesAffecter(String matricule);

    public Boolean affecter(String matricule, int idEtape);

    public Boolean retirer(int idEtape);

    ArrayList<Etape> getListEtapeDeProcedure(int id_procedure);

    int nombreEtapeDeProcedure(int id_procedure);

    Etape getEtapeById(int idEtape);

    boolean miseAjour(Etape etape);

    boolean setEtapeOrdreMoins(int ordre, int idEtape);
    boolean setZeroOrde(int ordre, int idEtape);
    boolean setEtapeOrdrePlus(int ordre, int idEtape);
}
