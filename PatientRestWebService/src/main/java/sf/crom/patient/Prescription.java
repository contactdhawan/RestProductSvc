package sf.crom.patient;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Prescription {
String prescriptionID;
List<Medicine> medicineList;
public String getPrescriptionID() {
	return prescriptionID;
}
public void setPrescriptionID(String prescriptionID) {
	this.prescriptionID = prescriptionID;
}
@GET
@Path("/medicines")
public List<Medicine> getMedicineList() {
	System.out.println("In medicine list");
	return medicineList;
}
public void setMedicineList(List<Medicine> medicineList) {
	this.medicineList = medicineList;
}
@GET
@Path("/medicines/{id}")
public Medicine getMedicine(@PathParam(value="id")String medicineID){
	System.out.println("In medicines"+medicineID);
	Medicine returnvalue=null;
	for(Medicine m:medicineList){
		if(m.getMedicineID().equals(medicineID)){
			returnvalue= m;
		}
	}
	return returnvalue;
}

}
