package frontOfficeP1.Persisstance.Interfaces;

import com.mongodb.client.MongoCollection;
import frontOfficeP1.Metier.BeansMetier.Demande;
import org.bson.Document;

import java.util.ArrayList;

public interface InDemande {
    public MongoCollection<Document> getDemandeCollection();

    public void addDemande(Demande demande);

    public void archiverDemande(String jeton);

    public ArrayList<Demande> getDemandes();

    public ArrayList<Demande> getDemandesArchive(int id_procedure);

    public ArrayList<Demande> getDemandesActive(int id_procedure);

    ArrayList<Demande> getDemandeByJeton(String jeton,int id_procedure);

    public ArrayList<Demande> getDemandeByCin(String cin,int id_procedure);

    public ArrayList<Demande> getDemandeByIdEtape(int idProcedure,int ordre);

    void accepter(String jeton, int ordre);
    void refuser(String jeton, int ordre);
    void rejeter(String jeton, int ordre);
    void miseAjour(String jeton, int ordre);
}
