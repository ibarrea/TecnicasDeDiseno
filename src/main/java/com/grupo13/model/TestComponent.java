package com.grupo13.model;

import com.grupo13.mock.idto.IDtoTest;

public abstract class TestComponent {
	
	protected String name;
	protected boolean isOK;
	protected boolean error;
	
	public TestComponent() {
		this.isOK = true;
		this.error = false;
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
	
	

}
