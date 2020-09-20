//package yanr.inventory.employeeservice.config;
//
//import com.mongodb.ServerAddress;
//import com.mongodb.reactivestreams.client.MongoClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author Melton Smith
// * @since 20.09.2020
// */
//
//@Configuration
//public class MongoDBConfig {
//    public String getDatabaseName() {
//        return "employee";
//    }
//    @Bean
//    public MongoClient mongoClient() {
//        ServerAddress address = new ServerAddress("localhost", 12345);
////        MongoCredential credential = MongoCredential.createCredential("mdbUser", getDatabaseName(), "cp".toCharArray());
//        MongoClientOptions options = new MongoClientOptions.Builder().build();
//
//        MongoClient client = new MongoClient(address, credential, options);
//        return client;
//    }
//    @Bean
//    public MongoDbFactory mongoDbFactory() {
//        MongoDbFactory factory = new SimpleMongoDbFactory(mongoClient(), getDatabaseName());
//        return factory;
//    }
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        MongoTemplate template = new MongoTemplate(mongoDbFactory());
//        return template;
//    }
//}
