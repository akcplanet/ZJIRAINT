package org.jira.rest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ReadingFIle {
	
	public static void main(String[] args) throws IOException {
		
		try (Stream<String> lines = Files.lines(Paths.get("JIRA_KEY_STORE"), StandardCharsets.UTF_8))
		{
			  lines.forEachOrdered(u -> System.out.println("\t" + u));
		}
		List<JiraDetails> persons = Arrays.asList(new JiraDetails("scenarioName","storyID","subtaskID","testId"),
				new JiraDetails("scenarioName1","storyID1","subtaskID1","testId1"), new JiraDetails("scenarioName2","storyID2","subtaskID2","testId2"));
		String name = persons.stream()
				.filter(x -> "scenarioName".equals(x.getScenarioName()))
				.map(JiraDetails::getScenarioName)						//convert stream to String
				.findAny()
				.orElse("");
	    System.out.println(name);
	    @SuppressWarnings("resource")
		Scanner scanner = new Scanner(new FileReader("JIRA_KEY_STORE"));
	    Map<String, JiraDetails> JiraMap = new LinkedHashMap<String, JiraDetails>();
	    String line;
	   /* while (scanner.hasNext()) {
	    	line = scanner.next();
	    	 String[] columns = line.split(Pattern.quote("|"));
	    	 System.out.println(columns.length);
	            String scenarioName = columns[0];
	            System.out.println(scenarioName);
	            String  storyID = columns[1];
	            System.out.println(storyID);   
	            String  subtaskID = columns[2];
	            System.out.println(subtaskID);
	            if(columns.length==4){
	            String  testId = columns[3];
	            System.out.println(testId);
	            }
	            JiraMap.put(scenarioName, new JiraDetails(scenarioName,storyID,subtaskID,testId));
	    }*/
      
	    }

	}	


