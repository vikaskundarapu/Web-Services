package com.bharath.ws.soap.config;

import java.util.HashMap;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.common.WSS4JConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bharath.ws.soap.PaymentProcessorImpl;

@Configuration
public class WebServiceConfiguration {

	@Autowired
	Bus bus;

	@Bean
	public Endpoint endpoint() {

		EndpointImpl endpoint = new EndpointImpl(bus, new PaymentProcessorImpl());
		endpoint.publish("/paymentProcessor");

		HashMap<String, Object> inProps = new HashMap<>();
		inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
		inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSS4JConstants.PASSWORD_TEXT);
		inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());

		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
		endpoint.getInInterceptors().add(wssIn);
		return endpoint;
	}

}
