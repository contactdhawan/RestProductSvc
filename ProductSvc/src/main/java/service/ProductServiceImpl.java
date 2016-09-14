package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;
import org.springframework.web.context.ContextLoaderListener;
import dto.Product;
import dto.Products;

public class ProductServiceImpl implements ProductService {

	int productID=123;
	Products products;
	ProductServiceImpl(){
		init();
	}

	public void init(){
		products = new Products();
		for(int i=0;i<10;i++){
			productID= productID+1;
			Product product = new Product();
			product.setProductID(productID);
			product.setProductDesc("Description "+productID);
			products.addProduct(productID, product);
		}	
	}
	public Response addProduct(Product product) {
		System.out.println("Add product");
		productID= productID+1;
		products.addProduct(productID, product);
		return Response.ok(product).build();
	}

	public Product getProduct(int id) {
		System.out.println("get product");
		return products.getProduct(id);
	}

	public Product updateProduct(Product product) {
		System.out.println("update product");
		Product productToReturn = products.updateProduct(product);
		if(productToReturn == null){
			throw new NotFoundException();
		}
		return 	product;
	}

	public Response deleteProduct(int id) {
		System.out.println("delete product");
		return products.deleteProduct(id);

	}

	public Products getProducts() {
		System.out.println("get all products");
		return products;
	}
	//http://localhost:8090/MyRestAsyncRestService/services/productservice/products?startID=124&lastID=125
	public Products getProductByID(int startID, int lastID,String agent,HttpHeaders headers) {
		Map<String, Cookie> cookies = headers.getCookies();
		for (String cookieName : cookies.keySet()) {
			System.out.println(cookieName+" "+cookies.get(cookieName).getValue());
		}
		MultivaluedMap<String,String> requestHeaders = headers.getRequestHeaders();
		for (String headerName : requestHeaders.keySet()) {
			System.out.println(headerName+" "+requestHeaders.get(headerName));
		}

		System.out.println("Calling getProductByID "+agent);
		Products customProducts = new Products();
		for(int i=startID;i<=lastID;i++){
			Product product = products.getProduct(i);
			customProducts.addProduct(i, product);
		}
		return customProducts;
	}

	public void createProduct(String productDesc) {
		System.out.println("Creating new patients from form");
		Product product = new Product();
		productID=productID+1;
		product.setProductID(productID);
		product.setProductDesc(productDesc);
		products.addProduct(productID, product);

	}

	public void doSomeCalc(final @Suspended AsyncResponse reponse) {

		new Thread(){
			public void run(){
				for(int i=1;i<100;i++){
					try {
						Thread.sleep(300);
						System.out.println("Sleeping for sometime");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				reponse.resume(true);
			}
		}.start();

		


	}

}
