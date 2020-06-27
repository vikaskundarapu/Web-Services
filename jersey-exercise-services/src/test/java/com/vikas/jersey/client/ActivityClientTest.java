package com.vikas.jersey.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vikas.jersey.model.Activity;

public class ActivityClientTest {

	private ActivityClient client;

	@Before
	public void setUp() throws Exception {
		client = new ActivityClient();
	}

	@Test
	public void testGetActivity() {
		Activity response = client.getActivity("1234");
		assertNotNull(response);
	}

	@Test
	public void testGetActivities() {
		List<Activity> activities = client.getActivities();
		System.out.println(activities);
		assertNotNull(activities);
	}

	@Test(expected = RuntimeException.class)
	public void testGetActivityBadRequest() {
		client.getActivity("132");
	}

	@Test(expected = RuntimeException.class)
	public void testGetActivityIllegalRequest() {
		client.getActivity("7777");
	}

	@Test
	public void createActivity() {
		Activity activity = new Activity();
		activity.setDescription("Jumping Jacks");
		activity.setDuration(12);

		activity = client.create(activity);
		assertNotNull(activity);
		assertEquals("5555", activity.getId());
	}

	@Test
	public void updateActivity() {
		Activity activity = new Activity();
		activity.setDescription("Pushups");
		activity.setDuration(22);
		activity.setId("1241");

		activity = client.update(activity);
		assertNotNull(activity);
	}
	
	@Test
	public void delete() {
		client.delete("1234");
	}

}
