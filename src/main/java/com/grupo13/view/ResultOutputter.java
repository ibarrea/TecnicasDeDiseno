package com.grupo13.view;

import com.grupo13.model.TestComponent;

/* ResultOutputter: El código cliente (TestSuite) conoce esta clase abstracta (Patron Strategy) e instancia
 * la estrategia con la cual quiere mostrar, dichas estrategias son clases que heredan de ResultOutputter
 * */

public abstract class ResultOutputter {

	protected TestComponent data;
	
	public void setData(TestComponent data) {
		this.data = data;
	}

	public abstract void produceResult();
}
