package com.boolfactory.BoolAPI.controller;


import java.text.DecimalFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boolfactory.BoolAPI.controller.objects.Work;

@RestController
@RequestMapping("/")
public class PreventivoController {
	
	private static final DecimalFormat decfor = new DecimalFormat("0.00");  
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam String input, String promoCode) {
			
		Work[] work = {new Work(),new Work(),new Work()};
		int workTime = 10;
		double finalPrice = 0.00;
		String[] validCodes = {"YHDNU32", "JANJC63", "PWKCN25", "SJDPO96", "POCIE24"};
		
		//fare un json per usare il foreach
		work[0].setName("Backend Development");
		work[0].setRate(20.50);
		work[1].setName("Frontend Development");
		work[1].setRate(15.30);
		work[2].setName("Project Analysis");
		work[2].setRate(33.60);
			
		if (input.equals("2")) {
			finalPrice = work[0].getRate() * workTime;
		} else if (input.equals("3")) {
			finalPrice = work[1].getRate() * workTime;
		} else if (input.equals("4")) {
			finalPrice = work[2].getRate() * workTime;
		}
		
		for (String code: validCodes) {
			if (promoCode.equals(code)) {
				finalPrice -= (finalPrice*25)/100;
			}
		}
		
		return decfor.format(finalPrice);
	}
	
}
