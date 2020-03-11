package com.vikas.restwsclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vikas.restwsclient.model.Patient;

public class PatientWsClient {

	private static final String PATIENTS = "/patients";
	private static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice";

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PATIENT_SERVICE_URL).path(PATIENTS).path("/{id}").resolveTemplate("id", 132);
		Builder request = target.request();
		// Response response = request.get();
		Patient patient = request.get(Patient.class);
		System.out.println(patient);
		patient.setName("Vikas");

		WebTarget putTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
		Response updateResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
		System.out.println(updateResponse.getStatus());
		updateResponse.close();

		Patient patient2 = new Patient();
		patient2.setName("RandomGuy");

		WebTarget postTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
		Patient createdPatient = postTarget.request().post(Entity.entity(patient2, MediaType.APPLICATION_XML),
				Patient.class);
		System.out.println(createdPatient);

		WebTarget deleteTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS).path("/{id}").resolveTemplate("id",
				134);
		Response deleteResponse = deleteTarget.request().delete();
		System.out.println(deleteResponse.getStatus());
		deleteResponse.close();
		client.close();
	}

}
