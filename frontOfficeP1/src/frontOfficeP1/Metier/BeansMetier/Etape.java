package frontOfficeP1.Metier.BeansMetier;

public class Etape {
    private int id_etape;
    private String nom;
    private int ordre;
    private int id_procedure;
    private String matricule;

    public Etape(int id_etape, String nom, int ordre, int id_procedure, String matricule) {
        this.id_etape = id_etape;
        this.nom = nom;
        this.ordre = ordre;
        this.id_procedure = id_procedure;
        this.matricule = matricule;
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

    @Override
    public String toString() {
        return "Etape{" +
                "id_etape=" + id_etape +
                ", nom='" + nom + '\'' +
                ", ordre=" + ordre +
                ", id_procedure=" + id_procedure +
                ", matricule='" + matricule + '\'' +
                '}';
    }
}
