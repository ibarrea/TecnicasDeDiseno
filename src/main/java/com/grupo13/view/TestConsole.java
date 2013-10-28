package com.grupo13.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

import java.util.ArrayList;

import com.grupo13.model.TestResult;


public class TestConsole extends JTextArea{
	
	public TestConsole(){
		setBackground(Color.BLACK);		
		setFont(new Font("Consolas",Font.CENTER_BASELINE, 16));
		setForeground(Color.WHITE);
	}
	
	public void addItems(ArrayList<TestResult> tests){
		int fallo = 1;
		for (TestResult testFail : tests) {
			if(fallo > 1) {
				setText(getText() + "\n");
			}
			setText(getText()                               + 
				fallo++                  + ". NameMethod: " +
				testFail.getName()       + ", Messenger: "  + 
				testFail.getMessenger()  + "   ");
		}
	}
}
