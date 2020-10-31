package com.carpetcalculator.services.Room;

import com.carpetcalculator.interfaces.FloorArea;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Qualifier("kitchen")
@Component
public class Kitchen implements FloorArea {

    @Value("${radius}")
    private double radius;

    @Override
    public double calculateFloor() {

        return radius*radius*Math.PI;
    }
}
