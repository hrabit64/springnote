package com.hrabit64.springnote.config.database

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import java.lang.Exception

@Configuration
class MongoConfig{

    @Value("\${spring.data.mongodb.uri}")
    var connectionAddress:String = ""

    @Value("\${spring.data.mongodb.database}")
    var databaseName:String = ""

    @Bean
    fun mongo():MongoClient{
        val connectionString: ConnectionString = ConnectionString(connectionAddress)
        val mongoClientSettings: MongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .retryWrites(false)
            .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    fun mongoTemplate(): MongoTemplate? {
        return MongoTemplate(mongo(), databaseName)
    }
}