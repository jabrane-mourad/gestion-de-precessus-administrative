package frontOfficeP1;

import frontOfficeP1.Metier.BeansMetier.Demande;
import frontOfficeP1.Persisstance.Connexion.MongoDemo;
import frontOfficeP1.Persisstance.DaoNoSql.DaoMgDemande;
import frontOfficeP1.Presentation.Auth.CoAuth;
import frontOfficeP1.Presentation.Auth.MoAuth;
import frontOfficeP1.Presentation.Auth.VuAuth;
import frontOfficeP1.Utils.PdfGenerator;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class Main {

    public static void main(String[] args) throws Exception{


        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MoAuth moAuth = new MoAuth();
        VuAuth vuAuth = new VuAuth(moAuth);
        CoAuth coAuth = new CoAuth(vuAuth, moAuth);
        vuAuth.setVisible(true);

/*        DaoMgDemande daoMgDemande=new DaoMgDemande();
        Demande demande=new Demande("p45","afi","rejected",new Date(0001,01,
                01),new Date(),3,new Date(),new Date(),false,"ddd", 12);
        daoMgDemande.addDemande(demande);*/

    }
}
