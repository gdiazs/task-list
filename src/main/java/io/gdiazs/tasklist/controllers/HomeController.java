package io.gdiazs.tasklist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * HomeController
 */
@Controller
public class HomeController {

    /**
	 *
	 */
	private static final String ROOT_CONTEXT = "/home";

	@GetMapping(ROOT_CONTEXT)
    public String showHome(Model model){
        System.out.println("Hola mundo");
        model.addAttribute("data", "Guillermo B Díaz");
        return "home/index";
    }

}