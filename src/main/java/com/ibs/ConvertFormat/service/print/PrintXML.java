package com.ibs.ConvertFormat.service.print;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ibs.ConvertFormat.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PrintXML {
    @Autowired
    @Qualifier("XmlMapper")
    private XmlMapper mapper;
    public String getXML(Book book) {
        try{
            String xml = mapper.writeValueAsString(book);
            return xml;
        }
        catch(JsonProcessingException e){
            e.printStackTrace();
            return "";
        }


    }
}
