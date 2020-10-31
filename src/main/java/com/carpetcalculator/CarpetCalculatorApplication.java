package com.carpetcalculator;

import com.carpetcalculator.interfaces.CarpetPrice;
import com.carpetcalculator.interfaces.UnitPrice;
import com.carpetcalculator.services.State.Texas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarpetCalculatorApplication {

	public static void main(String[] args) throws Exception {

		ApplicationContext container = SpringApplication.run(CarpetCalculatorApplication.class, args);

		CarpetPrice carpetPrice = container.getBean("createCarpet", CarpetPrice.class);

		carpetPrice.printPrice();


	}

}
