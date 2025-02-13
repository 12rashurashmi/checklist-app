package com.example.checklist.controller;

import com.example.checklist.model.Checklist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChecklistController {

    @GetMapping("/")
    public String showChecklistForm(Model model) {
        // Create checklist questions
        Checklist question1 = new Checklist();
        question1.setQuestion("Is the gas meter installed?");
        
        Checklist question2 = new Checklist();
        question2.setQuestion("Is the gas line securely connected?");
        
        Checklist question3 = new Checklist();
        question3.setQuestion("Is the gas leak detector functioning?");
        
        Checklist question4 = new Checklist();
        question4.setQuestion("Are there any visible signs of gas leaks?");
        
        Checklist question5 = new Checklist();
        question5.setQuestion("Is the ventilation system properly installed?");
        
        Checklist question6 = new Checklist();
        question6.setQuestion("Is the gas appliance properly grounded?");
        
        Checklist question7 = new Checklist();
        question7.setQuestion("Are all gas valves easily accessible?");
        
        Checklist question8 = new Checklist();
        question8.setQuestion("Is there a proper emergency shut-off valve?");
        
        // Add responder details
        Checklist responder = new Checklist();
        responder.setResponderName("John Doe");
        responder.setResponderAge(30);

        model.addAttribute("questions", new Checklist[] {
            question1, question2, question3, question4, question5, question6, question7, question8
        });
        model.addAttribute("responder", responder);  // Adding responder details to the model
        
        return "index";
    }
}

