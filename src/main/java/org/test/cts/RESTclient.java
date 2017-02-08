package org.test.cts;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class RESTclient {
	
	private static final String JIRA_URL = "https://amitchaudhary.atlassian.net";
    private static final String JIRA_ADMIN_USERNAME = "amit";
    private static final String JIRA_ADMIN_PASSWORD = "abcd@1234";

	public static void main(String[] args) {
		try {

			Client client = Client.create();			
			client.addFilter(new HTTPBasicAuthFilter(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD));
			WebResource webResource = client.resource(JIRA_URL);			
			String input="{\"fields\":{\"project\":{\"key\":\"JIRA\"},\"summary\":\"Test Ticket\",\"description\":\"This is a test CR\", \"reporter\": {\"name\": \"prasad\"},\"issuetype\":{\"name\":\"Defect\"},\"versions\":[{\"name\":\"1.0\"}],\"customfield_10692\":{\"value\":\"Stability\"},\"customfield_10430\":{\"value\":\"Stability\"},\"customfield_10005\":{\"value\":\"Blocker\"},\"components\":[{\"name\":\"TEST\"}]}}";		
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
	
			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
	
}