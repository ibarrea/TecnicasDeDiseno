package com.grupo13.view;

import com.grupo13.idto.IDtoTest;

public abstract class ResultOutputter {

	protected IDtoTest data;
	
	public void setData(IDtoTest data) {
		this.data = data;
	}

	public abstract void produceResult();
}
