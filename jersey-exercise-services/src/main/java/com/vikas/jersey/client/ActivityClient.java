package com.vikas.jersey.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.vikas.jersey.model.Activity;

public class ActivityClient {

	private static final String ACTIVITY_URL = "http://localhost:8080/jersey-exercise-services/webapi/";
	private final Client client;
	private final WebTarget target;

	public ActivityClient() {
		client = ClientBuilder.newClient();
		target = client.target(ACTIVITY_URL);
	}

	public Activity getActivity(String activityId) {

//		By default the translations are in xml, if the response type is String
		String stringResponseXml = target.path("activities/" + activityId).request().get(String.class);
//		 We can configure to get a json response using MediaType in request() method
		String stringResponseJson = target.path("activities/" + activityId).request(MediaType.APPLICATION_JSON)
				.get(String.class);

		Response response = target.path("activities/" + activityId).request(MediaType.APPLICATION_JSON)
				.get(Response.class);

		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(response.getStatus() + " Error occurred!");
		}

		return response.readEntity(Activity.class);
	}

	public List<Activity> getActivities() {
		List<Activity> reponse = target.path("activities").request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Activity>>() {
				});

		return reponse;

	}

	public Activity create(Activity activity) {

		Response response = target.path("activities/activity").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON));

		return response.readEntity(Activity.class);
	}

	public Activity update(Activity activity) {

		Response response = target.path("activities/" + activity.getId()).request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(activity, MediaType.APPLICATION_JSON));

		return response.readEntity(Activity.class);
	}

	public void delete(String activityId) {
		Response response = target.path("activities/" + activityId).request(MediaType.APPLICATION_JSON).delete();

		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(response.getStatus() + " Error occurred!");
		}

	}

}
