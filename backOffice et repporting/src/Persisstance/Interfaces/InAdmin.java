package Persisstance.Interfaces;

import Metier.BeansMetier.Admin;
import Metier.BeansMetier.Employe;

public interface InAdmin {
    public boolean isExist(String matricule,String mot_de_passe);
    public Admin searchById(String matricule);
}
