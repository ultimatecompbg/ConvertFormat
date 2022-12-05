package com.ibs.ConvertFormat.service.configuration;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XmlMapperFactory {
    @Bean(name = "XmlMapper")
    public XmlMapper XmlMapperFactory(){
        return new XmlMapper();
    }
}
