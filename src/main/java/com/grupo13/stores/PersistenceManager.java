package com.grupo13.stores;

import java.io.Serializable;

import com.grupo13.model.TestComponent;

public abstract class PersistenceManager implements Serializable {

	protected TestComponent data;
	
	public void setData(TestComponent data) {
		this.data = data;
	}

	public abstract void storeResult();
	public abstract TestComponent loadResult();
}
