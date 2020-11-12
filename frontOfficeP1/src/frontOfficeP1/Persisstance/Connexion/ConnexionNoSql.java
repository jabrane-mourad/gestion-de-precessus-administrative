package frontOfficeP1.Persisstance.Connexion;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class ConnexionNoSql {
    private static MongoClient mClient;

    // Singleton for MongoClient
    // Creates a single connection pool internally
    public MongoClient getMongoClient() {
        if (mClient == null) {
            mClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        }
        return mClient;
    }
    // Utility method to get database instance
    public MongoDatabase getDB() {
        return getMongoClient().getDatabase("gst_procedure_db");
    }


}