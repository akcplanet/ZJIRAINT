package org.test.cts;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class RESTclient {
	
	private static final String JIRA_URL = "http://localhost:9090/rest/zapi/latest/cycle";
    private static final String JIRA_ADMIN_USERNAME = "amit";
    private static final String JIRA_ADMIN_PASSWORD = "abcd@1234";

	public static void main(String[] args) {
		try {

			Client client = Client.create();			
			client.addFilter(new HTTPBasicAuthFilter(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD));
			WebResource webResource = client.resource(JIRA_URL);			
			
			String input= "{  \"clonedCycleId\": \"\",  \"name\": \"TESTED cycle unscheduled version with sprint\",  \"build\": \"\",  \"environment\": \"\",  \"description\": \"Create cycle with sprint\",  \"startDate\": \"4/Dec/12\",  \"endDate\": \"30/Dec/15\",  \"projectId\": \"10000\",  \"versionId\": \"-1\"}";

			
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
	
			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
	
}