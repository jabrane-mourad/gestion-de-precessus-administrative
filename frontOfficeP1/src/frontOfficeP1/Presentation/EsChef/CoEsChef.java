package frontOfficeP1.Presentation.EsChef;

import frontOfficeP1.Metier.BeansMetier.Demande;
import frontOfficeP1.Metier.BeansMetier.Procedure;
import frontOfficeP1.Metier.Gestionnaires.GesDemande;
import frontOfficeP1.Presentation.Auth.CoAuth;
import frontOfficeP1.Presentation.Auth.MoAuth;
import frontOfficeP1.Presentation.Auth.VuAuth;
import frontOfficeP1.Presentation.NouvelleDemande.CoNouvDemande;
import frontOfficeP1.Presentation.NouvelleDemande.MoNouvDemande;
import frontOfficeP1.Presentation.NouvelleDemande.VuNouvDemande;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CoEsChef {
    private MoEsChef moEsChef;
    private VuEsChef vuEsChef;
    private GesDemande gesDemande = new GesDemande();

    public CoEsChef(MoEsChef moEsChef, VuEsChef vuEsChef) {
        this.moEsChef = moEsChef;
        this.vuEsChef = vuEsChef;
        this.vuEsChef.addboxProcedureListener(new boxProcedureListener());

        this.vuEsChef.addBtnDeconnexionListener(new boxDeconnexionListener());
        this.vuEsChef.addboxEtatDemandeListener(new boxEtatDemandeListener());

        this.vuEsChef.addBtnNvDemanderListener(new btnNvDemandeListener());

        this.vuEsChef.addBtnRecherchListener(new btnRechercheListener());
        this.vuEsChef.addBtnbtnArchiverListener(new btnArchiverListener());
    }

    class btnRechercheListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String cin = vuEsChef.getCin();
                ArrayList<Demande> demandes = gesDemande.getDemandeByCin(moEsChef.getIdProcedure(), cin);
                if (demandes.size() == 0) {
                    vuEsChef.dsiplayErorMessage("Erreur: non trouvée");
                    afficherTable();
                } else {
                    vuEsChef.setModel(getModel(demandes));
                }
            } catch (Exception exception) {
                vuEsChef.dsiplayErorMessage("Erreur: non trouvée");
                afficherTable();
            }

        }
    }

    class btnArchiverListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (vuEsChef.getAvnc()=="terminé"  ||vuEsChef.getAvnc()=="rejetée"){
                try {
                    String jeton = vuEsChef.getjeton();
                    gesDemande.archiverDemande(jeton);
                    afficherTable();
                } catch (Exception exception) {
                    vuEsChef.dsiplayErorMessage("selectionner une demande");
                    System.out.println(exception);
                    exception.printStackTrace();
                }
            }else {
                vuEsChef.dsiplayErorMessage("erreur:procédure n'est pas  terminé ou rejeté");
            }


        }
    }

    class btnNvDemandeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            VuNouvDemande vuNouvDemande = new VuNouvDemande();
            MoNouvDemande moNouvDemande = new MoNouvDemande();
            CoNouvDemande coNouvDemande = new CoNouvDemande(moNouvDemande, vuNouvDemande);
            vuNouvDemande.setVisible(true);
        }
    }

    class boxProcedureListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Demande> demandes = new ArrayList<>();
            JComboBox cb = (JComboBox) e.getSource();
            String nomProcedure = (String) cb.getSelectedItem();
            getIdProcedure(nomProcedure);
            afficherTable();
        }

    }

    class boxEtatDemandeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Demande> demandes = new ArrayList<>();
            JComboBox cb = (JComboBox) e.getSource();
            String etat = (String) cb.getSelectedItem();
            if (etat.equals("active")) {
                moEsChef.setArchive(false);
                afficherTable();
            } else {
                moEsChef.setArchive(true);
                afficherTable();
            }
        }


    }

    private void afficherTable() {
        ArrayList<Demande> demandes = gesDemande.getDemandes(this.moEsChef.getIdProcedure(), this.moEsChef.isArchive());
        vuEsChef.setModel(getModel(demandes));
    }

    private void getIdProcedure(String nomProcedure) {
        for (Procedure p : moEsChef.getProcedures()) {
            if (nomProcedure.equals(p.getNom())) {
                moEsChef.setIdProcedure(p.getIdProcedure());
                moEsChef.setNombreEtape(p.getNombre_etapes());
                break;
            }
        }
    }

    class boxDeconnexionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MoAuth moAuth = new MoAuth();
            VuAuth vuAuth = new VuAuth(moAuth);
            CoAuth coAuth = new CoAuth(vuAuth, moAuth);
            vuAuth.setVisible(true);
            vuEsChef.dispose();

        }
    }

    public DefaultTableModel getModel(ArrayList<Demande> list) {
        DefaultTableModel localModel = (DefaultTableModel) this.vuEsChef.getTable().getModel();
        localModel.setRowCount(0);
        Object rowData[] = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getJeton();
            rowData[1] = list.get(i).getCin();
            rowData[2] = list.get(i).getNom();
            rowData[3] = list.get(i).getEtat_de_demande();
            rowData[4] = list.get(i).getDate_depo();
            rowData[5] = list.get(i).getDate_acceptation();
            rowData[6] = getAvencemnet(list.get(i).getEtape_actuel());
            localModel.addRow(rowData);
        }
        return localModel;
    }

    private String getAvencemnet(int etape_actuel) {
        String etatAv = "    ";
        if (etape_actuel > this.moEsChef.getNombreEtape()) {
            etatAv = "terminé";
            return etatAv;
        } else if (etape_actuel == 0) {
            etatAv = "rejetée";
            return etatAv;
        } else if (etape_actuel==this.moEsChef.getNombreEtape()){
            etatAv += " 99%";
            return etatAv;
        }{
            double prc = etape_actuel * 100 / this.moEsChef.getNombreEtape();
            etatAv += String.valueOf(prc);
            etatAv += " %";
            return etatAv;
        }
    }
}
