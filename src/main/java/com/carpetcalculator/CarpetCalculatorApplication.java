package com.carpetcalculator;

import com.carpetcalculator.interfaces.CarpetPrice;
import com.carpetcalculator.services.CreateCarpet;
import com.carpetcalculator.services.CreateCarpetII;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarpetCalculatorApplication {

	public static void main(String[] args) throws Exception {

		ApplicationContext container = SpringApplication.run(CarpetCalculatorApplication.class, args);

	    CreateCarpet createCarpet = container.getBean("createCarpet", CreateCarpet.class);

		createCarpet.printPrice();

		CreateCarpetII createCarpetII = container.getBean("createCarpetII", CreateCarpetII.class);

		createCarpetII.printPrice();

	}

}
