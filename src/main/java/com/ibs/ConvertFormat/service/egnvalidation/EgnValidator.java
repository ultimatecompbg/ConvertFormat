package com.ibs.ConvertFormat.service.egnvalidation;


import org.springframework.stereotype.Component;
import java.util.Arrays;
@Component
public class EgnValidator {
    public boolean isValid(String egnString){

        String[] egnStringArray = egnString.split("");
        int[] egn = Arrays.stream(egnStringArray).mapToInt(Integer::parseInt).toArray();
        if(egn.length != 10){
            return false;
        }
        int controlNumberTotal = egn[0] * 2;
        for(int i = 1; i < 8; i++){
            int toCheck = egn[i];
            switch(i){
                case 1:
                    controlNumberTotal += toCheck * 4;
                    break;
                case 2:
                    controlNumberTotal += toCheck * 8;
                    break;
                case 3:
                    controlNumberTotal += toCheck * 5;
                    break;
                case 4:
                    controlNumberTotal += toCheck * 10;
                    break;
                case 5:
                    controlNumberTotal += toCheck * 9;
                    break;
                case 6:
                    controlNumberTotal += toCheck * 7;
                    break;
                case 7:
                    controlNumberTotal += toCheck * 3;
                    break;
                case 8:
                    controlNumberTotal += toCheck * 6;
                    break;
            }

        }

        int controlNumberFinal = controlNumberTotal % 11;
        if (controlNumberFinal == 10){
            controlNumberFinal = 0;
        }
        if(controlNumberFinal == egn[9]){
            return true;
        }else{
            return false;
        }

    }
}
