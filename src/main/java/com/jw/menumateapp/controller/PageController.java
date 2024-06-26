package com.jw.menumateapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping(value = { "/","/admin", "/pos", "/menu" })
	public String index() {
		return "index.html";
	}
}