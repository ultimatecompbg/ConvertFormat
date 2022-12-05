package com.ibs.ConvertFormat.service.egnvalidation;


import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.lang.Integer.parseInt;
@Component
public class EgnValidator implements ConstraintValidator<Egn, String> {
    @Override
    public void initialize(Egn egn) {}
    @Override
    public boolean isValid(String egn, ConstraintValidatorContext cxt){

        if(egn.length() != 10){
            return false;
        }
        int controlNumberTotal = (parseInt(String.valueOf(egn.charAt(0))) * 2
                + parseInt(String.valueOf(egn.charAt(1))) * 4
                + parseInt(String.valueOf(egn.charAt(2))) * 8
                + parseInt(String.valueOf(egn.charAt(3))) * 5
                + parseInt(String.valueOf(egn.charAt(4))) * 10
                + parseInt(String.valueOf(egn.charAt(5))) * 9
                + parseInt(String.valueOf(egn.charAt(6))) * 7
                + parseInt(String.valueOf(egn.charAt(7))) * 3
                + parseInt(String.valueOf(egn.charAt(8))) * 6);
        int controlNumberFinal = controlNumberTotal % 11;
        if (controlNumberFinal >= 10){
            controlNumberFinal = 0;
        }
        if(controlNumberFinal == parseInt(String.valueOf(egn.charAt(9)))){
            return true;
        }else{
            return false;
        }

    }
}
