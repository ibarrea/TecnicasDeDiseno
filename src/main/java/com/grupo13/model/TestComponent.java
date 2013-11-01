package com.grupo13.model;

public abstract class TestComponent {
	
	protected String name;
	protected boolean isOK;
	protected boolean hasErrors;
	
	public abstract void run();
	
	public abstract void start();

	public boolean isHasErrors() {
		return hasErrors;
	}

	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isValid() {
		return !name.equals("");
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

}
