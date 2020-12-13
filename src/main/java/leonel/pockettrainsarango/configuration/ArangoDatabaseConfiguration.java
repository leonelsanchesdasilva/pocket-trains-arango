package leonel.pockettrainsarango.configuration;

import com.arangodb.ArangoDB;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableArangoRepositories(basePackages = { "leonel.pockettrainsarango.repository" })
public class ArangoDatabaseConfiguration implements ArangoConfiguration {

    @Override
    public ArangoDB.Builder arango() {
        return new ArangoDB.Builder();
    }

    @Override
    public String database() {
        // Name of the database to be used
        return "pocketTrains";
    }

    /* @Bean
    public ArangoDB arangoDb () {
        return new ArangoDB.Builder().user("root").password("arango#123").build();
    }

    @Bean
    public ArangoDatabase arangoDatabase() {
        return arangoDb().db("trains");
    }

    @PostConstruct
    public void init() {
        final String GRAPH_NAME = "worldmap";
        final String EDGE_COLLECTION_NAME = "routes";
        final String VERTEX_COLLECTION_NAME = "cities";

        final ArangoDB arangoDb = arangoDb();
        final String dbName = "trains";
        try {
            arangoDb.createDatabase(dbName);
            System.out.println("Database created: " + dbName);
        } catch (final ArangoDBException e) {
            System.err.println("Failed to create database: " + dbName + "; " + e.getMessage());
        }

        final ArangoDatabase arangoDatabase = arangoDb.db(dbName);
        final Collection<EdgeDefinition> edgeDefinitions = new ArrayList<>();
        final EdgeDefinition edgeDefinition = new EdgeDefinition().collection(EDGE_COLLECTION_NAME)
                .from(VERTEX_COLLECTION_NAME).to(VERTEX_COLLECTION_NAME);
        edgeDefinitions.add(edgeDefinition);
        if (!arangoDatabase.graph(GRAPH_NAME).exists()) {
            arangoDatabase.createGraph(GRAPH_NAME, edgeDefinitions, null);
        }
    } */
}
