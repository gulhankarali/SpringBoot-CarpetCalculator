package com.carpetcalculator.services.State;


import com.carpetcalculator.enums.City;
import com.carpetcalculator.interfaces.UnitPrice;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Qualifier("texas")
@Component
public class Texas implements UnitPrice {

    private static final Map<City, BigDecimal> sqPriceForCity = new HashMap<>();

    static{
        sqPriceForCity.put(City.McLean,new BigDecimal("4.32"));
        sqPriceForCity.put(City.Arlington,new BigDecimal("2.92"));
        sqPriceForCity.put(City.Fairfax,new BigDecimal("4.65"));
    }

    @Override
    public double calculatePrice(City city) throws Exception {

        Optional<Map.Entry<City,BigDecimal>> collect =
                sqPriceForCity.entrySet().stream().filter(x -> x.getKey() == city).findFirst();

        BigDecimal defaultValue = BigDecimal.ZERO;
        
        double unitPrice = 0;

        switch (city){
            case Austin: unitPrice =  2.0; break;
            case Dallas: unitPrice = 3.0; break;
            case SanAntonio: unitPrice = 4.0; break;
            default:
                throw new Exception("Undefined City!");
        }
//        return collect.isPresent() ? collect.get().getValue() : defaultValue;
        return unitPrice;
    }
}
