package com.bluesprucegroup.njrealtors.csvtopdf.jms.impl;

import javax.jms.MessageListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * This is the queue listener class, its receiveMessage() method ios invoked with the
 * message as the parameter.
 */
@Component
public class JmsMessageListener {

	@SuppressWarnings("unused")
	private static final Logger log = LogManager.getLogger(MessageListener.class);
	
	/**
    * This method is invoked whenever any new message is put in the queue.
    * See {@link guru.springframework.SpringBootActiveMQApplication} for more details
    * @param message
    
   @JmsListener(destination = ServiceAccountDataApplication.PRODUCT_MESSAGE_QUEUE, containerFactory = "jmsFactory")
   public void receiveMessage(String message) {
       log.info("ActiveMQ ---->  Received <" + message + ">");
       log.info("ActiveMQ ----> " + "Message processed...");
       log.debug("Debugging log");
       log.info("Info log");
       log.warn("Hey, This is a warning!");
       log.error("Oops! We have an Error. OK");
       log.fatal("Damn! Fatal error. Please fix me.");
   }*/
}
