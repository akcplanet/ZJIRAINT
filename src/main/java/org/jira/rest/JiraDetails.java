package org.jira.rest;

public class JiraDetails {
	
	private String scenarioName;
	private String storyID;
	private String subtaskID;
	private String testId;
	
	
	public JiraDetails(String scenarioName, String storyID, String subtaskID, String testId) {
		super();
		this.scenarioName = scenarioName;
		this.storyID = storyID;
		this.subtaskID = subtaskID;
		this.testId = testId;
	}
	
	public JiraDetails() {
		super();
	}



	public String getScenarioName() {
		return scenarioName;
	}
	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}
	public String getStoryID() {
		return storyID;
	}
	public void setStoryID(String storyID) {
		this.storyID = storyID;
	}
	public String getSubtaskID() {
		return subtaskID;
	}
	public void setSubtaskID(String subtaskID) {
		this.subtaskID = subtaskID;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	
	
	

}
