package com.grupo13.view;

import com.grupo13.model.TestComponent;

public abstract class ResultOutputter {

	protected TestComponent data;
	
	public void setData(TestComponent data) {
		this.data = data;
	}

	public abstract void produceResult();
}
