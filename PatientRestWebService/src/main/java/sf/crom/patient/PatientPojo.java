package sf.crom.patient;

import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
@XmlRootElement(name="Patient")
public class PatientPojo {
int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
String name;
}
