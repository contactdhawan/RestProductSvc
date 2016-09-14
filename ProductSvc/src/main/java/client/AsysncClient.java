package client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class AsysncClient {

	public static void main(String args[]){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8090/MyRestAsyncRestService/services/productservice/someCalc");
		AsyncInvoker async = target.request().async();
		Future<Response> future = async.get();
		try {
			System.out.println(future.get().getStatus());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
