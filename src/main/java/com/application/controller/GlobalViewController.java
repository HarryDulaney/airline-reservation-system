package com.application.controller;

import com.application.model.GlobalView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@Controller
public class GlobalViewController {

    @ModelAttribute
    public void addAttributes(Model model) {
        GlobalView globalView = new GlobalView(1);
        model.addAttribute("GlobalView", globalView);
    }
}
