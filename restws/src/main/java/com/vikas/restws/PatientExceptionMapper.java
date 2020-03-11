package com.vikas.restws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.vikas.restws.exceptions.PatientBusinessException;

@Provider
public class PatientExceptionMapper implements ExceptionMapper<PatientBusinessException> {

	@Override
	public Response toResponse(PatientBusinessException exception) {
		StringBuilder s = new StringBuilder();
		s.append("{");
		s.append("\"status\":\"error\"");
		s.append(",");
		s.append("\"message\":\"Please try again later\"");
		s.append("}");
		return Response.serverError().entity(s.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
