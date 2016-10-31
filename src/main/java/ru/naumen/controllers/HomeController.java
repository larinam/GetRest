package ru.naumen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dkirpichenkov on 31.10.16.
 */
@Controller
public class HomeController
{
    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("name", "World");
        return "index";
    }
}
