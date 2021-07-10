package com.bsg.data.extractor.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bsg.data.extractor.commands.DbCommand;
import com.bsg.data.extractor.commands.LoginCommand;
import com.bsg.data.extractor.services.TestDbService;
import com.bsg.data.extractor.services.BsgExtractorService;


@Controller
public class LoginController {
	private final static String defaultOutput = "D:\\apps\\bsg\\bsg-data-extractor\\output\\";
	@Autowired
	TestDbService testDbService;
	
	@Autowired
	BsgExtractorService dataExtractorService;
	
	@RequestMapping("/")
    public String showDefaultLoginForm(Model model){

        model.addAttribute("loginCommand", new LoginCommand());

        return "login";
    }
	
    @RequestMapping("/login")
    public String showLoginForm(Model model){

        model.addAttribute("loginCommand", new LoginCommand());

        return "login";
    }

    @RequestMapping("logoutSuccess")
    public String yourLoggedOut(){

        return "logoutSuccess";
    }

  //  @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(@Valid LoginCommand loginCommand, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "login";
        }

        return "redirect:index";
    }
    
    @RequestMapping("/upload")
    public String upload(Model model){
    	DbCommand dbCommand = new DbCommand();
    	dbCommand.setOutput(defaultOutput);
    	dbCommand.setMessage("Select folder");
    	dbCommand.setError("0");
    	model.addAttribute("standardDate", new Date());
    	model.addAttribute("dbCommand", dbCommand);
        return "dataExtractor";
    }
    
    
    @RequestMapping("home")
    public String home(Model model){
    	DbCommand dbCommand = new DbCommand();
    	dbCommand.setOutput(defaultOutput);
    	dbCommand.setMessage("Select folder");
    	dbCommand.setError("0");
    	model.addAttribute("standardDate", new Date());
    	model.addAttribute("dbCommand", dbCommand);
        return "dbConfigForm";
    }
    
    @SuppressWarnings("unused")
	@RequestMapping(value = "/dataExtractor", method = RequestMethod.POST)
    public String bindResults(@Valid DbCommand dbCommand, BindingResult bindingResult, Model model){
    	dbCommand.setError("0");
        if (bindingResult.hasErrors()) {
        	dbCommand = reset(dbCommand);
        	dbCommand.setOutput(defaultOutput);
        	dbCommand.setMessage("Select folder");
        	dbCommand.setError("0");
        	model.addAttribute("standardDate", new Date());
        	model.addAttribute("dbCommand", dbCommand);
            return "dbConfigForm";
        }
        String jdbcurl = replaceSpaces(dbCommand.getJdbcurl());
        String username = replaceSpaces(dbCommand.getUsername());
        String password = replaceSpaces(dbCommand.getPassword());
        String output = replaceSpaces(dbCommand.getOutput());
        boolean isValidDbConnection = testDbService.isValidDbConnection(jdbcurl, username, password);
        if(!isValidDbConnection) {
        	dbCommand.setOutput(defaultOutput);
        	dbCommand.setMessage("Select folder");
        	dbCommand.setPassword("");
        	dbCommand.setError("1");
        	model.addAttribute("standardDate", new Date());
        	model.addAttribute("dbCommand", dbCommand);
        	return "dbConfigForm";
        } else {
        	boolean isCompleted = false;//dataExtractorService.dataExtractor(jdbcurl, username, password, output);
        	dbCommand.setError(isCompleted ? "2" : "1");
        	if(isCompleted) {
        		dbCommand = reset(dbCommand);
        	}
        	dbCommand.setOutput(defaultOutput);
        	dbCommand.setMessage("Select folder");
        	model.addAttribute("standardDate", new Date());
        	model.addAttribute("dbCommand", dbCommand);
        	return "dbConfigForm";
        }
        
    }
    
    @SuppressWarnings("unused")
	private String getCurrentDate() {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");  
        Date date = new Date();  
        return formatter.format(date);
    }
    
    private String replaceSpaces(String input) {
    	input = StringUtils.isEmpty(input) ? "" : input;
    	input = input.replace(" ", "");
    	input = input.replace("\t", "");
    	input = input.replace("\r\n", "");
    	input = input.replace("\n", "");
    	return input;
    }
    private DbCommand reset(DbCommand dbCommand) {
    	dbCommand.setJdbcurl("");
    	dbCommand.setHost("");
    	dbCommand.setPort("");
    	dbCommand.setDbname("");
    	dbCommand.setUsername("");
    	dbCommand.setPassword("");
    	dbCommand.setOutput(defaultOutput);
    	return dbCommand;
    }
    
    @RequestMapping(value = "/system-exit")
    public void disconnect(){
    	System.exit(0);
    }
}
