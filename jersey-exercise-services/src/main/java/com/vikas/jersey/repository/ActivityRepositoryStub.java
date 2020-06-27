package com.vikas.jersey.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.vikas.jersey.model.Activity;
import com.vikas.jersey.model.User;

public class ActivityRepositoryStub implements ActivityRepository {

	@Override
	public void deleteActivity(String activityId) {
		// Delete the activity with identifier as activityId
	}
	
	@Override
	public Activity updateActivity(Activity activity) {
		// Check if the activity exists in the db
		// if it exits, update the record
		// else create a new activity record

		return activity;
	}

	@Override
	public Activity createActivity(Activity activity) {
		System.out.println(activity);
		activity.setId("5555");
		return activity;
	}

	@Override
	public List<Activity> findAllActivities() {
		List<Activity> activities = new ArrayList<Activity>();

		Activity activityOne = new Activity();
		activityOne.setDescription("Swimming");
		activityOne.setDuration(50);
		activities.add(activityOne);

		Activity activitytwo = new Activity();
		activitytwo.setDescription("Cycling");
		activitytwo.setDuration(120);

		activities.add(activitytwo);

		return activities;
	}

	@Override
	public Activity findActivity(String activityId) {

		if (Objects.isNull(activityId) || activityId.equals("7777")) {
			return null;
		}

		Activity activityOne = new Activity();
		activityOne.setId("1234");
		activityOne.setDescription("Swimming");
		activityOne.setDuration(50);
		User user = new User();
		user.setId("1");
		user.setName("Vikas");
		activityOne.setUser(user);
		return activityOne;
	}

}
