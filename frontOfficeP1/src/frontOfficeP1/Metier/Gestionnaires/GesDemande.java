package frontOfficeP1.Metier.Gestionnaires;

import frontOfficeP1.Metier.BeansMetier.Demande;
import frontOfficeP1.Persisstance.DaoNoSql.DaoMgDemande;

import java.util.ArrayList;

public class GesDemande {
    private DaoMgDemande daoMgDemande = new DaoMgDemande();


    public ArrayList<Demande> getDemandes(int idProcedure, boolean archive) {
        if (archive) {
            return daoMgDemande.getDemandesArchive(idProcedure);
        } else {
            return daoMgDemande.getDemandesActive(idProcedure);
        }

    }

    public ArrayList<Demande> getDemandeByCin(int idProcedure, String cin) {
        return daoMgDemande.getDemandeByCin(cin,idProcedure);
    }

    public void archiverDemande(String jeton) {
        daoMgDemande.archiverDemande(jeton);
    }

    public ArrayList<Demande> getDemandesOffEtape(int idProcedure,int ordre) {
        return daoMgDemande.getDemandeByIdEtape(idProcedure,ordre);
    }

    public void accepter(String jeton, int ordre) {
        daoMgDemande.accepter(jeton,ordre);
    }

    public void refuser(String jeton, int ordre) {
        daoMgDemande.refuser(jeton,ordre);
    }

    public void rejeter(String jeton, int ordre) {
        daoMgDemande.rejeter(jeton,ordre);
    }

    public void miseAjour(String jeton, int ordre) {
        daoMgDemande.miseAjour(jeton,ordre);
    }
}
