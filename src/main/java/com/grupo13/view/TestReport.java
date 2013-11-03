package com.grupo13.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

import java.util.List;

import com.grupo13.mock.idto.IDtoTest;
import com.grupo13.model.TestCase;

public class TestReport extends JTextArea {

	private static final long serialVersionUID = 1L;

	private boolean isOkAllTestCase = true;
	private int numberOfErrors = 0;
	private int numberOfFailures = 0;
	private int countAllTestCase = 0;

	private final String OK = new String("OK  ");
	private final String FAIL = new String("FAIL");

	public TestReport() {
		setBackground(Color.white);
		setFont(new Font("Consolas", Font.CENTER_BASELINE, 16));
		setForeground(Color.darkGray);
	}

	public void addItems(IDtoTest iDtoTest) {
		setText(iDtoTest.getMessage(""));
		numberOfErrors = iDtoTest.getNumberOfErrors();
		numberOfFailures = iDtoTest.getNumberOfFailures();
		countAllTestCase = iDtoTest.getNumberOfTestCase();
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

	public int getCountAllTestCase() {
		return countAllTestCase;
	}
	
	public int getCountAllOkTestCase() {
		return countAllTestCase - numberOfErrors - numberOfFailures;
	}

}