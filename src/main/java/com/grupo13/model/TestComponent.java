package com.grupo13.model;

import com.grupo13.idto.IDtoTest;

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
	
	public abstract void loadDTO(IDtoTest dto);

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

}
