package Presentation.gstTacheEmploye;

import Metier.BeansMetier.Etape;
import Metier.Gestionnaires.GestionnaireEtape;
import Presentation.gstTacheEmploye.MoGstTacheEmploye;
import Presentation.gstTacheEmploye.VuGstTacheEmploye;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CoGstTacheEmploye {
    private VuGstTacheEmploye vuGstTacheEmploye;
    private MoGstTacheEmploye moGstTacheEmploye;
    private GestionnaireEtape gestionnaireEtape=new GestionnaireEtape();

    public CoGstTacheEmploye(VuGstTacheEmploye vuGstTacheEmploye, MoGstTacheEmploye moGstTacheEmploye) {
        this.vuGstTacheEmploye = vuGstTacheEmploye;
        this.moGstTacheEmploye = moGstTacheEmploye;

        this.vuGstTacheEmploye.addBtnRecherchListener(new btnRechercheListener());
        this.vuGstTacheEmploye.addBtnSupprimerListener(new btnSupprimerListener());
        this.vuGstTacheEmploye.addBtnAjouterListener(new btnAjouterListener());
        this.vuGstTacheEmploye.addBtnAnnulerListener(new btnAnnulercheListener());
        afficherTable();
    }

    class btnRechercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Etape> etapes = new ArrayList<>();
            String nom = vuGstTacheEmploye.getTextFieldrecherche().getText();
            try {
                Etape etape = gestionnaireEtape.recherche(nom);
                etapes.add(etape);
                if (etape.getMatricule() == null) {
                    vuGstTacheEmploye.setModel2(getModel2(etapes));
                } else if (etape.getMatricule().equals(moGstTacheEmploye.getMatricule())) {
                    vuGstTacheEmploye.setModel(getModel(etapes));
                }
            } catch (Exception exception) {
                vuGstTacheEmploye.dsiplayErorMessage("not found");
                afficherTable();
            }

        }
    }

    class btnSupprimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int idEtape;
            try {
                idEtape = vuGstTacheEmploye.getIdEtapeAffecter();
                if (gestionnaireEtape.retirer(idEtape)) {
                    afficherTable();
                }
            } catch (Exception exception) {
                vuGstTacheEmploye.dsiplayErorMessage("selectionner une etape");
            }


        }
    }

    class btnAjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int idEtape;
            try {
                idEtape = vuGstTacheEmploye.getIdEtapelibre();
                if (gestionnaireEtape.ajouter(moGstTacheEmploye.getMatricule(), idEtape)) {
                    System.out.println(idEtape);
                    afficherTable();
                }
            } catch (Exception exception) {
                vuGstTacheEmploye.dsiplayErorMessage("selectionner une etape");
            }
        }
    }

    class btnAnnulercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuGstTacheEmploye.dispose();

        }
    }

    public DefaultTableModel getModel(ArrayList<Etape> list) {
        DefaultTableModel localModel = (DefaultTableModel) this.vuGstTacheEmploye.getTable().getModel();
        localModel.setRowCount(0);
        Object rowData[] = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getId_etape();
            rowData[1] = list.get(i).getNom();
            rowData[2] = list.get(i).getOrdre();
            rowData[3] = list.get(i).getId_procedure();
            localModel.addRow(rowData);
        }
        return localModel;
    }

    public DefaultTableModel getModel2(ArrayList<Etape> list) {
        DefaultTableModel localModel = (DefaultTableModel) this.vuGstTacheEmploye.getTable2().getModel();
        localModel.setRowCount(0);
        Object rowData[] = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getId_etape();
            rowData[1] = list.get(i).getNom();
            rowData[2] = list.get(i).getOrdre();
            rowData[3] = list.get(i).getId_procedure();
            localModel.addRow(rowData);
        }
        return localModel;
    }

    private void afficherTable() {
        ArrayList<Etape> etapesAffecter = gestionnaireEtape.getEtapesAffecter(moGstTacheEmploye.getMatricule());
        ArrayList<Etape> EtapesLibres = gestionnaireEtape.getEtapesLibre();
        vuGstTacheEmploye.setModel(getModel(etapesAffecter));
        vuGstTacheEmploye.setModel2(getModel2(EtapesLibres));

    }
}
