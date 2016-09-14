#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package sf.crom.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sf.crom.pojo.Address;

@Controller
@Path("/hello") // this is required only for wadl

@RequestMapping("/hello")
public class HelloController {
	@GET @Produces("text/plain") @Path("/world")
	// above two lines are added for wadl
   @RequestMapping("/world")
   @ResponseBody
	public String helloWorld(){
		return "Hello Rest";
	}
	@RequestMapping("/address")
	   @ResponseBody
	public Address getAddress(){
		Address address = new Address();
		address.setCity("Bloomington");
		address.setState("IL");
		address.setZip("61704");
		return address;
	}
	 
}
