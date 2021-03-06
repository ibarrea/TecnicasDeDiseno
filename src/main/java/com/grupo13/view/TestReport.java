package com.grupo13.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import com.grupo13.model.TestComponent;

public class TestReport extends JTextArea {

	private static final long serialVersionUID = 1L;

	private boolean isOkAllTestCase = true;
	private int numberOfErrors = 0;
	private int numberOfFailures = 0;
	private int countAllTestCase = 0;

	public TestReport() {
		setBackground(Color.white);
		setFont(new Font("Consolas", Font.CENTER_BASELINE, 16));
		setForeground(Color.darkGray);
	}

	public void addItems(TestComponent test) {
		setText(test.toString());
		numberOfErrors = test.countErrors();
		numberOfFailures = test.countFailures();
		countAllTestCase = test.countTests();
		if(numberOfErrors + numberOfFailures != 0){
			isOkAllTestCase = false;
		}
	}

	public boolean isOKAllTest() {
		return isOkAllTestCase;
	}

	public int getNumberOfErrors() {
		return numberOfErrors;
	}
	
	public int getNumberOfFailures() {
		return numberOfFailures;
	}

	public int getCountAllTestCase() {
		return countAllTestCase;
	}
	
	public int getCountAllOkTestCase() {
		return countAllTestCase - numberOfErrors - numberOfFailures;
	}

}