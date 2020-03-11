package com.vikas.ws.saop.config;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vikas.ws.saop.FileWsImpl;

@Configuration
public class WebServiceConfiguration {

	@Autowired
	Bus bus;

	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new FileWsImpl());
		endpoint.publish("/fileWs");

		// MTOM is by default not enabled. We need to get the binding from endpoint and
		// enable that
		SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
		binding.setMTOMEnabled(Boolean.TRUE);
		return endpoint;
	}

}
