package Metier.BeansMetier;

public class Procedure {
    private int idProcedure;
    private String nom;
    private String description;
    private int nombre_etapes;
    private boolean est_archive;
    private String matricule;
    private int nbrDocument;


    public Procedure(){
        this.idProcedure = 0;
        this.nom = "";
        this.description = "";
        this.nombre_etapes =0;
        this.est_archive = false;
        this.matricule = "";


    }

    public Procedure(int idProcedure, String nom, String description, int nombre_etapes, boolean est_archive, String matricule, int nbrDocument) {
        this.idProcedure = idProcedure;
        this.nom = nom;
        this.description = description;
        this.nombre_etapes = nombre_etapes;
        this.est_archive = est_archive;
        this.matricule = matricule;
        this.nbrDocument = nbrDocument;
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

    public int getNombre_etapes() {
        return nombre_etapes;
    }

    public void setNombre_etapes(int nombre_etapes) {
        this.nombre_etapes = nombre_etapes;
    }

    public boolean isEst_archive() {
        return est_archive;
    }

    public void setEst_archive(boolean est_archive) {
        this.est_archive = est_archive;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getNbrDocument() {
        return nbrDocument;
    }

    public void setNbrDocument(int nbrDocument) {
        this.nbrDocument = nbrDocument;
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "idProcedure=" + idProcedure +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", nombre_etapes=" + nombre_etapes +
                ", est_archive=" + est_archive +
                ", matricule='" + matricule + '\'' +
                ", nbrDocument=" + nbrDocument +
                '}';
    }
}