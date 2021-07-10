package com.bluesprucegroup.njrealtors.csvtopdf.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bluesprucegroup.njrealtors.csvtopdf.dao.RoleDao;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.ServiceAccountDataDO;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.Role;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.User;
import com.bluesprucegroup.njrealtors.csvtopdf.domain.security.UserRole;
import com.bluesprucegroup.njrealtors.csvtopdf.jms.JmsGateway;
import com.bluesprucegroup.njrealtors.csvtopdf.service.ResponseService;
import com.bluesprucegroup.njrealtors.csvtopdf.service.TransactionService;
import com.bluesprucegroup.njrealtors.csvtopdf.service.UserService;
import com.bluesprucegroup.njrealtors.csvtopdf.util.AuditLogUtil;
import com.bluesprucegroup.njrealtors.csvtopdf.util.DataControllerUtil;

@Controller
public class DataController {

	private static final Logger log = LogManager.getLogger(DataController.class);
	
	@Value("${com.bluesprucegroup.solution.source.user.token}")
	private String userToken;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private RoleDao roleDao;
	
	@Autowired
	private ResponseService responseService;
	
	@Autowired
	private DataControllerUtil dataControllerUtil;
	
	@Autowired
	private AuditLogUtil auditLogUtil;
	
	@Autowired
	private JmsGateway jmsGateway;
	
	@Autowired
	public void setJmsGateway(JmsGateway jmsGateway) {
		this.jmsGateway = jmsGateway;	
	}
	
	
	/*
	@RequestMapping("/nj-realtors-csv-to-pdf")
	public String solutionSourceData(Principal principal, Model model) {
        @SuppressWarnings("unused")
		User user = userService.findByUsername(principal.getName());
        return "/";
    }
	*/
	
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
    public String index() {
        return "index";
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView upload() {
		return new ModelAndView("index");
	}
	
	/*@RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }*/
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }
	
	@SuppressWarnings("unused")
	//@RequestMapping(value = "/signup", method = RequestMethod.POST)
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") User user,  Model model) {
		ServiceAccountDataDO serviceAccountDataDO = null;
		try {
			if(userService.checkUserExists(user.getUsername(), user.getEmail())) {
	            model.addAttribute("emailExists", false);
	            if (userService.checkUsernameExists(user.getUsername())) {
	                model.addAttribute("usernameExists", true);
	            }
	            //return "signup";
	            return "signup";
	        } else {
	        	String userToken = user.getToken().toUpperCase();
	        	if(userToken.equals(this.userToken)) {
	        		serviceAccountDataDO = new ServiceAccountDataDO();
	        		serviceAccountDataDO.setUuid(UUID.randomUUID().toString());
	        		Role role = new Role();
	        		role.setRoleId(1);
	        		userService.createUserWithRole(user, role, serviceAccountDataDO);
	        		 return "redirect:/";
	        	} else if(userToken.equals("ROLE=USER")) {
		        	Set<UserRole> userRole = new HashSet<>();
		            userService.createUserWithRole(user, roleDao.findRoleByRoleName("User"), serviceAccountDataDO);
		            return "redirect:/";
	        	} else {
	        		return "errorSignUp";
	        	}
	        }
		} catch(Exception e) {
        	log.error(e.getMessage(), e);
        	return "redirect:/";
        }
    }
	
	
	
	
	
	
	
	
}
