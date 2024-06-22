package com.boolfactory.BoolAPI.controller;


import java.text.DecimalFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boolfactory.BoolAPI.services.PreventivoService;

@RestController
@RequestMapping("/")
public class PreventivoController {
		
	@Autowired
	private PreventivoService preventivoService;
	
	private static final DecimalFormat decfor = new DecimalFormat("0.00");  
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam String input, String promoCode) {
				
		return decfor.format(preventivoService.calcolaPeventivo(input, promoCode));
	}

}
