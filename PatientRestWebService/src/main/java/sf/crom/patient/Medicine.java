package sf.crom.patient;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@Path("/medicine")
public class Medicine {
String medicineID;
String medicineName;
public String getMedicineID() {
	return medicineID;
}
public void setMedicineID(String medicineID) {
	this.medicineID = medicineID;
}
public String getMedicineName() {
	return medicineName;
}
public void setMedicineName(String medicineName) {
	this.medicineName = medicineName;
}


}
