package Presentation.gstEtapes;

import Metier.BeansMetier.Etape;
import Metier.Gestionnaires.GestionnaireEtape;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CoGstEtape {
    private VuGstEtape vuGstEtape;
    private MoGstEtape moGstEtape;
    private GestionnaireEtape gestionnaireEtape = new GestionnaireEtape();
    private Boolean ajouter = true;

    public CoGstEtape(VuGstEtape vuGstEtape, MoGstEtape moGstEtape) {
        this.vuGstEtape = vuGstEtape;
        this.moGstEtape = moGstEtape;
        this.vuGstEtape.IdEtapeRE1(new idEtapeRE1Listner());
        this.vuGstEtape.IdnomRE2(new nomRE2Listner());
        this.vuGstEtape.addBtnRecherchListener(new btnRechercheListener());

        this.vuGstEtape.addBtnAjouterListener(new btnAjouterListener());
        this.vuGstEtape.addBtnModifierListener(new btnModifierListener());


        this.vuGstEtape.addBtnUpliserListener(new btnUpListener());
        this.vuGstEtape.addBtnSupprimerListener(new btnSupprimerListener());
        this.vuGstEtape.addBtnAnnulerListener(new btnAnnullerListener());

        afficherTable();
    }

    class btnUpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int ordre = vuGstEtape.getOrder();
                int idEtape = vuGstEtape.getEtape();
                if (ordre != 1) {
                    if (gestionnaireEtape.setOrdreEtape(ordre, idEtape)){
                        afficherTable();
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                vuGstEtape.dsiplayErorMessage("selectionner une etape");
            }
        }
    }



    class btnAjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (ajouter) {
                System.out.println("ajouter");
                int nbrEtapes = gestionnaireEtape.getNombreEtapes(moGstEtape.getId_procedure());
                moGstEtape.setOrdre(nbrEtapes + 1);
                vuGstEtape.setInfo2();
                if (gestionnaireEtape.ajouterEtape(moGstEtape.getEtape())) {
                    afficherTable();
                }
                ;
            } else {
                vuGstEtape.setInfo();
                if (gestionnaireEtape.miseAjour(moGstEtape.getEtape())) {
                    System.out.println(moGstEtape.getEtape());
                    vuGstEtape.dsiplayErorMessage("L'opération s'est bien déroulée");
                    vuGstEtape.setZero();
                    ajouter = true;
                    afficherTable();
                } else {
                    vuGstEtape.dsiplayErorMessage("erreur");
                }

            }
        }
    }

    class btnSupprimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int idEtape;
            try {
                idEtape = vuGstEtape.getEtape();
                if (gestionnaireEtape.supprimer(idEtape)) {
                    afficherTable();
                } else {
                    vuGstEtape.dsiplayErorMessage("erreur");
                    afficherTable();
                }
            } catch (Exception exception) {
                vuGstEtape.dsiplayErorMessage("selectionner une etape");
            }
        }
    }

    class btnModifierListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                vuGstEtape.setInfoFormulaire();
                moGstEtape.setEtape(gestionnaireEtape.getEtapeById(vuGstEtape.getidEtape()));
                ajouter = false;

            } catch (Exception exception) {
                vuGstEtape.dsiplayErorMessage("selectionner une etape");
            }
        }
    }


    class btnRechercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Etape> etapes = new ArrayList<>();
            String nom = vuGstEtape.getTextFieldrecherche().getText();
            try {
                etapes.add(gestionnaireEtape.recherche(nom));
                vuGstEtape.setModel(getModel(etapes));
            } catch (Exception exception) {
                vuGstEtape.dsiplayErorMessage("not found");
                afficherTable();
            }

        }
    }

    class btnAnnullerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuGstEtape.dispose();

        }
    }

    public DefaultTableModel getModel(ArrayList<Etape> list) {
        DefaultTableModel localModel = (DefaultTableModel) this.vuGstEtape.getTable().getModel();
        localModel.setRowCount(0);
        Object rowData[] = new Object[10];

        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getId_etape();
            rowData[1] = list.get(i).getNom();
            rowData[2] = list.get(i).getOrdre();

            localModel.addRow(rowData);
        }
        return localModel;
    }

    public void afficherTable() {
        ArrayList<Etape> etapes = new ArrayList<>();
        int id_procedure = moGstEtape.getId_procedure();
        etapes = gestionnaireEtape.getListEtapeDeProcedure(id_procedure);
        vuGstEtape.setModel(getModel(etapes));

    }


    class idEtapeRE1Listner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                int i = vuGstEtape.getidEtape();
                vuGstEtape.resetLabel(1);

            } catch (Exception exception) {
                vuGstEtape.afficherErreur(1);

            }

        }

    }

    class nomRE2Listner extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            try {
                String nom = vuGstEtape.getdNom();
                if (nom.length() < 9) {
                    vuGstEtape.resetLabel(2);
                } else {
                    vuGstEtape.afficherErreur(2);
                }

            } catch (Exception exception) {
                vuGstEtape.afficherErreur(2);

            }

        }

    }
}
