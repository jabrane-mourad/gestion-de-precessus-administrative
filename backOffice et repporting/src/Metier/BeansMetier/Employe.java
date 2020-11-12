package Metier.BeansMetier;

public class Employe extends Fonctionnaire {
    public Employe(String matricule, String cin, String nom, String prenom, String tel, String adresse, String poste,
                   String grade, int salaire, boolean archive, String motDePasse) {
        super(matricule, cin, nom, prenom, tel, adresse, poste, grade, salaire, Type.employe, archive, motDePasse);
    }
}
