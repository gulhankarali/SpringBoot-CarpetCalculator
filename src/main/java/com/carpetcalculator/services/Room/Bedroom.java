package com.carpetcalculator.services.Room;

import com.carpetcalculator.interfaces.FloorArea;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Qualifier("bedroom")
@Component
public class Bedroom implements FloorArea {

    @Value("${squareEdge}")
    private double squareEdge;

    @Override
    public double calculateFloor() {
        return squareEdge*squareEdge;
    }
}
