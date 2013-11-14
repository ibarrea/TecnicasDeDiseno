package com.grupo13.results;

import com.grupo13.view.ViewTestSuite;
import com.grupo13.view.iview.IViewTestSuite;

/* Clase ResultViewer: Recibe los resultados de un TestSuite
 * y lo muestra en una ventana gráfica. Hereda de ResultOutputter siendo un patron Strategy.
 * */

public class ResultViewer extends ResultOutputter {

	@Override
	public void produceResult() {
		IViewTestSuite iviewTestSuite = new ViewTestSuite(data);
		iviewTestSuite.prepareViewTestSuite().showViewTestSuite();
	}

}
