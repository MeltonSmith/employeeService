package yanr.inventory.employeeservice.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.sun.jna.platform.FileUtils;
import org.apache.commons.configuration.beanutils.BeanFactory;
import org.bson.Document;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import yanr.inventory.employeeservice.domain.Employee;
import yanr.inventory.employeeservice.reactiveRepos.EmployeeReactiveRepository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Melton Smith
 * @since 20.09.2020
 */
@AutoConfigureAfter(value = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@Configuration
public class MongoAutoFillConfigurationClass {

//    @Bean
//    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory, MongoMappingContext context, BeanFactory beanFactory) {
//        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
//        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
//        try {
//            mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
//        }
//        catch (NoSuchBeanDefinitionException ignore) {}
//
//        // Don't save _class to mongo
//        mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
//
//        return mappingConverter;
//    }

    @Bean
    @SuppressWarnings("unchecked")
    public Boolean preFill(ReactiveMongoTemplate reactiveMongoTemplate) throws IOException {
        reactiveMongoTemplate.insert(mockkEmployee((long)(Math.random() * 100L)));
        reactiveMongoTemplate.insert(mockkEmployee((long)(Math.random() * 100L)));
        reactiveMongoTemplate.insert(mockkEmployee((long)(Math.random() * 100L)));
        reactiveMongoTemplate.insert(mockkEmployee((long)(Math.random() * 100L)));
        reactiveMongoTemplate.insert(mockkEmployee((long)(Math.random() * 100L)));
        reactiveMongoTemplate.insert(mockkEmployee((long)(Math.random() * 100L)));
        reactiveMongoTemplate.insert(mockkEmployee((long)(Math.random() * 100L)));


//        File file = new ClassPathResource("mongoseeddata.json").getFile();
//
//        JsonParser parser = getJsonParser();
//        String jsonString = FileUtils.readFileToString(file, Charset.defaultCharset());
//
//        Map<String, Object> jsonMap = parser.parseJson(jsonString);
//
//        jsonMap.forEach((key, value) -> {
//            List dbObjects = (List) jsonMap.get(key);
//
//            for (Object dbObject : dbObjects) {
//                Document document = new Document(parser.parseJson(JSON.serialize(dbObject)));
//                mongoTemplate.insert(document, key);
//            }
//        });

        return true;
    }

    private JsonParser getJsonParser() {
        return JsonParserFactory.getJsonParser();
    }

    //NOTE DOESN'T WORK
//    @Bean
//    @SuppressWarnings("unchecked")
//    public Boolean preFill(EmployeeReactiveRepository reactiveRepository) throws IOException {
//        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));
//        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));
//        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));
//        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));
//        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));
//        reactiveRepository.save(mockkEmployee((long)(Math.random() * 100L)));
//
//        return true;
//    }

    private Employee mockkEmployee(Long number) {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setFirstName("First name =" +  number);
        employee.setLastName("Second name =" +  number);
        employee.setMiddleName("Middle name =" +  number);
        employee.setBirthDate("Birth date = "  + number);
        return employee;
    }
//
//    @Bean
//    public Mongobee mongobee(){
//        Mongobee runner = new Mongobee("mongodb://localhost:12345/employee");
////        runner.setDbName("yourDbName");         // host must be set if not set in URI
//        runner.setChangeLogsScanPackage(
//                "yanr.inventory.employeeservice.prefill"); // the package to be scanned for changesets
//
//        return runner;
//    }

}
