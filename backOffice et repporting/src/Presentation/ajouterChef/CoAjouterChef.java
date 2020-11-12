package Presentation.ajouterChef;

import Metier.BeansMetier.Employe;
import Metier.Gestionnaires.GestionnaireChef;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CoAjouterChef {
    private VuAjouterChef vuAjouterChef;
    private MoAjouterChef moAjouterChef;
    private GestionnaireChef gestionnaireChef=new GestionnaireChef();

    public CoAjouterChef(VuAjouterChef vuAjouterChef, MoAjouterChef moAjouterChef) {
        this.vuAjouterChef = vuAjouterChef;
        this.moAjouterChef = moAjouterChef;

        this.vuAjouterChef.addBtnRecherchListener(new btnRechercheListener());
        this.vuAjouterChef.addBtnAjouterListener(new btnAjouterListener());
        this.vuAjouterChef.addBtnAnnulerListener(new btnAnnulercheListener());
        afficherChefTable();
    }

    class btnRechercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Employe> employes = new ArrayList<>();
            String cin = vuAjouterChef.getTextFieldrecherche().getText();
            try {
                employes.add(gestionnaireChef.rechercheEmploye(cin));
                vuAjouterChef.setModel(getModel(employes));
            } catch (Exception exception) {
                vuAjouterChef.dsiplayErorMessage("not found");
                afficherChefTable();
            }


        }
    }

    class btnAjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String matricule;
            try {
                matricule = vuAjouterChef.getMatricule();
                if (gestionnaireChef.employeToChef(matricule)) {
                    vuAjouterChef.dsiplayErorMessage("ton opération s'est bien passée");
                    afficherChefTable();

                } else {
                    vuAjouterChef.dsiplayErorMessage("erreur");
                    afficherChefTable();
                }
            } catch (Exception exception) {
                vuAjouterChef.dsiplayErorMessage("selectionner un employé d'abord");
                afficherChefTable();
            }

        }
    }

    class btnAnnulercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuAjouterChef.dispose();

        }
    }

    public DefaultTableModel getModel(ArrayList<Employe> list) {
        DefaultTableModel localModel = (DefaultTableModel) this.vuAjouterChef.getTable().getModel();
        localModel.setRowCount(0);
        Object rowData[] = new Object[10];

        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getMatricule();
            rowData[1] = list.get(i).getCin();
            rowData[2] = list.get(i).getNom();
            rowData[3] = list.get(i).getPrenom();
            localModel.addRow(rowData);
        }
        return localModel;
    }

    private void afficherChefTable() {
        ArrayList<Employe> employes = new ArrayList<>();
        employes = gestionnaireChef.getListEmployes();
        vuAjouterChef.setModel(getModel(employes));

    }
}
