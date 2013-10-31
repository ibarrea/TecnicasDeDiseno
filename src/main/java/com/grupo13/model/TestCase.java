package com.grupo13.model;

import com.grupo13.iview.IViewTestCase;
import com.grupo13.view.ViewTestCase;

public abstract class TestCase extends BaseTestCase {
	
	public void start() {
		super.start();
		showTest();
	}
	
	
	private void showTest(){
		IViewTestCase iviewTestCase = new ViewTestCase(assertManager.getResultList());
		iviewTestCase.prepareViewTestCase().showViewTestCase();
	}

}
