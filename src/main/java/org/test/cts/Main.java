package org.test.cts;

import java.net.URI;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.BasicProject;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.api.domain.User;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;
 
/**
 * Entry-point invoked when the jar is executed.
 */
public class Main
{
    private static final String JIRA_URL = "https://amitchaudhary.atlassian.net";
    private static final String JIRA_ADMIN_USERNAME = "amit";
    private static final String JIRA_ADMIN_PASSWORD = "abcd@1234";
    
    private static final String jql = "issue in issueHistory() AND assignee = currentUser()";
     
    public static void main(String[] args) throws Exception
    {
    	final  JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
    	final   URI uri = new URI(JIRA_URL);
    	final  JiraRestClient restClient = factory.createWithBasicHttpAuthentication(uri, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD);
    	try{
    	final   Promise<User> promise = restClient.getUserClient().getUser("amit");
    	final  User user = promise.claim();
    	final  Promise<SearchResult>  searchresule=restClient.getSearchClient().searchJql(jql);
    	final  SearchResult reult=  searchresule.claim();
    	 System.out.println(reult);
    	final   Promise<Issue> promiseIssue = restClient.getIssueClient().getIssue("ATS-6");
    	
    	final  Issue issue = promiseIssue.claim();
    	System.out.println(issue);
       
        
        for (BasicProject project : restClient.getProjectClient().getAllProjects().claim()) {
            System.out.println(project.getKey() + ": " + project.getName());
        }
  
        System.out.println("some TEST-1 details " + issue.getAssignee() + "   " + issue.getSummary() + "  " + issue.getWorklogs());
    	}finally {
            restClient.close();
        }
}
}