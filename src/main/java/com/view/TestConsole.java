package com.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import java.util.ArrayList;
import com.model.TestFail;


public class TestConsole extends JTextArea{
	
	public TestConsole(){
		setBackground(Color.BLACK);		
		setFont(new Font("Consolas",Font.CENTER_BASELINE, 16));
		setForeground(Color.WHITE);
	}
	
	public void addItems(ArrayList<TestFail> tests){
		int fallo = 1;
		for (TestFail testFail : tests) {
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