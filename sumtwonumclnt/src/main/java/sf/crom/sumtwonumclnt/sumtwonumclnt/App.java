package sf.crom.sumtwonumclnt.sumtwonumclnt;

import java.net.MalformedURLException;
import java.net.URL;

import sf.crom.services.MyMathInterface;
import sf.crom.services.MyMathInterfaceService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			MyMathInterfaceService service = new MyMathInterfaceService(new URL("http://localhost:8090/SumTwoNumbersSoap/services/sum2num?wsdl"));
			MyMathInterface myMathInterfacePort = service.getMyMathInterfacePort();
			int result = myMathInterfacePort.sum(20, 80);
			System.out.println("Result from web service "+result);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
