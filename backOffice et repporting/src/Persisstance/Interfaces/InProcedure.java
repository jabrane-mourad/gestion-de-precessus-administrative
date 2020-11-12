package Persisstance.Interfaces;


import Metier.BeansMetier.Procedure;

import java.util.ArrayList;

public interface InProcedure {
    public Boolean ajouter(Procedure procedure);

    public Boolean supprimer(Procedure procedure);

    public Boolean modifier(Procedure procedure);

    public Boolean archiver(Procedure procedure);

    public Boolean desArchiver(Procedure procedure);

    public Boolean EstArchiver(Procedure procedure);


    public ArrayList<Procedure> getProcedureLibres();
    public ArrayList<Procedure> getProcedureAffecter(String matricule);
    public Boolean affecter(String matricule,int idPrcedure);
    public Boolean retirer(int id_Procedure);

    Procedure rechercheByNom(String nom);

    ArrayList<Procedure> getAll();

    ArrayList<Procedure> getActive();

    ArrayList<Procedure> getArchive();

    Procedure getProcedureById(int id_procedure);
}
