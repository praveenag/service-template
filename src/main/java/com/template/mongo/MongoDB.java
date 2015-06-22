package com.template.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.template.config.MongoConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MongoDB {
    private static final Logger logger = LoggerFactory.getLogger(MongoDB.class);

    public static Datastore createMongoDataStore(MongoConfiguration configuration) {
        try {
            List<MongoCredential> mongoCredentials = getMongoCredentials(configuration);

            MongoClient mongo = new MongoClient(new ServerAddress(configuration.getHost(), configuration.getPort()), mongoCredentials);
            Morphia morphia = new Morphia();
            Datastore datastore = morphia.createDatastore(mongo, configuration.getDatabase());
            datastore.ensureIndexes();
            datastore.ensureCaps();
            logger.info("Created Mongo data store for candidate Service");
            return datastore;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<MongoCredential> getMongoCredentials(MongoConfiguration configuration) {
        List<MongoCredential> mongoCredentials = new ArrayList<>();

        if (!StringUtils.isEmpty(configuration.getPassword())) {
            mongoCredentials.add(MongoCredential.createMongoCRCredential(configuration.getUsername(),
                    configuration.getDatabase(),
                    configuration.getPassword().toCharArray()));
        }

        return mongoCredentials;
    }

}
