package Presentation.gstEtapes;

import Metier.BeansMetier.Etape;

public class MoGstEtape {
    private int id_etape;
    private String nom;
    private int ordre;
    private int id_procedure;
    private String matricule;
    private Etape etape;


    public MoGstEtape(int id_procedure) {
        this.id_procedure = id_procedure;
    }

    public MoGstEtape(Etape etape) {
        this.etape = etape;
    }

    public int getId_etape() {
        return id_etape;
    }

    public void setId_etape(int id_etape) {
        this.id_etape = id_etape;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public int getId_procedure() {
        return id_procedure;
    }

    public void setId_procedure(int id_procedure) {
        this.id_procedure = id_procedure;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Etape getEtape() {
        return new Etape(this.id_etape,this.nom,this.ordre,this.id_procedure,this.matricule);
    }
    public void setEtape(Etape etape) {
        this.id_etape=etape.getId_etape();
        this.nom=etape.getNom();
        this.ordre=etape.getOrdre();
        this.id_procedure=etape.getId_procedure();
        this.matricule=etape.getMatricule();

    }



    @Override
    public String toString() {
        return "MoGstEtape{" +
                "id_etape=" + id_etape +
                ", nom='" + nom + '\'' +
                ", ordre=" + ordre +
                ", id_procedure=" + id_procedure +
                ", matricule='" + matricule + '\'' +
                ", etape=" + etape +
                '}';
    }
}
