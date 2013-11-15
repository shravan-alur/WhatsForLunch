package com.boredatlunch.whatsforlunch.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoogleLoginController {
	
	@RequestMapping(value="/connectToGoogle", method=RequestMethod.GET)
	public void loginToGoogle() {
		System.out.println("**********************HERE***********************");
	}
	
	
}
