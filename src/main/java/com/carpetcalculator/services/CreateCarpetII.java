package com.carpetcalculator.services;

import com.carpetcalculator.enums.Enums;
import com.carpetcalculator.interfaces.CarpetPrice;
import com.carpetcalculator.interfaces.FloorArea;
import com.carpetcalculator.interfaces.UnitPrice;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CreateCarpetII implements CarpetPrice {

    @Value("${city}")
    private Enums.City city;

    private FloorArea floorArea;

    private UnitPrice unitPrice;

    public CreateCarpetII(@Qualifier("virginia") UnitPrice unitPrice, @Qualifier("bedroom")FloorArea floorArea) {
        this.unitPrice = unitPrice;
        this.floorArea = floorArea;
    }

    @Override
    public void printPrice() throws Exception {
        System.out.println("$"+unitPrice.calculatePrice(city)*floorArea.calculateFloor());
    }

}
