package com.example.travels.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.travels.models.Travel;
import com.example.travels.services.TravelService;

@Controller
public class MainController {
    
    @Autowired TravelService travelService;
    
    //!showall
    @RequestMapping("/")
    public String allTravels(Model model,@ModelAttribute("travel") Travel travel){
        List<Travel>travels = travelService.allTravels();
        model.addAttribute("travels",travels);
        return "index.jsp";
    }
    //!CREATE
    @PostMapping("/new")
    public String newTravel(
        @Valid @ModelAttribute("travel")Travel travel, BindingResult result,Model model
    ){
        if(result.hasErrors()){
            List<Travel>travels = travelService.allTravels();
            model.addAttribute("travels", travels);
            return "index.jsp";
        }else{
            travelService.createTravel(travel);
            return "redirect:/";
    
        }

    }

    //SHOWONE
    @GetMapping("/{id}")
    public String show(@PathVariable("id")Long id, Model model){
        Travel travel = travelService.getOne(id);
        model.addAttribute("travel",travel);
        return "one.jsp";
    }

    //UPDATEONE
    @GetMapping("/edit/{id}")
        public String edit(@PathVariable("id")Long id, Model model){
            Travel travel = travelService.getOne(id);
            model.addAttribute("travel",travel);
            return "edit.jsp";
        }

    @PutMapping("/editing/{id}")
        public String update(@PathVariable("id")Long id, @Valid @ModelAttribute("travel") Travel travel, BindingResult result){
            if(result.hasErrors()){
                return"edit.jsp";
            }else{
                travelService.updateOne(travel);
            return "redirect:/";
            }
        }

    @DeleteMapping("/delete/{id}")
        public String destroy(@PathVariable("id")Long id){
            Travel travel = travelService.getOne(id);
            travelService.deleteById(travel);
            return "redirect:/";

    }




}
