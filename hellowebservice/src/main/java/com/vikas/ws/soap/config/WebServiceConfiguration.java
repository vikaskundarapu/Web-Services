package com.vikas.ws.soap.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vikas.ws.soap.HelloWs;

@Configuration
public class WebServiceConfiguration {
	@Autowired
	Bus bus;

	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new HelloWs());
		endpoint.publish("/hello");
		return endpoint;
	}

}
