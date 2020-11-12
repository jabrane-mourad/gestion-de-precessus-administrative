package Presentation.Authentification;

import Metier.Gestionnaires.GestionnaireAdmin;
import Presentation.espaceAdmin.CoEsAdmin;
import Presentation.espaceAdmin.VuEsAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoAuth {
    private VuAuth vuAuth;
    private MoAuth moAuth;
    private GestionnaireAdmin gestionnaireAdmin;

    public CoAuth(VuAuth vuAuth, MoAuth moAuth, GestionnaireAdmin gestionnaireAdmin) {

        this.vuAuth = vuAuth;
        this.moAuth = moAuth;
        this.gestionnaireAdmin = gestionnaireAdmin;
        this.vuAuth.addConnexionListener(new ConnexionListner());
    }

    class ConnexionListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuAuth.setInfo();
            if (isExist()) {
                reponse();
            } else {
                vuAuth.dsiplayErorMessage("identifiant et/ou le mot de passe est/sont incorrect(s).");}
            }
        }


    public boolean isExist() {
        return gestionnaireAdmin.getAdmin(moAuth.getMatricule(), moAuth.getMotPasse());
    }

    private void reponse() {
        try {
            this.gestionnaireAdmin.getName(moAuth.getMatricule());
            VuEsAdmin vuEsAdmin = new VuEsAdmin();
            CoEsAdmin coEsAdmin=new CoEsAdmin(vuEsAdmin,this.gestionnaireAdmin);
            vuEsAdmin.setVisible(true);
            vuAuth.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

