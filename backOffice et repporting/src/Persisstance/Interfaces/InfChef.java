package Persisstance.Interfaces;

import Metier.BeansMetier.Chef;

import java.util.ArrayList;

public interface InfChef {

        public boolean add(Chef chef);

        public boolean delete(Chef chef);

        public boolean isExist(Chef chef);

        public Chef searchById(Object o);
        public Chef searchByCin(String cin);

        public ArrayList<Chef> getAll();

        public boolean update(Chef chef);
        public boolean chefToEmpploye(String matricule);
    }

