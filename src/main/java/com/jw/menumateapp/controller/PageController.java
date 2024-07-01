package com.jw.menumateapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping(value = { "/", "/admin", "/pos", "/menu", "/signup", "/login", "/**/{path:[^\\.]*}" })
    public String redirect() {
        return "index.html";
    }
}