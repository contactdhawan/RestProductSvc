package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	int productID;
	String productDesc;
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
}
