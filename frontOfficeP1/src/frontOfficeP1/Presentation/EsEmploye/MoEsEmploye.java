package frontOfficeP1.Presentation.EsEmploye;

import frontOfficeP1.Metier.BeansMetier.Etape;

public class MoEsEmploye {
    private Etape[] etapes;
    private int idEtape;
    private int idProcedure;
    private int ordre;
    private String jeton;
    private String cin;

    public MoEsEmploye(Etape[] etapes) {
        this.etapes = etapes;
    }

    public Etape[] getEtapes() {
        return etapes;
    }

    public void setEtapes(Etape[] etapes) {
        this.etapes = etapes;
    }

    public int getIdEtape() {
        return idEtape;
    }

    public void setIdEtape(int idEtape) {
        this.idEtape = idEtape;
    }

    public int getIdProcedure() {
        return idProcedure;
    }

    public void setIdProcedure(int idProcedure) {
        this.idProcedure = idProcedure;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public String getJeton() {
        return jeton;
    }

    public void setJeton(String jeton) {
        this.jeton = jeton;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCin() {
        return cin;
    }
}
