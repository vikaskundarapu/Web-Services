package com.vikas.restws;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class CheckProcessorClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/restasync/services/checkprocessingservice/checks");
		AsyncInvoker invoker = target.request().async();
		Future<Boolean> response = invoker.post(Entity.entity(new ChecksList(), MediaType.APPLICATION_XML),
				Boolean.class);
		try {
			System.out.println(response.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			if (e.getCause() instanceof BadRequestException) {
				BadRequestException bre = (BadRequestException) e.getCause();
				System.out.println(bre.getMessage());
				System.out.println("Please send in the valid request details!");
			}

		}
	}

}
