package com.example.opendataproject.controller;

import com.example.opendataproject.domain.Record;
import com.example.opendataproject.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    private final CountryService countryService;
    private final ArrayList<String> countries;
    private final List<Record> records;

    public HomeController(CountryService countryService) throws JsonProcessingException {
        this.countryService = countryService;
        this.countries = countryService.getCountries();
        this.records = countryService.getRecords();
    }

    @GetMapping("/")
    public String home(Model model)  {
        Collections.sort(countries);
        model.addAttribute("countryList", countries);
        return "home";
    }

    @PostMapping("/showResults")
    public String showResults(@RequestParam String country, @RequestParam(required = false) String hasCertificate, Model model) throws JsonProcessingException{
        for(Record record: records){
            if(record.getValsts().equals(country)){
                model.addAttribute("record",record);
                if(hasCertificate == null){
                    model.addAttribute("hasCertificate", false);
                }else{
                    model.addAttribute("hasCertificate", true);
                }
            }
        }
        return "response";
    }

    @GetMapping("/showResults")
    public String redirect(){
        return "redirect:/";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/countries")
    public String countries(Model model){
        model.addAttribute("records",records);
        return "countries";
    }
}


