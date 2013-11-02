package com.grupo13.model;

public abstract class TestComponent {
	
	protected String name;
	protected boolean isOK;
	protected boolean error;
	protected boolean finished;
	
	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
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
