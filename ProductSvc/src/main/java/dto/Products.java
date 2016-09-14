package dto;

import java.util.HashMap;
import exception.*;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.access.annotation.Secured;

@XmlRootElement
public class Products {

	Map<Integer,Product> productList = new HashMap<Integer,Product>();



	public void addProduct(int id,Product product){
		productList.put(id, product);
	}

	public Response deleteProduct(int id){
		if(!productList.keySet().contains(id)){
			throw new SFCustomException("Unable to Find ID");
		}
		productList.remove(id);
		return Response.ok().build();
		
	}

	
	public Product getProduct(int id){
		Product product = productList.get(id);
		if(product==null){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return product;
	}

	public Product updateProduct(Product product){
		int productID=product.getProductID();
		if(productList.keySet().contains(productID)){
			productList.put(productID, product);}
		else{
			product=null;
		}
		return product;
	}
	public Map<Integer, Product> getProductList() {
		return productList;
	}

	public void setProductList(Map<Integer, Product> productList) {
		this.productList = productList;
	}



}
