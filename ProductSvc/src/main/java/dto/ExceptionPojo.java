package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExceptionPojo {

	String statusID;
	String statusMessage;
	public String getStatusID() {
		return statusID;
	}
	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
