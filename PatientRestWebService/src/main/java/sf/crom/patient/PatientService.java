package sf.crom.patient;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Produces({"application/xml","application/json"})
public interface PatientService {

	@GET
	@Path("/patient/{patientId}")
	public PatientPojo getPatient(@PathParam(value="patientId")int patienId);
	
	@POST
	@Path("/patient")
	public Response addPatient(PatientPojo patient);
	
	@PUT
	@Path("/patient/")
	public Response updatePatient(PatientPojo patient);
	
	@DELETE
	@Path("/patient/{patientId}")
	public Response deletePatient(@PathParam(value="patientId")int patientId);
	
	
	@Path("/prescription/{prescriptionID}")
	Prescription getPrescription(@PathParam(value="prescriptionID")String prescriptionID);
	//http://localhost:8090/PatientRestWebService/services/patients/patientsize?start=1&size=10
	@GET
	@Path("/patientsize/")
	public void displayQueryParameters(@QueryParam("start")String start,@QueryParam("size")String size);
	
	// http://localhost:8090/PatientRestWebService/PatientAdd.html
	@POST
	@Path("/patientForm")
	public void printFormParam(@FormParam("fname")String firstName,@FormParam("lname")String lastName);
@GET
@Path("/headerInfo")
public void printHeaderInfo(@HeaderParam("agent")String agnetName,@Context HttpHeaders httpHeaders);
}
