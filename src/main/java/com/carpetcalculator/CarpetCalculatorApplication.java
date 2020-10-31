package com.carpetcalculator;

import com.carpetcalculator.interfaces.CarpetPrice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarpetCalculatorApplication {

	public static void main(String[] args) throws Exception {

		ApplicationContext container = SpringApplication.run(CarpetCalculatorApplication.class, args);

//		CarpetPrice carpetPrice = container.getBean("createCarpet", CarpetPrice.class);
//
//		carpetPrice.printPrice();

		CarpetPrice carpetPrice1 = container.getBean("createCarpetII", CarpetPrice.class);

		carpetPrice1.printPrice();

	}

}
