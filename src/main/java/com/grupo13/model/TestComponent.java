package com.grupo13.model;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

/* TestComponent: Representa el componente gen�rico del patr�n Composite,
 * de esta clase heredan TestSuite y TestCase
 * */

public abstract class TestComponent {
	
	protected String name;
	protected List<String> tags;
	protected boolean isOK;
	protected boolean error;
	protected boolean executed;
	protected boolean skipped;
	protected String superSuiteName;
	protected Long timeOutError;
	Long startTime;
	Long ellapsedTime;
		
	public TestComponent() {
		init();
	}
	
	public TestComponent(String superSuite) {
		init();
		superSuiteName = superSuite;
	}
	
	private void init() {
		isOK = true;
		error = false;
		executed = false;
		skipped = false;
		tags = new ArrayList<String>();
		ellapsedTime = new Long(0);
		timeOutError = new Long(1000);		
	}
	
	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
	
	public abstract void skip();
	

	public List<String> getTags() {
		return tags;
	}

	protected void addTag(String tag) {
		tags.add(tag);
	}

	protected void endTimer() {
		ellapsedTime = System.currentTimeMillis() - startTime;
	}

	protected void startTimer() {
		startTime = System.currentTimeMillis();
	}

	public boolean hasError() {
		return error;
	}

	public void setError(boolean hasErrors) {
		this.error = hasErrors;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}
	
	public boolean isTestCase() {
		return false;
	}
	
	public String getSuperSuiteName() {
		return superSuiteName;
	}

	public void setSuperSuiteName(String superSuiteName) {
		this.superSuiteName = superSuiteName;
	}
	
	public boolean matches(List<String> tagsToExecute) {
		return tags.containsAll(tagsToExecute);
	}

	public boolean matches(String regex) {
		return (regex == null) || name.matches(regex);
	}

	protected void setTimeOutError(Long timeOut) {
		timeOutError = timeOut;
	}

	protected Long getTimeOutError() {
		return timeOutError;
	}
	
	public abstract void run();	
	public abstract void start();
	public abstract Integer countTests();
	public abstract Integer countErrors();
	public abstract Integer countFailures();
	public abstract Integer countSkipped();
	public abstract String toString();
	public abstract Element toXMLElement();
}
