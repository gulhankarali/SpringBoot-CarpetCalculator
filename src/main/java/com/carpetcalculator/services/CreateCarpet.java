package com.carpetcalculator.services;

import com.carpetcalculator.interfaces.CarpetPrice;
import com.carpetcalculator.interfaces.UnitPrice;
import com.carpetcalculator.interfaces.FloorArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.carpetcalculator.enums.City;
import com.carpetcalculator.enums.State;
import com.carpetcalculator.enums.RoomType;

@Component
public class CreateCarpet {

    @Value("${state}")
    private State state;

    @Value("${city}")
    private City city;

    @Value("${room}")
    private RoomType room;

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

    public void printPrice() throws Exception {

        double pricePerCity = 0;
        double floorAreaSize = 0;

        if (state.equals(State.TEXAS))
            pricePerCity = unitPriceTexas.calculatePrice(city);
        else if (state.equals(State.VIRGINIA))
                pricePerCity = unitPriceVirginia.calculatePrice(city);
        else
            throw new Exception("Undefined State!");

        if (room.equals(RoomType.Bedroom))
            floorAreaSize = floorAreaBedroom.calculateFloor();
        else if (room.equals(RoomType.Kitchen))
            floorAreaSize = floorAreaKitchen.calculateFloor();
        else if (room.equals(RoomType.LivingRoom))
           floorAreaSize = floorAreaLivingRoom.calculateFloor();
        else
            throw new Exception("Undefined Room Type!");

        System.out.println("$"+pricePerCity*floorAreaSize);
    }
}
