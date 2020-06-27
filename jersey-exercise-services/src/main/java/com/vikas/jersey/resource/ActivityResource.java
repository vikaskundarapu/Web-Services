package com.vikas.jersey.resource;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.vikas.jersey.model.Activity;
import com.vikas.jersey.model.User;
import com.vikas.jersey.repository.ActivityRepository;
import com.vikas.jersey.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityResource {

	private static final ActivityRepository ACTIVITY_REPOSITORY_STUB = new ActivityRepositoryStub();

	@DELETE
	@Path("{activityId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteActivity(@PathParam("activityId") String activityId) {
		ACTIVITY_REPOSITORY_STUB.deleteActivity(activityId);
		return Response.status(Status.OK).build();
	}

	@PUT
	@Path("{activityId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateActivity(Activity activity) {

		activity = ACTIVITY_REPOSITORY_STUB.updateActivity(activity);
		return Response.status(Status.OK).entity(activity).build();
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("activity")
	public Activity createActivity(Activity activity) {
		return ACTIVITY_REPOSITORY_STUB.createActivity(activity);
	}

	@POST
	@Path("activity")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Activity createActivityParams(MultivaluedMap<String, String> formParams) {

		Activity activity = new Activity();
		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));

		return ACTIVITY_REPOSITORY_STUB.createActivity(activity);
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Activity> getAllActivities() {
		return ACTIVITY_REPOSITORY_STUB.findAllActivities();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{activityId}")
	public Response getActivity(@PathParam(value = "activityId") String activityId) {

		if (Objects.isNull(activityId) || activityId.length() < 4) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		Activity activity = ACTIVITY_REPOSITORY_STUB.findActivity(activityId);

		if (Objects.isNull(activity)) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.status(Status.OK).entity(activity).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{activityId}/user")
	public User getActivityUser(@PathParam(value = "activityId") String activityId) {
		return ACTIVITY_REPOSITORY_STUB.findActivity(activityId).getUser();
	}

}
