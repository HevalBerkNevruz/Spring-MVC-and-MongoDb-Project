package org.infonal.project.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by heval on 15.08.2015.
 */

@Configuration
@EnableMongoRepositories(basePackages="org.infonal.project.dao")
public class MongoConfiguration extends AbstractMongoConfiguration{
    @Override
    protected String getDatabaseName() {
        return "infonal";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(new ServerAddress("localhost", 27017));
    }
}
