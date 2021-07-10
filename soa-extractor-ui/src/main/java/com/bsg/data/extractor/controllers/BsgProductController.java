package com.bsg.data.extractor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bsg.data.extractor.services.BsgProductService;

@Controller
public class BsgProductController {

    private BsgProductService bankProductService;

    @Autowired
    public void setProductService(BsgProductService bankProductService) {
        this.bankProductService = bankProductService;
    }

    //@RequestMapping("/bankProduct")
    public String getBankProduct(){
        return "redirect:/index";
    }

    @RequestMapping("/bankProduct/{id}")
    public String getBankProductById(@PathVariable Integer id, Model model){

        model.addAttribute("bankProduct", bankProductService.getBankProduct(id));

        return "bankProduct";
    }
}
