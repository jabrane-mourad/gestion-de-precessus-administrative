package Presentation.espaceAdmin;

import Metier.Gestionnaires.GestionnaireAdmin;
import Presentation.Authentification.CoAuth;
import Presentation.Authentification.MoAuth;
import Presentation.espaceChef.CoEsChef;
import Presentation.espaceEmploe.CoEsEmploye;
import Presentation.espaceChef.MoEsChef;
import Presentation.Authentification.VuAuth;
import Presentation.espaceChef.VuEsChef;
import Presentation.espaceEmploe.VuEsEmploye;
import Presentation.gstProcedures.CoGstProcedure;
import Presentation.gstProcedures.VuGstProcedure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoEsAdmin {
    private VuEsAdmin vuEsAdmin;
    private GestionnaireAdmin gestionnaireAdmin;

    public CoEsAdmin(VuEsAdmin vuEsAdmin, GestionnaireAdmin gestionnaireAdmin) {
        this.vuEsAdmin = vuEsAdmin;
        this.gestionnaireAdmin = gestionnaireAdmin;

        this.vuEsAdmin.addGestionDesChefsListener(new btnChefsListener());
        this.vuEsAdmin.addGestionDesProceduresListener(new btnProceduresListener());
        this.vuEsAdmin.addGestionDesEmploesListener(new btnEmploesListener());
        this.vuEsAdmin.addStatistiquesListener(new btnStatistiqueLestner());
        this.vuEsAdmin.adddeconnexionListener(new btnDeconnexionLestner());
        this.vuEsAdmin.setLblNomAdmin(gestionnaireAdmin.getFullName());
    }

    class btnChefsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MoEsChef moEsChef = new MoEsChef();
            VuEsChef vuEsChef = new VuEsChef();
            CoEsChef coEsChef = new CoEsChef(vuEsChef,moEsChef);
            vuEsChef.setVisible(true);

        }
    }
    class btnProceduresListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            VuGstProcedure vuGstProcedure=new VuGstProcedure();
            CoGstProcedure coGstProcedure=new CoGstProcedure(vuGstProcedure);
            vuGstProcedure.setVisible(true);

        }
    }

    class btnEmploesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GestionnaireAdmin gestionnaireAdmin=new GestionnaireAdmin();
            VuEsEmploye vuEsEmploye=new VuEsEmploye();
            CoEsEmploye coEsEmploye=new CoEsEmploye(vuEsEmploye,gestionnaireAdmin);
            vuEsEmploye.setVisible(true);

        }
    }

    class btnStatistiqueLestner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("3");

        }
    }

    class btnDeconnexionLestner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MoAuth moAuth=new MoAuth();
            VuAuth vuAuth=new VuAuth(moAuth);
            GestionnaireAdmin admin =new GestionnaireAdmin();
            CoAuth coAuth = new CoAuth(vuAuth,moAuth,admin);
            vuAuth.setVisible(true);
            vuEsAdmin.dispose();

        }
    }
}

