package com.grupo13.model;

import java.util.ArrayList;
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
	protected String superSuiteName;
	
	public TestComponent() {
		isOK = true;
		error = false;
		executed = false;
		skipped = false;
		tags = new ArrayList<String>();
	}
	
	public TestComponent(String superSuite) {
		isOK = true;
		error = false;
		executed = false;
		skipped = false;
		tags = new ArrayList<String>();
		superSuiteName = superSuite;
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
	
	public String getSuperSuiteName() {
		return superSuiteName;
	}

	public void setSuperSuiteName(String superSuiteName) {
		this.superSuiteName = superSuiteName;
	}
	
	public abstract Integer countTests();
	public abstract Integer countErrors();
	public abstract Integer countFailures();
	public abstract Integer countSkipped();
	public abstract String toString();
	public abstract Element toXMLElement();

	public boolean matches(List<String> tagsToExecute) {
		return tags.containsAll(tagsToExecute);
	}

	public boolean matches(String regex) {
		return (regex == null) || name.matches(regex);
	}

}
