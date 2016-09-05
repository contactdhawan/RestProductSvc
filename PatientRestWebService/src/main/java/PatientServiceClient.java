import javax.ws.rs.core.MediaType;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import sf.crom.patient.PatientPojo;


public class PatientServiceClient {

	public static final String PATIENT_SERVICE_URL="http://localhost:8090/PatientRestWebService/services/patients";
	public static void main(String args[]){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PATIENT_SERVICE_URL).path("/patient").path("/{id}").resolveTemplate("id", 0);
		PatientPojo patientPojo = target.request().get(PatientPojo.class);
		System.out.println("old Patient name "+patientPojo.getName());
		patientPojo.setName("Neeraj12345");
		WebTarget putTarget = client.target(PATIENT_SERVICE_URL).path("/patient");
		Response putResponse = putTarget.request().put(Entity.entity(patientPojo, MediaType.APPLICATION_XML));
		System.out.println(putResponse.getStatus());
		
		WebTarget getTarget = client.target(PATIENT_SERVICE_URL).path("/patient").path("{id}").resolveTemplate("id", 0);
		PatientPojo newPatient = getTarget.request().get(PatientPojo.class);
		System.out.println("New Patient name : "+newPatient.getName());
		
		
		//Create a new patient
		PatientPojo newPostPatient = new PatientPojo();
		newPostPatient.setName("NOPatient");
		WebTarget postWebTarget = client.target(PATIENT_SERVICE_URL).path("/patient");
		PatientPojo postResponse = postWebTarget.request().post(Entity.entity(newPostPatient, MediaType.APPLICATION_XML),PatientPojo.class);
		System.out.println("New patient posted "+postResponse.getId()+" "+postResponse.getName());
		
		//Delete patient
		WebTarget deleteTarget = client.target(PATIENT_SERVICE_URL).path("/patient").path("{id}").resolveTemplate("id", 0);
		Response deleteReponse = deleteTarget.request().delete();
		System.out.println("Delete response "+deleteReponse.getStatus());
		
	}
}
