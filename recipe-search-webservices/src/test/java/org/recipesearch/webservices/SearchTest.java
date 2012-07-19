package org.recipesearch.webservices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.parancoe.web.test.BaseTest;
import org.recipesearch.core.webservices.Search;

public class SearchTest{ // extends BaseTest {
	private static String endpointUrl;
	private static Search searchClient;
	
	//@BeforeClass
	public static void beforeClass() throws MalformedURLException {
		endpointUrl = System.getProperty("service.url");

		if (endpointUrl != null) {
			QName serviceName = new QName(endpointUrl, "SearchService");
			URL wsdlURL = new URL(endpointUrl + "?wsdl");
			Service service = Service.create(wsdlURL, serviceName);
			searchClient = service.getPort(Search.class);
		}

	}


	protected void onSetUp() throws Exception {
		endpointUrl = System.getProperty("service.url");
		// create service

	}

	//@Test
	public void testPing() throws Exception {
		/*
		 * URL wsdlURL = new URL("http://localhost/hello?wsdl"); Service service
		 * = Service.create(wsdlURL, new QName("HelloService"));
		 * Dispatch<Source> disp = service.createDispatch(new
		 * QName("HelloPort"), Source.class, Service.Mode.PAYLOAD);
		 * 
		 * Source request = new StreamSource("<hello/>") Source response =
		 * disp.invoke(request);
		 */

		if (searchClient == null) {
			return;
		}

		String echoString = searchClient.echo("Test");
		org.junit.Assert.assertTrue("echo test", "Test".equals(echoString));
	}

}
