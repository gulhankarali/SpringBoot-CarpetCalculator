package com.carpetcalculator.services;

import com.carpetcalculator.enums.Enums;
import com.carpetcalculator.interfaces.CarpetPrice;
import com.carpetcalculator.interfaces.UnitPrice;
import com.carpetcalculator.interfaces.FloorArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CreateCarpet implements CarpetPrice {

    @Value("${state}")
    private Enums.State state;

    @Value("${city}")
    private Enums.City city;

    @Value("${room}")
    private Enums.RoomType room;

    @Autowired
    @Qualifier("texas")
    private UnitPrice unitPriceTexas;

    @Autowired
    @Qualifier("virginia")
    private UnitPrice unitPriceVirginia;

    @Autowired
    @Qualifier("bedroom")
    private FloorArea floorAreaBedroom;

    @Autowired
    @Qualifier("kitchen")
    private FloorArea floorAreaKitchen;

    @Autowired
    @Qualifier("livingRoom")
    private FloorArea floorAreaLivingRoom;

    @Override
    public void printPrice() throws Exception {

        double pricePerCity = 0;
        double floorAreaSize = 0;

        if (state.equals(Enums.State.TEXAS))
            pricePerCity = unitPriceTexas.calculatePrice(city);
        else if (state.equals(Enums.State.VIRGINIA))
                pricePerCity = unitPriceVirginia.calculatePrice(city);
        else
            throw new Exception("Undefined State!");

        if (room.equals(Enums.RoomType.Bedroom))
            floorAreaSize = floorAreaBedroom.calculateFloor();
        else if (room.equals(Enums.RoomType.Kitchen))
            floorAreaSize = floorAreaKitchen.calculateFloor();
        else if (room.equals(Enums.RoomType.LivingRoom))
           floorAreaSize = floorAreaLivingRoom.calculateFloor();
        else
            throw new Exception("Undefined Room Type!");

        System.out.println("$"+pricePerCity*floorAreaSize);
    }
}
