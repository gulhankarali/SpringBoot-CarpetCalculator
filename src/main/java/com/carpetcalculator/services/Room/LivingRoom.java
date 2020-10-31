package com.carpetcalculator.services.Room;

import com.carpetcalculator.interfaces.FloorArea;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Qualifier("livingRoom")
@Component
public class LivingRoom implements FloorArea {

    @Value("${rectangleA}")
    private double edgeA;

    @Value("${rectangleB}")
    private double edgeB;

    @Override
    public double calculateFloor() {

        return edgeA*edgeB;
    }
}
