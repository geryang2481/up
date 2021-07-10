package com.bluesprucegroup.njrealtors.csvtopdf.jms.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.bluesprucegroup.njrealtors.csvtopdf.NjRealtorsCsvToPdfApplication;
import com.bluesprucegroup.njrealtors.csvtopdf.jms.JmsGateway;

@Service
public class JmsGatewayImpl implements JmsGateway {
	private static final Logger log = LogManager.getLogger(JmsGatewayImpl.class);

	private JmsTemplate jmsTemplate;
	
	@Autowired
	public JmsGatewayImpl(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	@Override
	public void sendMessage(String message) {
		log.info("Sending the index request through queue message: " + message);
        jmsTemplate.convertAndSend(NjRealtorsCsvToPdfApplication.PRODUCT_MESSAGE_QUEUE, "Hello ActiveMQ!" + message);
    
	}

}
