package exception;

import javax.ws.rs.core.MediaType;
import org.springframework.web.filter.DelegatingFilterProxy;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import dto.ExceptionPojo;

@Provider
public class SFExceptionMapper implements ExceptionMapper<SFCustomException> {

	public Response toResponse(SFCustomException e) {
		ExceptionPojo exceptionPojo = new ExceptionPojo();
		exceptionPojo.setStatusID("SF Status ID");
		exceptionPojo.setStatusMessage(e.getMessage());

		return Response.ok(exceptionPojo, MediaType.APPLICATION_XML).build();
	}

}
