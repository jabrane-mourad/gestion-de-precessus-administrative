package Metier.BeansMetier;

public class Admin extends Fonctionnaire{

    public Admin(String matricule, String cin, String nom, String prenom, String tel, String adresse, String poste,
                 String grade, int salaire, boolean archive, String motDePasse) {
        super(matricule, cin, nom, prenom, tel, adresse, poste, grade, salaire, Type.admin, archive, motDePasse);
    }

}
