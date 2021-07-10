package com.bsg.data.extractor.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter implements Filter {

	private static final Logger log = LogManager.getLogger(RequestFilter.class);
	
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        try {
	        response.setHeader("Access-Control-Allow-Origin", "http://soa.extractor.bsg.com");
	        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
	        response.setHeader("Access-Control-Max-Age", "3600");
	        response.setHeader("Access-Control-Allow-Credentials", "true");
	
	        if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
	            try {
	                chain.doFilter(req, res);
	            } catch(Exception e) {
	                log.error(e.getMessage(), e);
	            }
	        } else {
	            System.out.println("Pre-flight");
	            response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE");
	            response.setHeader("Access-Control-Max-Age", "3600");
	            response.setHeader("Access-Control-Allow-Headers", "authorization, content-type," +
	                    "access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with");
	            response.setStatus(HttpServletResponse.SC_OK);
	        }
        } catch(Exception e) {
        	log.error(e.getMessage(), e);
        }

    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}

}
