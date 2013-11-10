package com.grupo13.view;

import com.grupo13.iview.IViewTestSuite;

public class ResultView extends ResultOutputter {

	@Override
	public void produceResult() {
		IViewTestSuite iviewTestSuite = new ViewTestSuite(data);
		iviewTestSuite.prepareViewTestSuite().showViewTestSuite();
	}

}
