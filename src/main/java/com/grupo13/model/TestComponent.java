package com.grupo13.model;

import java.util.List;

import org.jdom.Element;

/* TestComponent: Representa el componente genérico del patrón Composite,
 * de esta clase heredan TestSuite y TestCase
 * */

public abstract class TestComponent {
	
	protected String name;
	protected List<String> tags;
	protected boolean isOK;
	protected boolean error;
	protected boolean executed;
	protected boolean skipped;
	
	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
	
	

	public abstract List<String> getTags();

	public abstract void setTags(List<String> tags) ;
	
	public abstract void addTag(String tag);

	public TestComponent() {
		isOK = true;
		error = false;
		executed = false;
	}

	public abstract void run();
	
	public abstract void start();

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
	
	public abstract Integer count();
	public abstract Integer countErrors();
	public abstract Integer countFailures();
	public abstract Integer countSkipped();
	public abstract String toString();
	public abstract Element toXMLElement();

}
