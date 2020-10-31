package com.carpetcalculator.services.State;

import com.carpetcalculator.enums.Enums;
import com.carpetcalculator.interfaces.UnitPrice;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("virginia")
@Component
public class Virginia implements UnitPrice {

    @Override
    public double calculatePrice(Enums.City city) throws Exception {
        double unitPrice = 0;

        switch (city){
            case McLean: unitPrice = 6.0; break;
            case Fairfax: unitPrice = 7.0; break;
            case Arlington: unitPrice = 8.0; break;
            default:
                throw new Exception("Undefined City!");
        }
        return unitPrice;
    }
}
