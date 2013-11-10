package com.grupo13.model;

import org.jdom.Element;

/* TestComponent: Representa el componente genérico del patrón Composite,
 * de esta clase heredan TestSuite y TestCase
 * */

public abstract class TestComponent {
	
	protected String name;
	protected boolean isOK;
	protected boolean error;
	protected boolean executed;
	
	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}

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
	
	public abstract int count();
	public abstract int countErrors();
	public abstract int countFailures();
	public abstract String toString();
	public abstract Element toXMLElement();

}
