package sf.crom.services;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface MyMathInterface {
	public @WebResult(name="result") int sum(@WebParam(name="a") int a, @WebParam(name="b") int b);
}
