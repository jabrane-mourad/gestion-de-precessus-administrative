package frontOfficeP1.Presentation.EsEmploye;

import com.itextpdf.text.DocumentException;
import frontOfficeP1.Metier.BeansMetier.Demande;
import frontOfficeP1.Metier.BeansMetier.Etape;
import frontOfficeP1.Metier.Gestionnaires.GesDemande;
import frontOfficeP1.Presentation.Auth.CoAuth;
import frontOfficeP1.Presentation.Auth.MoAuth;
import frontOfficeP1.Presentation.Auth.VuAuth;
import frontOfficeP1.Utils.PdfGenerator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class CoEsEmploye {
    private MoEsEmploye moEsEmploye;
    private VuEsEmploye vuEsEmploye;
    private GesDemande gesDemande = new GesDemande();

    public CoEsEmploye(MoEsEmploye moEsEmploye, VuEsEmploye vuEsEmploye) {
        this.moEsEmploye = moEsEmploye;
        this.vuEsEmploye = vuEsEmploye;
        this.vuEsEmploye.addboxEtapereListener(new boxEtapeListener());
        this.vuEsEmploye.addBtnTraiterListener(new traiterListener());
        this.vuEsEmploye.addBtnDeconnexionListener(new deconnexionListener());



        this.vuEsEmploye.addBtnAccepterListener(new btnAccepterListener());
        this.vuEsEmploye.addBtnMiseAjourListener(new miseAjourListener());
        this.vuEsEmploye.addBtnRefuserListener(new refuserListener());
        this.vuEsEmploye.addBtnRejeterListener(new addBtnRejeterListener());
    }

    class traiterListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String jeton=vuEsEmploye.getjeton();
                String cin=vuEsEmploye.getCin();
                vuEsEmploye.setLblJetonx(jeton);
                vuEsEmploye.setLblCinx(cin);
                moEsEmploye.setJeton(jeton);
                moEsEmploye.setCin(cin);

            }catch (Exception exception){
                vuEsEmploye.dsiplayErorMessage("selectionner une demande");
            }

        }
    }

    class btnAccepterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String jeton=moEsEmploye.getJeton();
                int ordre=moEsEmploye.getOrdre();
                String ordreS= String.valueOf(ordre);
                String rapport=vuEsEmploye.getRapport();
                gesDemande.accepter(jeton,ordre);
                generateRapport(jeton,ordreS,rapport);
                afficherTable();
            }catch (Exception exception){
                exception.printStackTrace();
            }


        }
    }

    class miseAjourListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String jeton=moEsEmploye.getJeton();
                int ordre=moEsEmploye.getOrdre();
                String ordreS= String.valueOf(ordre);
                String rapport=vuEsEmploye.getRapport();
                gesDemande.miseAjour(jeton,ordre);
                generateRapport(jeton,ordreS,rapport);
                afficherTable();
            }catch (Exception exception){
                exception.printStackTrace();
            }

        }
    }

    class refuserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String jeton=moEsEmploye.getJeton();
                int ordre=moEsEmploye.getOrdre();
                String ordreS= String.valueOf(ordre);
                String rapport=vuEsEmploye.getRapport();
                gesDemande.refuser(jeton,ordre);
                generateRapport(jeton,ordreS,rapport);
                afficherTable();
            }catch (Exception exception){
                exception.printStackTrace();
            }

        }
    }

    class addBtnRejeterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String jeton=moEsEmploye.getJeton();
                int ordre=moEsEmploye.getOrdre();
                String ordreS= String.valueOf(ordre);
                String rapport=vuEsEmploye.getRapport();
                gesDemande.rejeter(jeton,ordre);
                generateRapport(jeton,ordreS,rapport);
                afficherTable();
            }catch (Exception exception){
                exception.printStackTrace();
            }

        }
    }

    class boxEtapeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Demande> demandes = new ArrayList<>();
            JComboBox cb = (JComboBox) e.getSource();
            String nomEtape = (String) cb.getSelectedItem();
            if (setInfoIds(nomEtape)) {
                afficherTable();
            } else {
                vuEsEmploye.dsiplayErorMessage("erreur");
            }
        }

    }
    class deconnexionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MoAuth moAuth = new MoAuth();
            VuAuth vuAuth = new VuAuth(moAuth);
            CoAuth coAuth = new CoAuth(vuAuth, moAuth);
            vuAuth.setVisible(true);
            vuEsEmploye.dispose();

        }
    }
    private boolean setInfoIds(String nomEtape) {
        for (Etape e : moEsEmploye.getEtapes()) {
            if (nomEtape.equals(e.getNom())) {
                moEsEmploye.setIdEtape(e.getId_etape());
                moEsEmploye.setIdProcedure(e.getId_procedure());
                moEsEmploye.setOrdre(e.getOrdre());
                System.out.println("true");
                return true;
            }
        }
        return false;
    }
    private void afficherTable() {
        int idProcedure = this.moEsEmploye.getIdProcedure();
        int ordree = this.moEsEmploye.getOrdre();
        System.out.println("idPocedure:" + idProcedure);
        System.out.println("ordre:" + ordree);
        ArrayList<Demande> demandes = gesDemande.getDemandesOffEtape(idProcedure, ordree);
        vuEsEmploye.setModel(getModel(demandes));
    }
    public DefaultTableModel getModel(ArrayList<Demande> list) {
        DefaultTableModel localModel = (DefaultTableModel) this.vuEsEmploye.getTable().getModel();
        localModel.setRowCount(0);
        Object rowData[] = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getJeton();
            rowData[1] = list.get(i).getCin();
            rowData[2] = list.get(i).getNom();
            rowData[3] = list.get(i).getDate_acceptation();
            localModel.addRow(rowData);
        }
        return localModel;
    }
    public void generateRapport(String jeton,String ordreEtape,String rapport){
        String name=jeton+"_"+ordreEtape;
        try {
            PdfGenerator pdfGenerator=new PdfGenerator(name,rapport);
        } catch (DocumentException documentException) {
            documentException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
