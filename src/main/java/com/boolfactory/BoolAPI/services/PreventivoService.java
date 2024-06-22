package com.boolfactory.BoolAPI.services;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class PreventivoService {
	
	private Map<String, Double> workMap = new HashMap<String, Double>();
	
	private String[] validCodes = {"YHDNU32", "JANJC63", "PWKCN25", "SJDPO96", "POCIE24"};
	
	private int workTime = 10;

    private double finalPrice = 0;
    
    public double calcolaPeventivo(String input, String promoCode) {
    		switch (input) {
		case "2":
			finalPrice = workMap.get("Backend Development") * workTime ;
			break;
		case "3": 
			finalPrice = workMap.get("Frontend Development") * workTime ;
			break;
		case "4":
			finalPrice = workMap.get("Project Analysis") * workTime ;
			break;
		}
	
		for (String code: validCodes) {
			if (promoCode.equals(code)) {
				finalPrice -= (finalPrice*25)/100;
			}
		}
		return finalPrice;
    }
	
	@PostConstruct
	private void initMap() {
		workMap.put("Backend Development",20.50);
		workMap.put("Frontend Development",15.30);
		workMap.put("Project Analysis",33.60);
	}
	
}
