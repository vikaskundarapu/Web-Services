package com.vikas.jersey.repository;

import java.util.List;

import com.vikas.jersey.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	Activity createActivity(Activity activity);

	Activity updateActivity(Activity activity);

	void deleteActivity(String activityId);

}