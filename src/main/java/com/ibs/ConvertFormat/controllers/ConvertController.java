package com.ibs.ConvertFormat.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ibs.ConvertFormat.model.Book;
import com.ibs.ConvertFormat.service.bookvalidation.BookValidator;
import com.ibs.ConvertFormat.service.print.PrintJSON;
import com.ibs.ConvertFormat.service.print.PrintXML;
import com.ibs.ConvertFormat.service.read.ReadJSON;
import com.ibs.ConvertFormat.service.read.ReadXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.util.Validate;

import javax.validation.Valid;

@Controller
public class ConvertController implements WebMvcConfigurer {
    @Autowired
    PrintJSON printJSON;
    @Autowired
    PrintXML printXML;
    @Autowired
    ReadJSON readJSON;
    @Autowired
    ReadXML readXML;
    @Autowired
    BookValidator bookValidator;
    @GetMapping("/read")
    public String showReadForm() {
        return "read";
    }
    @PostMapping("/read")
    public String read(@RequestParam(value = "convertFrom") String convertFrom, String text, Model model){
        if("json".equals(convertFrom)){

            Book newBook;
            try{
                newBook = bookValidator.validBook(readJSON.read(text));
                model.addAttribute("result", newBook);
                return "converted";
            }
            catch(RuntimeException e) {
                model.addAttribute("error", e.getMessage());
                return "invalid-egn";
            }
            finally {

            }
        }else if("xml".equals(convertFrom)){
            Book newBook;
            try{
                newBook = bookValidator.validBook(readXML.read(text));
                model.addAttribute("result", newBook);
                return "converted";
            }
            catch(RuntimeException e) {
                model.addAttribute("error", e.getMessage());
                return "500error";
            }
            finally {

            }


        }
        return "read";

    }
    @GetMapping("/print")
    public String showPrintForm(Book book){
        return "convert";
    }
    @PostMapping("/print")
    public String convert(@RequestParam(value = "convertTo") String convertTo, @RequestBody @Valid Book book, Errors errors, Model model) {
        if(errors.hasErrors()){
            return "convert";
        }
        if("json".equals(convertTo)){
            model.addAttribute("result", printJSON.getJSON(book));
            return "converted";
        }
        if("xml".equals(convertTo)){
            model.addAttribute("result", printXML.getXML(book));
            return "converted";
        }
        return "convert";

    }

}
