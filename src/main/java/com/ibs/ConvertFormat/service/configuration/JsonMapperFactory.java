package com.ibs.ConvertFormat.service.configuration;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JsonMapperFactory {
    @Primary
    @Bean(name = "JsonMapper")
    public JsonMapper JsonMapperFactory(){
        return new JsonMapper();
    }
}
