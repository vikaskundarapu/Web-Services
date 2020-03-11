package com.vikas.restws;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import com.vikas.restws.modal.ChecksList;

@Path("/checkprocessingservice")
public interface CheckProcessor {

	@POST
	@Path("/checks")
	public void processChecks(@Suspended AsyncResponse asyncResponse,ChecksList checkslist);
}
