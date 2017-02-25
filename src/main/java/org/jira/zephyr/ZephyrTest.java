package org.jira.zephyr;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.util.Base64;

public class ZephyrTest {

	public static void main(String[] args) throws Exception{
		
		 String auth = new String(Base64.encode("amit:abcd@1234"));

		Client client = ClientBuilder.newClient();
		Entity payload = Entity.json("{  'cycleId': '-1',  'issueId': '10013',  'projectId': '10000',  'versionId': '10001',  'assigneeType': 'assignee',  'assignee': 'jira_user'}");
		Response response = client.target("https://amitchaudhary.atlassian.net/rest/zapi/latest/execution")
		  .request(MediaType.APPLICATION_JSON_TYPE)
		  .post(payload);
		
		/*
		Response response = client
				.target("https://amitchaudhary.atlassian.net/rest/zapi/latest/execution")
				.request(MediaType.APPLICATION_JSON)
				.header("Accept", "application/json")
				.header("Authorization","Basic "+ auth).post(payload);*/
		

		System.out.println("status: " + response.getStatus());
		/*System.out.println("headers: " + response.getHeaders());
		System.out.println("body:" + ((Object) response).readEntity(String.class));*/
		
	}

}
