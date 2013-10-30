package com.grupo13.view;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.grupo13.iview.IViewTestCase;
import com.grupo13.iview.IShowViewTestCase;
import com.grupo13.model.TestResult;

public class ViewTestCase extends JPanel implements IViewTestCase{

	private static final long serialVersionUID = 1L;
	private final int high     =  300;
	private final int highBody =  high/2;
	private final int width    = 800;
	private final int bleeding = 50;
	private final int padding  = 20;

	private Label headerText = new Label("Passed all Test/s");
	private StatusBar statusBar = new StatusBar(width);
	private TestReport testReport = new TestReport();
	private JScrollPane viewTestReport = new JScrollPane (testReport);

	
	public ViewTestCase(List<TestResult> testResults){
		iniComponentViewTestCase();
		setViewTestCase(testResults);
		addComponentViewTestCase();
	}


	public void setPosition(int positionX, int positionY){
		setBounds(positionX,positionY,width,high);
	}
	
	public View prepareViewTestCase(){
		return new View(this);
	}
	
	private void iniComponentViewTestCase(){
		setLayout(null);
		setBackground(Color.WHITE);
		headerText.setPosition(bleeding, 0);
		statusBar.setPosition(0, high);
		viewTestReport.setBounds(bleeding,bleeding,width - bleeding - padding, highBody);
	}


	private void addComponentViewTestCase(){
		add(headerText);
		add(statusBar);
		add(viewTestReport);
	}
	

	private void setViewTestCase(List<TestResult> testResults){
		testReport.addItems(testResults);
		if(testReport.isOKAllTest()){
			statusBar.validState();
		//	scrpllPane.setVisible(false);
		}
		else{
			statusBar.failedState();
			headerText.setText("Passed: "   +
				(testReport.getCountAllTest() -
				testReport.getCountTestFail()) + "/" +
				testReport.getCountAllTest() + " Test/s");
		}
	}
	

	
	private class View extends JFrame implements IShowViewTestCase{

		private static final long serialVersionUID = 1L;

		public View(ViewTestCase viewTestCase){
			setLayout(null);
			setTitle(" Test Case");
			viewTestCase.setPosition(0, 0);
			add(viewTestCase);
		}
		
		public void showViewTestCase(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0,0,width,high);
			setResizable(false);
			setVisible(true);
		}
	}
	
}
