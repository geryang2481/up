package com.bsg.data.extractor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bsg.data.extractor.commands.DisconnectCommand;

import javax.validation.Valid;

@Controller
public class DisconnectController {

    @RequestMapping("/disconnect")
    public String disconnectForm(Model model){

        model.addAttribute("disconnectCommand", new DisconnectCommand());

        return "disconnectForm";
    }

    @RequestMapping(value = "/doDisconnect", method = RequestMethod.POST)
    public String doDisconnect(@Valid DisconnectCommand disconnectCommand, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "disconnectForm";
        }

        return "disconnectComplete";

    }

}
