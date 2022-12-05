package com.ibs.ConvertFormat.service.read;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ibs.ConvertFormat.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Component
public class ReadXML {
    @Autowired
    @Qualifier("XmlMapper")
    XmlMapper xmlMapper;

    @Valid
    public Book read(String xml){
        try{
            @Valid Book book = xmlMapper.readValue(xml, Book.class);
            return book;
        }
        catch(JsonProcessingException e){
            e.printStackTrace();
            return new Book();
        }



    }
}
