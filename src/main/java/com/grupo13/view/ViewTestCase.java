package com.grupo13.view;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.grupo13.iview.IViewTestCase;
import com.grupo13.iview.IShowViewTestCase;
import com.grupo13.mock.idto.IDtoTest;

public class ViewTestCase extends JPanel implements IViewTestCase {

	private static final long serialVersionUID = 1L;

	private final int high = 430;
	private final int highBody = 200;
	private final int width = 800;
	private final int bleeding = 50;
	private final int padding = 20;

	private ViewText headerText = new ViewText(400, 20);
	private ViewText description = new ViewText(400, 120);
	private StatusBar statusBar = new StatusBar(width);
	private TestReport testReport = new TestReport();
	private JScrollPane viewTestReport = new JScrollPane(testReport);

	public ViewTestCase(IDtoTest iDtoTest) {
		iniComponentViewTestCase();
		setViewTestCase(iDtoTest);
		addComponentViewTestCase();
		addDescription();
	}

	public void setPosition(int positionX, int positionY) {
		setBounds(positionX, positionY, width, high);
	}

	public View prepareViewTestCase() {
		return new View(this);
	}

	private void iniComponentViewTestCase() {
		setLayout(null);
		setBackground(Color.WHITE);
		headerText.openText();
		headerText.setPosition(bleeding, padding);
		headerText.addText("Test results");
		headerText.closeText();
		statusBar.setPosition(0, high);
		viewTestReport.setBounds(bleeding, bleeding, width - bleeding - padding, highBody);
		description.openText();
		description.setPosition(bleeding, highBody + bleeding);
	}

	private void addComponentViewTestCase() {
		add(headerText);
		add(statusBar);
		add(viewTestReport);
		add(description);
	}

	private void setViewTestCase(IDtoTest iDtoTest) {
		testReport.addItems(iDtoTest);
		if (testReport.isOKAllTest()) {
			statusBar.validState();
			description.addText("[");
			description.addTextBold("success");
			description.addText("]");
		} else {
			statusBar.failedState();
			description.addText("[");
			description.addTextBold("failure");
			description.addText("]");
		}
		description.addText(" Summary");
		description.addTextLn("=================");
	}
	
	private void addDescription(){
		description.addTextLn("Run : " + testReport.getCountAllTestCase());
		description.addTextLn("Errors : " + testReport.getNumberOfErrors());
		description.addTextLn("Failures: " + testReport.getNumberOfFailures());
		description.closeText();
	}

	private class View extends JFrame implements IShowViewTestCase {

		private static final long serialVersionUID = 1L;

		public View(ViewTestCase viewTestCase) {
			setLayout(null);
			setTitle(" Test Case");
			viewTestCase.setPosition(0, 0);
			add(viewTestCase);
		}

		public void showViewTestCase() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0, 0, width, high);
			setResizable(false);
			setVisible(true);
		}
	}

}