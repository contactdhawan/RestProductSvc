package sf.crom.patient;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RestExceptionMapper implements ExceptionMapper<SomeException> {

	@Override
	public Response toResponse(SomeException arg0) {
		StringBuilder builder = new StringBuilder("<response>");
		builder.append("<status>ERROR</status>");
		builder.append("<message> "+arg0+" </message>>");
		
		builder.append("</response>");
		
		return Response.serverError().entity(builder.toString()).type(MediaType.APPLICATION_XML).build();
	}

}
