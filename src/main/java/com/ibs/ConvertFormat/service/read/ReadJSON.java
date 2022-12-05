package com.ibs.ConvertFormat.service.read;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ibs.ConvertFormat.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import javax.validation.Valid;

@Component
public class ReadJSON {
    @Autowired
    @Qualifier("JsonMapper")
    private JsonMapper objectMapper;
    @Valid
    public Book read(String json) {
        try{
            Book book = objectMapper.readValue(json, Book.class);
            return book;
        }
        catch(JsonProcessingException e){
            e.printStackTrace();
            return new Book();
        }
    }
}
