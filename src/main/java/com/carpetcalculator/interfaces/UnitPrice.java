package com.carpetcalculator.interfaces;

import com.carpetcalculator.enums.Enums;

public interface UnitPrice {

    double calculatePrice(Enums.City city) throws Exception;

}
