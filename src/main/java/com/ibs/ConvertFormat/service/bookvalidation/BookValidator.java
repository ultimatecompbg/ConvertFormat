package com.ibs.ConvertFormat.service.bookvalidation;

import com.ibs.ConvertFormat.model.Author;
import com.ibs.ConvertFormat.model.Book;
import com.ibs.ConvertFormat.service.egnvalidation.EgnValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;

@Component
public class BookValidator {
    @Autowired
    EgnValidator egnValidator;
    public Book validBook(@Valid Book book){
        if(book.getTitle() == null){
            throw new RuntimeException("Empty title");
        }
        List<Author> authors = book.getAuthors();
        for(Author a : authors){
            if(!egnValidator.isValid(a.getEgn())){

                throw new RuntimeException("Invalid EGN");
            }
        }
        return book;
    }
}
