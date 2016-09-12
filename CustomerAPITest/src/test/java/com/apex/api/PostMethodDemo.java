package com.apex.api;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

public class PostMethodDemo {
  @Test
  public void testPost() throws Exception {
	  String url = "http://www.a-domain.com/foo/";
	  HttpClient httpClient = HttpClientBuilder.create().build();
	  HttpPost httpPost = new HttpPost(url);
	  
	  List<NameValuePair> myList = new ArrayList<NameValuePair>();
	  myList.add(new BasicNameValuePair("param-1", "12345"));
	  myList.add(new BasicNameValuePair("param-2", "Hello!"));

	  httpPost.setEntity(new UrlEncodedFormEntity(myList));
	  HttpResponse httpResponse = httpClient.execute(httpPost);
	  HttpEntity entity1 = httpResponse.getEntity();
	  
	  System.out.println("Http code: " + httpResponse.getStatusLine().getStatusCode());
	  System.out.println("Http entity: " +httpResponse.getEntity());
  }
}
