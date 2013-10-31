package com.grupo13.model;

import java.util.ArrayList;
import java.util.List;

public abstract class TestSuite extends TestComponent {
	
	private List<TestComponent> components = new ArrayList<TestComponent>();

	@Override
	public void setup() {

	}

	@Override
	public void tearDown() {

	}
	
	public void addTestComponent(TestComponent component){
		components.add(component);
	}
	

}
