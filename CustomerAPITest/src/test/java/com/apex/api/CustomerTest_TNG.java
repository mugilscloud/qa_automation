package com.apex.api;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import junit.framework.Assert;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

import com.apex.bean.Customer;

public class CustomerTest_TNG {
	private static final String USER_AGENT = "Mozilla/5.0";
	String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/";

	// test status code and status message, tag exist, tag not exist, test against SCHEMA, test against data from spreadsheets---> 1
	@Test(priority = 1)
	public void testStatusCode() throws Exception {

		HttpResponse response = sendRequestAndGetResponse(url);

		
		Assert.assertEquals(response.getStatusLine().getStatusCode(),
				HttpStatus.SC_OK);
	}

	// test media type ---> 2
	@Test(priority = 2)
	public void testMediaType() throws Exception {
		String xmlMimeType = "application/xml";
		HttpResponse response = sendRequestAndGetResponse(url);

		String mimeType = ContentType.getOrDefault(response.getEntity())
				.getMimeType();
		Assert.assertEquals(xmlMimeType, mimeType);
	}

	// test xml payload ----> 3
	@Test(priority = 3)
	public void testSuccessScenario() throws Exception {

		HttpResponse response = sendRequestAndGetResponse(url + "1");

		Customer customer = getJavaObjectFromXMLMessage(response,
				Customer.class);

		Assert.assertEquals(1, customer.getId());
		Assert.assertEquals("King", customer.getLastName());
	}

	// test invalid 1 ---> 4
	@Test(priority = 4)
	public void testInvalidSpecialCharScenario() throws Exception {

		HttpResponse response = sendRequestAndGetResponse(url + "0+");

		Assert.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusLine()
				.getStatusCode());
	}

	// test invalid 2 ---> 5
	@Test(priority = 5)
	public void testInvalidSpaceNumberScenario() {

		HttpResponse response;
		try {
			response = sendRequestAndGetResponse(url + " 12");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}

	private Customer getJavaObjectFromXMLMessage(HttpResponse response,
			Class cls) throws JAXBException, IOException {
		JAXBContext jaxbContext = JAXBContext.newInstance(cls);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Customer customer = (Customer) jaxbUnmarshaller.unmarshal(response
				.getEntity().getContent());
		return customer;
	}

	// private void performStatusCodeCheck(HttpResponse response) {
	// // validate status or response code
	// Assert.assertEquals(200, response.getStatusLine().getStatusCode());
	// // validate response message
	// Assert.assertEquals("OK", response.getStatusLine().getReasonPhrase());
	// }

	private HttpResponse sendRequestAndGetResponse(String url)
			throws IOException, ClientProtocolException {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		request.addHeader("User-Agent", USER_AGENT);
		
		HttpResponse response = client.execute(request);
		return response;
	}
}
