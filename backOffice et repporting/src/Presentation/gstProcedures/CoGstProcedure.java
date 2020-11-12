package Presentation.gstProcedures;

import Metier.BeansMetier.Procedure;
import Metier.Gestionnaires.GestionnaireProcedure;
import Presentation.ajouterProcedure.CoAjouterProcedure;
import Presentation.ajouterProcedure.MoAjouterProcedure;
import Presentation.ajouterProcedure.VuAjouterProcedure;
import Presentation.gstEtapes.CoGstEtape;
import Presentation.gstEtapes.MoGstEtape;
import Presentation.gstEtapes.VuGstEtape;
import Presentation.modifierProcedure.CoModifierProcedure;
import Presentation.modifierProcedure.MoModifierProcedure;
import Presentation.modifierProcedure.VuModifierProcedure;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CoGstProcedure {
    private VuGstProcedure vuGstProcedure;
    private GestionnaireProcedure gestionnaireProcedure = new GestionnaireProcedure();
    private String typeAffichage = "Tous";

    public CoGstProcedure(VuGstProcedure vuGstProcedure) {
        this.vuGstProcedure = vuGstProcedure;
        this.vuGstProcedure.addboxEtatEmployeListener(new boxEtatEmployeListener());
        this.vuGstProcedure.addBtnRecherchListener(new btnRechercheListener());
        this.vuGstProcedure.addBtnbtnArchiverListener(new btnArchiverListener());
        this.vuGstProcedure.addBtnModifierListener(new btnModifierListener());
        this.vuGstProcedure.addBtnAjouterListener(new btnAjouterListener());
        this.vuGstProcedure.addBtnAnnulerListener(new btnAnnulercheListener());
        this.vuGstProcedure.addBtnGstEtapesListener(new btnGstEtapesListener());
        afficherTable();
    }

    class btnGstEtapesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id_procedure;
            try {
                id_procedure = vuGstProcedure.getIdProcedure();
                MoGstEtape moGstEtape=new MoGstEtape(id_procedure);
                VuGstEtape vuGstEtape=new VuGstEtape(moGstEtape);
                CoGstEtape coGstEtape=new CoGstEtape(vuGstEtape,moGstEtape);
                vuGstEtape.setVisible(true);

            } catch (Exception exception) {
                System.out.println(exception);
                exception.printStackTrace();
                vuGstProcedure.dsiplayErorMessage("selectionner une procedure");
            }
        }


    }

    class btnRechercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Procedure> procedures = new ArrayList<>();
            String nom = vuGstProcedure.getTextFieldrecherche().getText();
            try {
                procedures.add(gestionnaireProcedure.recherche(nom));
                vuGstProcedure.setModel(getModel(procedures));
            } catch (Exception exception) {
                vuGstProcedure.dsiplayErorMessage("not found");
                afficherTable();
            }

        }
    }

    class btnArchiverListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id_procedure;
            try {
                id_procedure = vuGstProcedure.getIdProcedure();
                if (gestionnaireProcedure.archiver(id_procedure)) {
                    afficherTable();
                } else {
                    vuGstProcedure.dsiplayErorMessage("erreur");
                    afficherTable();
                }
            } catch (Exception exception) {
                vuGstProcedure.dsiplayErorMessage("selectionner une procedure");
            }
        }
    }

    class btnModifierListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id_procedure;
            try {
                id_procedure = vuGstProcedure.getIdProcedure();
                Procedure procedure=gestionnaireProcedure.getProcedureById(id_procedure);
                MoModifierProcedure moModifierProcedure=new MoModifierProcedure(procedure);
                VuModifierProcedure vuModifierProcedure=new VuModifierProcedure(moModifierProcedure);
                CoModifierProcedure coModifierProcedure=new CoModifierProcedure(moModifierProcedure,vuModifierProcedure);
                vuModifierProcedure.setVisible(true);

            } catch (Exception exception) {
                vuGstProcedure.dsiplayErorMessage("selectionner un employé d'abord");
            }

        }
    }

    class boxEtatEmployeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Procedure> procedures = new ArrayList<>();
            JComboBox cb = (JComboBox) e.getSource();
            String type = (String) cb.getSelectedItem();
            switch (type) {
                case "Tous":
                    typeAffichage = "Tous";
                    afficherTable();
                    break;
                case "Active":
                    typeAffichage = "Active";
                    afficherTable();
                    break;
                case "Archive":
                    typeAffichage = "Archive";
                    afficherTable();
                    break;
            }


        }

    }

    class btnAjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MoAjouterProcedure moAjouterProcedure = new MoAjouterProcedure();
            VuAjouterProcedure vuAjouterProcedure = new VuAjouterProcedure(moAjouterProcedure);
            CoAjouterProcedure coAjouterProcedure = new CoAjouterProcedure(vuAjouterProcedure, moAjouterProcedure);
            vuAjouterProcedure.setVisible(true);

        }
    }

    class btnAnnulercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuGstProcedure.dispose();
        }
    }

    public DefaultTableModel getModel(ArrayList<Procedure> list) {
        DefaultTableModel localModel = (DefaultTableModel) this.vuGstProcedure.getTable().getModel();
        localModel.setRowCount(0);
        Object rowData[] = new Object[10];

        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getIdProcedure();
            rowData[1] = list.get(i).getNom();
            rowData[2] = list.get(i).getDescription();
            rowData[3] = list.get(i).getNombre_etapes();
            rowData[4] = list.get(i).getNbrDocument();
            rowData[5] = list.get(i).getMatricule();

            localModel.addRow(rowData);
        }
        return localModel;
    }

    public void afficherTable() {
        ArrayList<Procedure> procedures = new ArrayList<>();
        procedures = gestionnaireProcedure.getListProcedure(typeAffichage);
        vuGstProcedure.setModel(getModel(procedures));

    }
}
