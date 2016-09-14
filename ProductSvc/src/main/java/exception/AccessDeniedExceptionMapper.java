package exception;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.security.access.AccessDeniedException;

import dto.ExceptionPojo;

public class AccessDeniedExceptionMapper implements ExceptionMapper<AccessDeniedException> {

	public Response toResponse(AccessDeniedException arg0) {
		ExceptionPojo pojo = new ExceptionPojo();
		pojo.setStatusID(arg0.getMessage());
		pojo.setStatusMessage(arg0.getMessage());
		return Response.ok(pojo, MediaType.APPLICATION_XML).build();
	}

}
