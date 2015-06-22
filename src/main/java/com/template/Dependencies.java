package com.template;

import com.template.config.AppConfiguration;
import com.template.config.MongoConfiguration;
import com.template.mongo.MongoDB;
import com.template.resources.HelloResource;
import org.mongodb.morphia.Datastore;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Caching;

public class Dependencies {
    protected final MutablePicoContainer picoContainer = new DefaultPicoContainer(new Caching());

    public void initialise(AppConfiguration configuration) {
        picoContainer.addComponent(AppConfiguration.class, configuration);
        picoContainer.addComponent(MongoConfiguration.class, configuration.getMongo());

        picoContainer.addComponent(Datastore.class, MongoDB.createMongoDataStore(configuration.getMongo()));

        //Resources
        picoContainer.addComponent(HelloResource.class);

    }


    public <T> T get(Class<T> klass) {
        return picoContainer.getComponent(klass);
    }

}
