package frontOfficeP1.Metier.BeansMetier;

import java.util.Date;

public class Demande {
    private String jeton;
    private String nom;
    private String etat_de_demande;
    private Date date_depo;
    private Date date_acceptation;
    private int etape_actuel;
    private Date date_debut;
    private Date date_fin;
    private Boolean archive;
    private String cin;
    private int id_procedure;

    public Demande(String jeton, String nom, String etat_de_demande, Date date_depo, Date date_acceptation,
                   int etape_actuel, Date date_debut, Date date_fin, Boolean archive, String cin, int id_procedure) {
        this.jeton = jeton;
        this.nom = nom;
        this.etat_de_demande = etat_de_demande;
        this.date_depo = date_depo;
        this.date_acceptation = date_acceptation;
        this.etape_actuel = etape_actuel;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.archive = archive;
        this.cin = cin;
        this.id_procedure = id_procedure;
    }

    public String getJeton() {
        return jeton;
    }

    public void setJeton(String jeton) {
        this.jeton = jeton;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEtat_de_demande() {
        return etat_de_demande;
    }

    public void setEtat_de_demande(String etat_de_demande) {
        this.etat_de_demande = etat_de_demande;
    }

    public Date getDate_depo() {
        return date_depo;
    }

    public void setDate_depo(Date date_depo) {
        this.date_depo = date_depo;
    }

    public Date getDate_acceptation() {
        return date_acceptation;
    }

    public void setDate_acceptation(Date date_acceptation) {
        this.date_acceptation = date_acceptation;
    }

    public int getEtape_actuel() {
        return etape_actuel;
    }

    public void setEtape_actuel(int etape_actuel) {
        this.etape_actuel = etape_actuel;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getId_procedure() {
        return id_procedure;
    }

    public void setId_procedure(int id_procedure) {
        this.id_procedure = id_procedure;
    }

    @Override
    public String toString() {
        return "Demande{" +
                "jeton='" + jeton + '\'' +
                ", nom='" + nom + '\'' +
                ", etat_de_demande='" + etat_de_demande + '\'' +
                ", date_depo=" + date_depo +
                ", date_acceptation=" + date_acceptation +
                ", etape_actuel=" + etape_actuel +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", archive=" + archive +
                ", cin='" + cin + '\'' +
                ", id_procedure=" + id_procedure +
                '}';
    }
}

