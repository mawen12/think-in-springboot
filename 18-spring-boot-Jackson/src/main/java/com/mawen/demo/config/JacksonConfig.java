package com.mawen.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mawen.demo.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        SimpleModule module = new SimpleModule();
        module.addSerializer(User.class, userSerializer());
        module.addDeserializer(User.class, userDeserializer());
        mapper.registerModule(module);

        return mapper;
    }

    @Bean
    public UserSerializer userSerializer() {
        return new UserSerializer();
    }

    @Bean
    public UserDeserializer userDeserializer() {
        return new UserDeserializer();
    }
}
