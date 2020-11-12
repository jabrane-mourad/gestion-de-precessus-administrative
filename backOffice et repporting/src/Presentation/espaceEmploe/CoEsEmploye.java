package Presentation.espaceEmploe;

import Metier.BeansMetier.Employe;
import Metier.Gestionnaires.GestionnaireAdmin;
import Metier.Gestionnaires.GestionnaireEmploye;
import Presentation.gstTacheEmploye.CoGstTacheEmploye;
import Presentation.modifierEmploye.CoModifierEmploye;
import Presentation.ajouterEmoloye.MoAjoutEmploye;
import Presentation.gstTacheEmploye.MoGstTacheEmploye;
import Presentation.modifierEmploye.MoModifierEmploye;
import Presentation.ajouterEmoloye.CoAjoutEmploye;
import Presentation.ajouterEmoloye.VuAjoutEmploye;
import Presentation.gstTacheEmploye.VuGstTacheEmploye;
import Presentation.modifierEmploye.VuModifierEmploye;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CoEsEmploye {
    private VuEsEmploye vuEsEmploye;
    private GestionnaireAdmin gestionnaireAdmin;
    private GestionnaireEmploye gestionnaireEmploye = new GestionnaireEmploye();

    public CoEsEmploye(VuEsEmploye vuEsEmploye, GestionnaireAdmin gestionnaireAdmin) {
        this.vuEsEmploye = vuEsEmploye;
        this.gestionnaireAdmin = gestionnaireAdmin;

        this.vuEsEmploye.addboxEtatEmployeListener(new boxEtatEmployeListener());
        this.vuEsEmploye.addBtnRecherchListener(new btnRechercheListener());
        this.vuEsEmploye.addBtnSupprimerListener(new btnSupprimerListener());
        this.vuEsEmploye.addBtnModifierListener(new btnModifierListener());
        this.vuEsEmploye.addBtnAjouterListener(new btnAjouterListener());
        this.vuEsEmploye.addBtnAnnulerListener(new btnAnnulercheListener());

        this.vuEsEmploye.addBtnGstTachesListener(new btnGstTachesListener());
    }
    class btnGstTachesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String matricule;
            try {
                matricule = vuEsEmploye.getMatricule();
                MoGstTacheEmploye moGstTacheEmploye=new MoGstTacheEmploye(matricule);
                VuGstTacheEmploye vuGstTacheEmploye=new VuGstTacheEmploye();
                CoGstTacheEmploye coGstTacheEmploye=new CoGstTacheEmploye(vuGstTacheEmploye,moGstTacheEmploye);
                vuGstTacheEmploye.setVisible(true);
            } catch (Exception exception) {
                vuEsEmploye.dsiplayErorMessage("selectionner un employé d'abord");
            }
        }


    }

    class btnRechercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Employe> employes = new ArrayList<>();
            String cin = vuEsEmploye.getTextFieldrecherche().getText();
            try {
                employes.add(gestionnaireEmploye.recherche(cin));
                vuEsEmploye.setModel(getModel(employes));
            } catch (Exception exception) {
                vuEsEmploye.dsiplayErorMessage("not found");
            }

        }
    }

    class btnSupprimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String matricule;
            try {
                matricule = vuEsEmploye.getMatricule();
                if (gestionnaireEmploye.deleteByMatricule(matricule)) {
                    vuEsEmploye.dsiplayErorMessage("ton opération s'est bien passée");

                } else {
                    vuEsEmploye.dsiplayErorMessage("erreur");
                }
            } catch (Exception exception) {
                vuEsEmploye.dsiplayErorMessage("selectionner un employé d'abord");
            }

        }
    }

    class btnModifierListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String matricule;
            try {
                matricule = vuEsEmploye.getMatricule();
                MoModifierEmploye moModifierEmploye = new MoModifierEmploye(matricule);
                VuModifierEmploye vuModifierEmploye = new VuModifierEmploye(moModifierEmploye);
                CoModifierEmploye coModifierEmploye = new CoModifierEmploye(vuModifierEmploye, moModifierEmploye);
                vuModifierEmploye.setVisible(true);
            }catch (Exception exception){
                vuEsEmploye.dsiplayErorMessage("selectionner un employé d'abord");
            }

        }
    }

    class boxEtatEmployeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Employe> employes = new ArrayList<>();
            JComboBox cb = (JComboBox) e.getSource();
            String type = (String) cb.getSelectedItem();
            switch (type) {
                case "Tous":
                    employes = gestionnaireEmploye.getListEmployes("Tous");
                    vuEsEmploye.setModel(getModel(employes));
                    break;
                case "Active":
                    employes = gestionnaireEmploye.getListEmployes("Active");
                    vuEsEmploye.setModel(getModel(employes));
                    break;
                case "Archive":
                    employes = gestionnaireEmploye.getListEmployes("Archive");
                    vuEsEmploye.setModel(getModel(employes));
                    break;
            }


        }

    }

    class btnAjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MoAjoutEmploye moAjoutEmploye = new MoAjoutEmploye();
            VuAjoutEmploye vuAjoutEmploye = new VuAjoutEmploye(moAjoutEmploye);
            CoAjoutEmploye coAjoutEmploye = new CoAjoutEmploye(vuAjoutEmploye, moAjoutEmploye);
            vuAjoutEmploye.setVisible(true);
        }
    }

    class btnAnnulercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuEsEmploye.dispose();

        }
    }

    public DefaultTableModel getModel(ArrayList<Employe> list) {
        DefaultTableModel localModel = (DefaultTableModel) this.vuEsEmploye.getTable().getModel();
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
}
