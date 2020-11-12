package Metier.BeansMetier;

public class Chef extends Fonctionnaire{

    public Chef(String matricule, String cin, String nom, String prenom, String tel, String adresse, String psote,
                String grade, int salaire, boolean archive, String motDePasse) {
        super(matricule, cin, nom, prenom, tel, adresse, psote, grade, salaire, Type.chef, archive, motDePasse);
    }


}

