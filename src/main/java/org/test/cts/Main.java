package org.test.cts;

import java.net.URI;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
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
        // Construct the JRJC client
        System.out.println(String.format("Logging in to %s with username '%s' and password '%s'", JIRA_URL, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD));
        JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
        URI uri = new URI(JIRA_URL);
        JiraRestClient client = factory.createWithBasicHttpAuthentication(uri, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD);
        // Invoke the JRJC Client
        Promise<User> promise = client.getUserClient().getUser("amit");
        User user = promise.claim();
        Promise<SearchResult>  searchresule=client.getSearchClient().searchJql(jql);
        SearchResult reult=  searchresule.claim();
        Promise<Issue> promiseIssue = client.getIssueClient().getIssue("ATS-6");
        Issue issue = promiseIssue.claim();
         
        // Print the result
        System.out.println(String.format("Your admin user's email address is: %s\r\n", user.getEmailAddress()));
         
        // Print the result
        System.out.println("some TEST-1 details " + issue.getAssignee() + "   " + issue.getSummary() + "  " + issue.getWorklogs());
        // Done
        System.out.println("Example complete. Now exiting.");
        System.exit(0);
    }
}