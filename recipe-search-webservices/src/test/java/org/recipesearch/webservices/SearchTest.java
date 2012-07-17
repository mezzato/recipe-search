package org.recipesearch.webservices;

import org.junit.BeforeClass;
import org.junit.Test;

public class SearchTest {
	private static String endpointUrl;
	
	@BeforeClass
	public static void beforeClass() {
		endpointUrl = System.getProperty("service.url");
	}
	
	@Test
	public void testPing() throws Exception {
		/*
		URL wsdlURL = new URL("http://localhost/hello?wsdl");
		Service service = Service.create(wsdlURL, new QName("HelloService"));
		Dispatch<Source> disp = service.createDispatch(new QName("HelloPort"), Source.class, Service.Mode.PAYLOAD);

		Source request = new StreamSource("<hello/>")
		Source response = disp.invoke(request);
		*/
	}
	
}
