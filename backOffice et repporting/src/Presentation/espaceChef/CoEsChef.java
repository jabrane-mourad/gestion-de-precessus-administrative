package Presentation.espaceChef;

import Metier.BeansMetier.Chef;
import Metier.Gestionnaires.GestionnaireChef;
import Presentation.gstTacheChef.CoGstTacheChef;
import Presentation.ajouterChef.MoAjouterChef;
import Presentation.gstTacheChef.MoGstTacheChef;
import Presentation.ajouterChef.VuAjouterChef;
import Presentation.gstTacheChef.VuGstTacheChef;
import Presentation.ajouterChef.CoAjouterChef;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CoEsChef {
    private VuEsChef vuEsChef;
    private MoEsChef moEsChef;
    private GestionnaireChef gestionnaireChef = new GestionnaireChef();
    public CoEsChef(VuEsChef vuEsChef, MoEsChef moEsChef) {
        this.vuEsChef = vuEsChef;
        this.moEsChef = moEsChef;
        this.vuEsChef.addBtnRecherchListener(new btnRechercheListener());
        this.vuEsChef.addBtnActualiserListener(new btnActualiserListener());
        this.vuEsChef.addBtnGstTachesListener(new btnGstTachesListener());
        this.vuEsChef.addBtnAjouterListener(new btnAjouterListener());
        this.vuEsChef.addBtnRetirerListener(new btnRetirerListener());
        this.vuEsChef.addBtnAnnulerListener(new btnAnnulercheListener());
        afficherChefTable();
    }
    class btnRechercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Chef> chefs = new ArrayList<>();
            String cin = vuEsChef.getTextFieldrecherche().getText();
            try {
                chefs.add(gestionnaireChef.recherche(cin));
                vuEsChef.setModel(getModel(chefs));
            } catch (Exception exception) {
                vuEsChef.dsiplayErorMessage("not found");
                afficherChefTable();
            }

        }
    }
    class btnActualiserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            afficherChefTable();
        }
    }
    class btnGstTachesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String matricule;
            try {
                matricule = vuEsChef.getMatricule();
                MoGstTacheChef moGstTacheChef=new MoGstTacheChef(matricule);
                VuGstTacheChef vuGstTacheChef = new VuGstTacheChef();
                CoGstTacheChef coGstTacheChef=new CoGstTacheChef(moGstTacheChef,vuGstTacheChef);
                vuGstTacheChef.setVisible(true);
            } catch (Exception exception) {
                vuEsChef.dsiplayErorMessage("selectionner un employé d'abord");
            }
            afficherChefTable();
        }


    }
    class btnRetirerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String matricule;
            try {
                matricule = vuEsChef.getMatricule();
                if (gestionnaireChef.chefToEmploye(matricule)) {
                    vuEsChef.dsiplayErorMessage("l'opération s'est déroulée avec succès");

                }
            } catch (Exception exception) {
                vuEsChef.dsiplayErorMessage("selectionner un employé d'abord");
            }
            afficherChefTable();
        }
    }
    class btnAjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            VuAjouterChef vuAjouterChef = new VuAjouterChef();
            MoAjouterChef moAjouterChef = new MoAjouterChef();
            CoAjouterChef coAjouterChef = new CoAjouterChef(vuAjouterChef, moAjouterChef);
            vuAjouterChef.setVisible(true);

        }
    }
    class btnAnnulercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuEsChef.dispose();

        }
    }
    public DefaultTableModel getModel(ArrayList<Chef> list) {
        DefaultTableModel localModel = (DefaultTableModel) this.vuEsChef.getTable().getModel();
        localModel.setRowCount(0);
        Object rowData[] = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getMatricule();
            rowData[1] = list.get(i).getCin();
            rowData[2] = list.get(i).getNom();
            rowData[3] = list.get(i).getPrenom();
            rowData[4] = list.get(i).getTel();
            rowData[5] = list.get(i).getAdresse();
            rowData[6] = list.get(i).getPoste();
            rowData[7] = list.get(i).getSalaire();
            rowData[8] = list.get(i).getMotDePasse();
            rowData[9] = list.get(i).isArchive();
            localModel.addRow(rowData);
        }
        return localModel;
    }
    public void afficherChefTable() {
        ArrayList<Chef> chefs = new ArrayList<>();
        chefs = gestionnaireChef.getListAdmin();
        vuEsChef.setModel(getModel(chefs));

    }
}

