package Presentation.gstTacheChef;

import Metier.BeansMetier.Procedure;
import Metier.Gestionnaires.GestionnaireProcedure;


import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CoGstTacheChef {
    private MoGstTacheChef moGstTacheChef;
    private VuGstTacheChef vuGstTacheChef;
    private GestionnaireProcedure gestionnaireProcedure = new GestionnaireProcedure();

    public CoGstTacheChef(MoGstTacheChef moGstTacheChef, VuGstTacheChef vuGstTacheChef) {
        this.moGstTacheChef = moGstTacheChef;
        this.vuGstTacheChef = vuGstTacheChef;
        this.vuGstTacheChef.addBtnRecherchListener(new btnRechercheListener());
        this.vuGstTacheChef.addBtnSupprimerListener(new btnSupprimerListener());
        this.vuGstTacheChef.addBtnAjouterListener(new btnAjouterListener());
        this.vuGstTacheChef.addBtnAnnulerListener(new btnAnnulercheListener());
        afficherTable();
    }

    class btnRechercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Procedure> procedures = new ArrayList<>();
            String nom = vuGstTacheChef.getTextFieldrecherche().getText();
            try {
                Procedure procedure = gestionnaireProcedure.recherche(nom);
                procedures.add(procedure);
                if (procedure.getMatricule() == null) {
                    vuGstTacheChef.setModel2(getModel2(procedures));
                } else if (procedure.getMatricule().equals(moGstTacheChef.getMatricule())) {
                    vuGstTacheChef.setModel(getModel(procedures));
                }
            } catch (Exception exception) {
                vuGstTacheChef.dsiplayErorMessage("not found");
                afficherTable();
            }

        }
    }

    class btnSupprimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int idProcedure;
            try {
                idProcedure = vuGstTacheChef.getIdProcedureAffecter();
                if (gestionnaireProcedure.retirer(idProcedure)) {
                    afficherTable();
                }
            } catch (Exception exception) {
                System.out.println(exception);
                vuGstTacheChef.dsiplayErorMessage("selectionner une procedure");
            }


        }
    }

    class btnAjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int idProcedure;
            try {
                idProcedure = vuGstTacheChef.getIdProcedurelibre();
                if (gestionnaireProcedure.ajouter(moGstTacheChef.getMatricule(), idProcedure)) {
                    afficherTable();
                }
            } catch (Exception exception) {
                System.out.println(exception);
                vuGstTacheChef.dsiplayErorMessage("selectionner une procedure");
            }
        }
    }

    class btnAnnulercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuGstTacheChef.dispose();

        }
    }

    public DefaultTableModel getModel(ArrayList<Procedure> list) {
        DefaultTableModel localModel = (DefaultTableModel) this.vuGstTacheChef.getTable().getModel();
        localModel.setRowCount(0);
        Object rowData[] = new Object[10];

        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getIdProcedure();
            rowData[1] = list.get(i).getNom();
            rowData[2] = list.get(i).getDescription();
            rowData[3] = list.get(i).getNombre_etapes();

            localModel.addRow(rowData);
        }
        return localModel;
    }

    public DefaultTableModel getModel2(ArrayList<Procedure> list) {
        DefaultTableModel localModel = (DefaultTableModel) this.vuGstTacheChef.getTable2().getModel();
        localModel.setRowCount(0);
        Object rowData[] = new Object[10];

        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getIdProcedure();
            rowData[1] = list.get(i).getNom();
            rowData[2] = list.get(i).getDescription();
            rowData[3] = list.get(i).getNombre_etapes();

            localModel.addRow(rowData);
        }
        return localModel;
    }

    private void afficherTable() {
        ArrayList<Procedure> proceduresAffectees = gestionnaireProcedure.getProcedureAffecter(moGstTacheChef.getMatricule());
        ArrayList<Procedure> proceduresLibres = gestionnaireProcedure.getProcedureLibre();
        vuGstTacheChef.setModel(getModel(proceduresAffectees));
        vuGstTacheChef.setModel2(getModel2(proceduresLibres));

    }
}
