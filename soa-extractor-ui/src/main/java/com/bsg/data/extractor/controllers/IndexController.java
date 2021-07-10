package com.bsg.data.extractor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bsg.data.extractor.services.BsgProductService;


@Controller
public class IndexController {

    @SuppressWarnings("unused")
	private BsgProductService bankProductService;

    @Autowired
    public void setProductService(BsgProductService bankProductService) {
        this.bankProductService = bankProductService;
    }

/*    @RequestMapping({"/", "login"})
    public String getIndex(Model model){

        model.addAttribute("bankProducts", bankProductService.listBankProducts());

        return "login";
    }*/

   
}
