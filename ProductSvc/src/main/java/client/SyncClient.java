package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dto.Product;
import dto.Products;

public class SyncClient {
	public static String basicURL = "http://localhost:8090/MyRestAsyncRestService/services/productservice";
	private Response delete;
	private static Client client;

	public static void main(String args[]) {
		client = ClientBuilder.newClient();

		SyncClient syncClient = new SyncClient();
		syncClient.getAllProducts();

	}

	public void addProduct() {
		Product myProduct = new Product();
		myProduct.setProductID(200);
		myProduct.setProductDesc("200 Desc");
		WebTarget target = client.target(basicURL).path("/product");
		Response response = target.request().post(
				Entity.entity(myProduct, MediaType.APPLICATION_JSON));
		System.out.println("Product added " + response.getStatus());
	}

	public void getProductByID() {
		String productID = "124";
		WebTarget target = client.target(basicURL).path("/product")
				.path("/{id}").resolveTemplate("id", productID);
		Product product = target.request().get(Product.class);
		System.out.println(product.getProductID() + "\t"
				+ product.getProductDesc());
	}

	public void deleteProduct() {
		int productID = 124;

		WebTarget target = client.target(basicURL).path("/product")
				.path("/{id}").resolveTemplate("id", productID);
		delete = target.request().delete();
		System.out.println("Delete Response " + delete);

	}

	public void updateProduct() {
		Product updateThisProduct = new Product();
		updateThisProduct.setProductID(125);
		updateThisProduct.setProductDesc("new description");
		WebTarget target = client.target(basicURL).path("/product");
		Response response = target.request().put(
				Entity.entity(updateThisProduct, MediaType.APPLICATION_JSON));
		System.out.println("Product updated successfully...");
	}
	
	public void getAllProducts(){
		WebTarget target = client.target(basicURL).path("/products");
		Products products = target.request().get(Products.class);
		System.out.println(products.getProductList().size());
		
	}

}