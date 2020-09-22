package yanr.inventory.employeeservice.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

/**
 * @author Melton Smith
 * @since 20.09.2020
 */

@Configuration
public class ReactiveMongoConfig {

    @Autowired
    MongoClient mongoClient;

//    @Bean
//    public MongoClient mongoClient() {
//        ConnectionString connectionString = new ConnectionString("mongodb://localhost:12345/test");
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//
//        return MongoClients.create(mongoClientSettings);
//    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() throws Exception {
        return new ReactiveMongoTemplate(mongoClient, "employeeServiceDb");
    }
}
