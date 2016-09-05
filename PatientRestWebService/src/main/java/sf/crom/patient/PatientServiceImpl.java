package sf.crom.patient;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class PatientServiceImpl implements PatientService {

	Map<Integer,PatientPojo> Patients = new HashMap<Integer,PatientPojo>();
	Map<String,Prescription> prescriptionMap = new HashMap<String,Prescription>();
	int patientID = 0;

	public PatientServiceImpl(){
		PatientPojo patient = new PatientPojo();
		patient.setId( patientID);
		patient.setName("Neeraj");
		Patients.put(patientID, patient);	

		Medicine medicine = new Medicine();
		medicine.setMedicineID("456");
		medicine.setMedicineName("OrelG");

		Medicine medicine2 = new Medicine();
		medicine2.setMedicineID("456");
		medicine2.setMedicineName("OrelG");

		List<Medicine> medicineList = new ArrayList<Medicine>();
		medicineList.add(medicine);
		medicineList.add(medicine2);
		Prescription prescription = new Prescription();
		prescription.setPrescriptionID(String.valueOf(patientID));
		prescription.setMedicineList(medicineList);
		prescriptionMap.put(String.valueOf(patientID),prescription);
	}
	@Override
	public Response updatePatient(PatientPojo patient) {
		System.out.println("Updating patient "+patient.getId());
		if(Patients.containsKey(patient.getId())){
			Patients.put(patient.getId(), patient);
			return Response.ok(patient).build();
		}else{
			return Response.status(Status.NOT_FOUND).build();
		}



	}

	@Override
	public Response deletePatient(int patientId) {
		System.out.println("Deleting Patient "+patientId);
		PatientPojo patientToBeDelted = Patients.get(patientId);
		if(patientToBeDelted==null){
			throw new SomeException("Cannot delete as patient does not exists");
		}
		Patients.remove(patientId);
		return Response.ok().build();
	}

	@Override
	public PatientPojo getPatient(int patienId) {
		System.out.println("Retrieving Patient "+patienId);
		PatientPojo patient = (PatientPojo) Patients.get(patienId);
		if(patient==null){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return patient;
	}

	@Override
	public Response addPatient(PatientPojo patient) {
		int nextPatientID=patientID+1;
		patientID=nextPatientID;
		patient.setId(nextPatientID);
		System.out.println("Adding new patient "+patientID);
		Patients.put(nextPatientID, patient);

		return Response.ok(patient).build();

	}
	@Override
	public Prescription getPrescription(String prescriptionID) {
		System.out.println("Getting the prescription id"+prescriptionID);
		Prescription pp = null;
		if(prescriptionMap.keySet().contains(prescriptionID)){
			pp = prescriptionMap.get(prescriptionID);	
		}
		return pp;
	}
	@Override
	public void displayQueryParameters(String start, String size) {
		System.out.println("Start "+start);
		System.out.println("size"+size);
	}
	@Override
	public void printFormParam(String firstName, String lastName) {
		System.out.println("First Name from form "+firstName);
		System.out.println("Last Name from form "+lastName);
	}
	@Override
	public void printHeaderInfo(String agnetName, HttpHeaders httpHeaders) {
		System.out.println("agent name from header is "+agnetName);
		MultivaluedMap<String, String> requestHeaders = httpHeaders.getRequestHeaders();
		Set<String> keySet = requestHeaders.keySet();
		for(String eachHeader:keySet){
			System.out.println("Header value "+httpHeaders.getHeaderString(eachHeader));
		}
		
		Map<String, Cookie> cookies = httpHeaders.getCookies();
		Set<String> names = cookies.keySet();
		for(String name:names){
			Cookie cookie = cookies.get(name);
			System.out.println(cookie.getName()+" "+cookie.getValue());
		}
		
	}

}
