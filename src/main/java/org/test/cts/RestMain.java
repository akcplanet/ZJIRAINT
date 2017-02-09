package org.test.cts;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;


public class RestMain {
	
    private static final String JIRA_URL = "https://amitchaudhary.atlassian.net";
    private static final String JIRA_ADMIN_USERNAME = "amit";
    private static final String JIRA_ADMIN_PASSWORD = "abcd@1234";

	public static void main(String[] args) throws IOException {

		        String stringUrl = "https://amitchaudhary.atlassian.net/rest/api/2/project/10000";
		        URL url = new URL(stringUrl);
		        URLConnection uc = url.openConnection();

		        uc.setRequestProperty("X-Requested-With", "Curl");
		        String userpass = JIRA_ADMIN_USERNAME + ":" + JIRA_ADMIN_PASSWORD;
		        String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
		        uc.setRequestProperty("Authorization", basicAuth);

		        InputStreamReader inputStreamReader = new InputStreamReader(uc.getInputStream());
		        // read this input
		        System.out.println(inputStreamReader);

		    }
	}


