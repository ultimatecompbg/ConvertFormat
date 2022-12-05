package com.ibs.ConvertFormat.model;

import com.ibs.ConvertFormat.Constants;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component

public class Book {
    @NotEmpty
    private String title;
    private String description;
    private Date publishDate;
    private int ISBN;
    private List<@Valid Author> authors;
    @Override
    public String toString(){
        String bookString = String.format("Title: %s\nDescription: %s\nPublish Date: %s\nISBN: %s\nAuthor", title, description, publishDate, ISBN);
        for(Author a : authors){
            bookString += a.toString();
        }
        return bookString;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Date getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String newPublishDate) throws ParseException {
        Date publishDate = new SimpleDateFormat(Constants.dateFormat).parse(newPublishDate);
        this.publishDate = publishDate;
    }
    public int getISBN() {
        return ISBN;
    }
    public void setISBN(int ISBN){
        this.ISBN = ISBN;
    }
    public void addAuthor(Author author) {
        authors.add(author);
    }
    public List<Author> getAuthors(){
        return authors;
    }
}
