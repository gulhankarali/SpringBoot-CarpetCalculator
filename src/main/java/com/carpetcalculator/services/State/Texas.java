package com.carpetcalculator.services.State;


import com.carpetcalculator.enums.Enums;
import com.carpetcalculator.interfaces.UnitPrice;
import com.carpetcalculator.interfaces.FloorArea;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Qualifier("texas")
@Component
public class Texas implements UnitPrice {


    @Override
    public double calculatePrice(Enums.City city) throws Exception {
        double unitPrice = 0;

        switch (city){
            case Austin: unitPrice =  2.0; break;
            case Dallas: unitPrice = 3.0; break;
            case SanAntonio: unitPrice = 4.0; break;
            default:
                throw new Exception("Undefined City!");
        }
       return unitPrice;
    }
}
