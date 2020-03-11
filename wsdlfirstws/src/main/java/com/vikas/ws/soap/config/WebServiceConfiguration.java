package com.vikas.ws.soap.config;

import java.util.ArrayList;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vikas.ws.soap.CustomerOrdersWsImpl;
import com.vikas.ws.soap.handlers.SiteHandler;

@Configuration
public class WebServiceConfiguration {

	@Autowired
	Bus bus;

	@Bean
	public Endpoint endpoint() {

		Endpoint endpoint = new EndpointImpl(bus, new CustomerOrdersWsImpl());
		endpoint.publish("/customerordersservice");
		
		SOAPBinding binding =  (SOAPBinding) endpoint.getBinding();
		
		ArrayList<Handler> handlerChain = new ArrayList<>();
		handlerChain.add(new SiteHandler());
		binding.setHandlerChain(handlerChain);
		return endpoint;
	}

}
