package Metier.BeansMetier;

public class Fonctionnaire {
    private String matricule;
    private String cin;
    private String nom;
    private String prenom;
    private String tel;
    private String adresse;
    private String poste;
    private String grade;
    private int salaire;
    public enum Type{
        admin,chef,employe
    };
    private Type type;
    private boolean archive;
    private String motDePasse;

    public Fonctionnaire(String matricule, String cin, String nom, String prenom, String tel, String adresse,
                         String poste, String grade, int salaire, Type type, boolean archive, String motDePasse) {
        this.matricule = matricule;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
        this.poste = poste;
        this.grade = grade;
        this.salaire = salaire;
        this.type = type;
        this.archive = archive;
        this.motDePasse = motDePasse;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Fonctionnaire{" +
                "matricule='" + matricule + '\'' +
                ", cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", adresse='" + adresse + '\'' +
                ", poste='" + poste + '\'' +
                ", grade='" + grade + '\'' +
                ", salaire=" + salaire +
                ", type=" + type +
                ", archive=" + archive +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}
