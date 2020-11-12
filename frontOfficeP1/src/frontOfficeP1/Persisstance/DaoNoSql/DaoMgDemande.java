package frontOfficeP1.Persisstance.DaoNoSql;

import com.mongodb.client.MongoCollection;
import frontOfficeP1.Metier.BeansMetier.Demande;
import frontOfficeP1.Persisstance.Connexion.ConnexionNoSql;
import frontOfficeP1.Persisstance.Interfaces.InDemande;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class DaoMgDemande implements InDemande {
    private final ConnexionNoSql connexion = new ConnexionNoSql();

    @Override
    public MongoCollection<Document> getDemandeCollection() {
        return connexion.getDB().getCollection("demande");
    }

    @Override
    public void addDemande(Demande demande) {
        Document document = new Document("jeton", demande.getJeton());
        document.append("nom", demande.getNom());
        document.append("etat", demande.getEtat_de_demande());
        document.append("date_depo", demande.getDate_depo());
        document.append("date_acceptation", demande.getDate_acceptation());
        document.append("etape_actuel", demande.getEtape_actuel());
        document.append("date_debut", demande.getDate_debut());
        document.append("date_fin", demande.getDate_fin());
        document.append("est_archive", demande.getArchive());
        document.append("cin", demande.getCin());
        document.append("id_procedure", demande.getId_procedure());
        getDemandeCollection().insertOne(document);

    }
    @Override
    public void archiverDemande(String jeton) {
        MongoCollection<Document> collection = getDemandeCollection();
        Document query = new Document();
        query.append("jeton", jeton);
        Document setData = new Document();
        setData.append("est_archive", true);
        Document update = new Document();
        update.append("$set", setData);
        collection.updateOne(query, update);
    }
    @Override
    public ArrayList<Demande> getDemandes() {
        MongoCollection<Document> collection = getDemandeCollection();
        List<Document> demandes = (List<Document>) collection.find().into(new ArrayList<Document>());
        ArrayList<Demande> allDemandes = new ArrayList<>();
        for (Document demande : demandes) {
            allDemandes.add(
                    new Demande(
                            demande.getString("jeton"),
                            demande.getString("nom"),
                            demande.getString("etat"),
                            demande.getDate("date_depo"),
                            demande.getDate("date_acceptation"),
                            demande.getInteger("etape_actuel"),
                            demande.getDate("date_debut"),
                            demande.getDate("date_fin"),
                            demande.getBoolean("est_archive"),
                            demande.getString("cin"),
                            demande.getInteger("id_procedure")
                    )
            );
        }

        return allDemandes;
    }
    @Override
    public ArrayList<Demande> getDemandesArchive(int id_procedure) {
        MongoCollection<Document> collection = getDemandeCollection();
        List<Document> demandes = (List<Document>) collection.find(and(eq("est_archive", true),
                eq("id_procedure", id_procedure))).into(new ArrayList<Document>());
        ArrayList<Demande> allDemandes = new ArrayList<>();
        for (Document demande : demandes) {
            allDemandes.add(
                    new Demande(
                            demande.getString("jeton"),
                            demande.getString("nom"),
                            demande.getString("etat"),
                            demande.getDate("date_depo"),
                            demande.getDate("date_acceptation"),
                            demande.getInteger("etape_actuel"),
                            demande.getDate("date_debut"),
                            demande.getDate("date_fin"),
                            demande.getBoolean("est_archive"),
                            demande.getString("cin"),
                            demande.getInteger("id_procedure")
                    )
            );
        }

        return allDemandes;
    }
    @Override
    public ArrayList<Demande> getDemandesActive(int id_procedure) {
        MongoCollection<Document> collection = getDemandeCollection();
        List<Document> demandes = (List<Document>) collection.find(and(eq("est_archive", false),
                eq("id_procedure", id_procedure))).into(new ArrayList<Document>());
        ArrayList<Demande> allDemandes = new ArrayList<>();
        for (Document demande : demandes) {
            allDemandes.add(
                    new Demande(
                            demande.getString("jeton"),
                            demande.getString("nom"),
                            demande.getString("etat"),
                            demande.getDate("date_depo"),
                            demande.getDate("date_acceptation"),
                            demande.getInteger("etape_actuel"),
                            demande.getDate("date_debut"),
                            demande.getDate("date_fin"),
                            demande.getBoolean("est_archive"),
                            demande.getString("cin"),
                            demande.getInteger("id_procedure")
                    )
            );
        }

        return allDemandes;
    }
    @Override
    public ArrayList<Demande> getDemandeByJeton(String jeton, int id_procedure) {
        MongoCollection<Document> collection = getDemandeCollection();
        List<Document> demandes = (List<Document>) collection.find(and(eq("jeton", jeton),
                eq("id_procedure", id_procedure))).into(new ArrayList<Document>());
        ArrayList<Demande> allDemandes = new ArrayList<>();
        for (Document demande : demandes) {
            allDemandes.add(
                    new Demande(
                            demande.getString("jeton"),
                            demande.getString("nom"),
                            demande.getString("etat"),
                            demande.getDate("date_depo"),
                            demande.getDate("date_acceptation"),
                            demande.getInteger("etape_actuel"),
                            demande.getDate("date_debut"),
                            demande.getDate("date_fin"),
                            demande.getBoolean("est_archive"),
                            demande.getString("cin"),
                            demande.getInteger("id_procedure")
                    )
            );
        }

        return allDemandes;
    }
    @Override
    public ArrayList<Demande> getDemandeByCin(String cin, int id_procedure) {
        MongoCollection<Document> collection = getDemandeCollection();
        List<Document> demandes = (List<Document>) collection.find(and(eq("cin", cin),
                eq("id_procedure", id_procedure))).into(new ArrayList<Document>());
        ArrayList<Demande> allDemandes = new ArrayList<>();
        for (Document demande : demandes) {
            allDemandes.add(
                    new Demande(
                            demande.getString("jeton"),
                            demande.getString("nom"),
                            demande.getString("etat"),
                            demande.getDate("date_depo"),
                            demande.getDate("date_acceptation"),
                            demande.getInteger("etape_actuel"),
                            demande.getDate("date_debut"),
                            demande.getDate("date_fin"),
                            demande.getBoolean("est_archive"),
                            demande.getString("cin"),
                            demande.getInteger("id_procedure")
                    )
            );
        }

        return allDemandes;
    }
    @Override
    public ArrayList<Demande> getDemandeByIdEtape(int idProcedure, int ordre) {

        MongoCollection<Document> collection = getDemandeCollection();
        List<Document> demandes = (List<Document>) collection.find(and(eq("id_procedure", idProcedure), eq("etape_actuel", ordre))).into(new ArrayList<Document>());
        ArrayList<Demande> allDemandes = new ArrayList<>();
        for (Document demande : demandes) {
            allDemandes.add(
                    new Demande(
                            demande.getString("jeton"),
                            demande.getString("nom"),
                            demande.getString("etat"),
                            demande.getDate("date_depo"),
                            demande.getDate("date_acceptation"),
                            demande.getInteger("etape_actuel"),
                            demande.getDate("date_debut"),
                            demande.getDate("date_fin"),
                            demande.getBoolean("est_archive"),
                            demande.getString("cin"),
                            demande.getInteger("id_procedure")
                    )
            );
        }

        return allDemandes;
    }
    @Override
    public void accepter(String jeton, int ordre) {
        int newOrdre = ordre + 1;
        MongoCollection<Document> collection = getDemandeCollection();
        Document query = new Document();
        query.append("jeton", jeton);
        Document setData = new Document();
        setData.append("etape_actuel", newOrdre);
        Document update = new Document();
        update.append("$set", setData);
        collection.updateOne(query, update);

    }

    @Override
    public void refuser(String jeton, int ordre) {
        int newOrdre = ordre - 1;
        MongoCollection<Document> collection = getDemandeCollection();
        Document query = new Document();
        query.append("jeton", jeton);
        Document setData = new Document();
        setData.append("etape_actuel", newOrdre);
        Document update = new Document();
        update.append("$set", setData);
        collection.updateOne(query, update);

    }

    @Override
    public void rejeter(String jeton, int ordre) {
        MongoCollection<Document> collection = getDemandeCollection();
        Document query = new Document();
        query.append("jeton", jeton);
        Document setData = new Document();
        setData.append("etat", "rejected");
        Document update = new Document();
        update.append("$set", setData);
        collection.updateOne(query, update);
        rejeterZero(jeton);

    }
    public void rejeterZero(String jeton) {
        MongoCollection<Document> collection = getDemandeCollection();
        Document query = new Document();
        query.append("jeton", jeton);
        Document setData = new Document();
        setData.append("etape_actuel", 0);
        Document update = new Document();
        update.append("$set", setData);
        collection.updateOne(query, update);

    }

    @Override
    public void miseAjour(String jeton, int ordre) {
        MongoCollection<Document> collection = getDemandeCollection();
        Document query = new Document();
        query.append("jeton", jeton);
        Document setData = new Document();
        setData.append("etat", "en_att");
        Document update = new Document();
        update.append("$set", setData);
        collection.updateOne(query, update);

    }

    public ArrayList<Demande> RechercheByCin(int idEtape, int idProcedure, String cin) {
        MongoCollection<Document> collection = getDemandeCollection();
        List<Document> demandes = (List<Document>) collection.find(and(eq("cin", cin),
                eq("id_procedure", idProcedure))).into(new ArrayList<Document>());
        ArrayList<Demande> allDemandes = new ArrayList<>();
        for (Document demande : demandes) {
            allDemandes.add(
                    new Demande(
                            demande.getString("jeton"),
                            demande.getString("nom"),
                            demande.getString("etat"),
                            demande.getDate("date_depo"),
                            demande.getDate("date_acceptation"),
                            demande.getInteger("etape_actuel"),
                            demande.getDate("date_debut"),
                            demande.getDate("date_fin"),
                            demande.getBoolean("est_archive"),
                            demande.getString("cin"),
                            demande.getInteger("id_procedure")
                    )
            );
        }

        return allDemandes;
    }
}

