package Persisstance.Interfaces;

import Metier.BeansMetier.Employe;

import java.util.ArrayList;

public interface InEmploye {
    public boolean add(Employe employe);

    public boolean delete(Employe employe);

    public boolean deleteByMatricule(String matricule);

    public boolean isExist(Employe employe);

    public Employe searchById(String matricule);
    public Employe searchByCin(String cin);

    public ArrayList<Employe> getAll();

    public ArrayList<Employe> getActive();

    public ArrayList<Employe> getArchive();

    public boolean update(Employe employe);
}
