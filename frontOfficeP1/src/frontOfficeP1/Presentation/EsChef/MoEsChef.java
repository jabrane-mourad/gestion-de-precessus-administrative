package frontOfficeP1.Presentation.EsChef;

import frontOfficeP1.Metier.BeansMetier.Procedure;

public class MoEsChef {
    private Procedure[] procedures;
    private int idProcedure;
    private boolean archive;
    private int nombreEtape;

    public MoEsChef(Procedure[] procedures) {
        this.procedures = procedures;
    }

    public Procedure[] getProcedures() {
        return procedures;
    }

    public void setProcedures(Procedure[] procedures) {
        this.procedures = procedures;
    }

    public int getIdProcedure() {
        return idProcedure;
    }

    public void setIdProcedure(int idProcedure) {
        this.idProcedure = idProcedure;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public int getNombreEtape() {
        return nombreEtape;
    }

    public void setNombreEtape(int nombreEtape) {
        this.nombreEtape = nombreEtape;
    }
}
