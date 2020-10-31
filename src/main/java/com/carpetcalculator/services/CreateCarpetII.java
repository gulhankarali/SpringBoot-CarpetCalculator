package com.carpetcalculator.services;

import com.carpetcalculator.enums.City;
import com.carpetcalculator.interfaces.CarpetPrice;
import com.carpetcalculator.interfaces.FloorArea;
import com.carpetcalculator.interfaces.UnitPrice;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CreateCarpetII {

    @Value("${city}")
    private City city;

    private FloorArea floorArea;

    private UnitPrice unitPrice;

    public CreateCarpetII(@Qualifier("texas") UnitPrice unitPrice, @Qualifier("bedroom")FloorArea floorArea) {
        this.unitPrice = unitPrice;
        this.floorArea = floorArea;
    }

    public void printPrice() throws Exception {
        System.out.println("$"+unitPrice.calculatePrice(city)*floorArea.calculateFloor());
    }

}
