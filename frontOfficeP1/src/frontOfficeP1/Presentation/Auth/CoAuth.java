package frontOfficeP1.Presentation.Auth;

import frontOfficeP1.Metier.BeansMetier.Etape;
import frontOfficeP1.Metier.BeansMetier.Procedure;
import frontOfficeP1.Presentation.EsChef.CoEsChef;
import frontOfficeP1.Presentation.EsChef.MoEsChef;
import frontOfficeP1.Presentation.EsChef.VuEsChef;
import frontOfficeP1.Presentation.EsEmploye.CoEsEmploye;
import frontOfficeP1.Presentation.EsEmploye.MoEsEmploye;
import frontOfficeP1.Presentation.EsEmploye.VuEsEmploye;
import frontOfficeP1.Utils.InfoChef;
import frontOfficeP1.Utils.InfoEmploye;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CoAuth {
    private VuAuth vuAuth;
    private MoAuth moAuth;
    InfoChef infoChef;
    InfoEmploye infoEmploye;



    public CoAuth(VuAuth vuAuth, MoAuth moAuth) {

        this.vuAuth = vuAuth;
        this.moAuth = moAuth;
        this.vuAuth.addConnexionListener(new ConnexionListner());
    }

    class ConnexionListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vuAuth.setInfo();
            if (vuAuth.isChecked()) {
                if (isExistChef()) {
                    infoChef.getProcedures();
                    try {
                        infoChef.getJsonFile();
                        Procedure[] procedures=infoChef.readJsonFile();
                        reponseChef(procedures);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                } else {
                    vuAuth.dsiplayErorMessage("identifiant et/ou le mot de passe est/sont incorrect(s).");
                }
            } else {
                if (isExistEmploye()) {
                    infoEmploye.getEtapes();
                    try {
                        infoEmploye.getJsonFile();
                        Etape[] etapes=infoEmploye.readJsonFile();
                        reponseEmploye(etapes);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                } else {
                    vuAuth.dsiplayErorMessage("identifiant et/ou le mot de passe est/sont incorrect(s).");}
            }

        }
    }


    public boolean isExistChef() {
        infoChef=new InfoChef(moAuth.getMatricule(), moAuth.getMotPasse());
        return infoChef.isExist();
    }
    public boolean isExistEmploye() {
        infoEmploye=new InfoEmploye(moAuth.getMatricule(),moAuth.getMotPasse());
        return infoEmploye.isExist();
    }

    private void reponseChef(Procedure[] procedures) {
        try {
            MoEsChef moEsChef = new MoEsChef(procedures);
            VuEsChef vuEsChef = new VuEsChef(moEsChef);
            CoEsChef coEsChef = new CoEsChef(moEsChef, vuEsChef);
            vuEsChef.setVisible(true);
            this.vuAuth.dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void reponseEmploye(Etape[] etape) {
        try {
            MoEsEmploye moEsEmploye = new MoEsEmploye(etape);
            VuEsEmploye vuEsEmploye = new VuEsEmploye(moEsEmploye);
            CoEsEmploye coEsEmploye = new CoEsEmploye(moEsEmploye, vuEsEmploye);
            vuEsEmploye.setVisible(true);
            this.vuAuth.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

