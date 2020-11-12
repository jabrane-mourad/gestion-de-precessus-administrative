

import Metier.Gestionnaires.GestionnaireAdmin;
import Presentation.Authentification.CoAuth;
import Presentation.Authentification.MoAuth;
import Presentation.Authentification.VuAuth;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MoAuth moAuth = new MoAuth();
        VuAuth vuAuth = new VuAuth(moAuth);
        GestionnaireAdmin admin = new GestionnaireAdmin();
        CoAuth coAuth = new CoAuth(vuAuth, moAuth, admin);
        vuAuth.setVisible(true);
    }

}

