package Presentation.modifierProcedure;

import Metier.BeansMetier.Procedure;

public class MoModifierProcedure {
    private int idProcedure;
    private String nom;
    private String description;
    private int nombreEtapes;
    private Boolean archive;
    private String matricule;
    private int nbrDocument;
    private Procedure procedure;

    public MoModifierProcedure(Procedure procedure) {
        this.procedure = procedure;
        this.idProcedure=procedure.getIdProcedure();
        this.nom=procedure.getNom();
        this.description=procedure.getDescription();
        this.nombreEtapes=procedure.getNombre_etapes();
        this.archive=procedure.isEst_archive();
        this.matricule=procedure.getMatricule();
        this.nbrDocument=procedure.getNbrDocument();
    }

    public int getIdProcedure() {
        return idProcedure;
    }

    public void setIdProcedure(int idProcedure) {
        this.idProcedure = idProcedure;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombreEtapes() {
        return nombreEtapes;
    }

    public void setNombreEtapes(int nombreEtapes) {
        this.nombreEtapes = nombreEtapes;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getMatricule() {
        return matricule;
    }

    public int getNbrDocument() {
        return nbrDocument;
    }

    public void setNbrDocument(int nbrDocument) {
        this.nbrDocument = nbrDocument;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public Procedure getProcedure() {
        this.procedure = new Procedure(this.idProcedure, this.nom, this.description, this.nombreEtapes, this.archive, this.matricule,this.nbrDocument);
        return this.procedure;
    }
}

