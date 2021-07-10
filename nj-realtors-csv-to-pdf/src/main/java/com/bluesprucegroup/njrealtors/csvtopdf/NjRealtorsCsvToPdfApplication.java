package com.bluesprucegroup.njrealtors.csvtopdf;

import java.net.InetAddress;

import javax.jms.ConnectionFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@SpringBootApplication
public class NjRealtorsCsvToPdfApplication implements ApplicationListener<ApplicationReadyEvent> {
	
	@SuppressWarnings("unused")
	@Autowired
    private ApplicationContext applicationContext;
	
	public final static String PRODUCT_MESSAGE_QUEUE = "nj-realtors-csv-to-pdf-controller-process";
	private static final Logger log = LogManager.getLogger(NjRealtorsCsvToPdfApplication.class);
	
	@Bean
    public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        //factory.
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some of Boot's default if necessary.
        return factory;
    }
	 
	public static void main(String[] args) {
		
		try {
			log.info("SpringApplication.run(NjRealtorsCsvToPdfApplication.class, args) Started");
			SpringApplication.run(NjRealtorsCsvToPdfApplication.class, args);
		} catch(Exception e) {
			log.error("NjRealtorsCsvToPdfApplication.Main(String[] args)", e);
		}
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		try {
			byte[] address = InetAddress.getLocalHost().getAddress();
	        String hostName = InetAddress.getLocalHost().getHostAddress();
	        String canonicalHostName = InetAddress.getLocalHost().getCanonicalHostName();
	        //int port = applicationContext.getBean(Environment.class).getProperty("server.port", Integer.class, 8080);
	        log.info("NjRealtorsCsvToPdfApplication is running on: " + "Address=" + address + ", HostName=" + hostName + ", CanonicalHostName=" + canonicalHostName);
		} catch(Exception e) {
			log.error(this.getClass(), e);
		}
		
	}

	
}
