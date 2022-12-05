package com.ibs.ConvertFormat.service.print;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ibs.ConvertFormat.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class PrintJSON {


    @Autowired
    @Qualifier("JsonMapper")
    private JsonMapper mapper;

    public String getJSON(Book book) {
        try {
            String json = mapper.writeValueAsString(book);
            return json;
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
            return "";
        }
    }

}
