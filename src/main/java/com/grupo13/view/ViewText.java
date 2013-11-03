package com.grupo13.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class ViewText extends JLabel {

	private static final long serialVersionUID = 1L;
	private int high;
	private int width;

	private final String OPEN = "<html>";
	private final String CLOSE = "</html>";
	private final String OPENSECTION = "<p>"; 
	private final String CLOSESECTION = "</p>"; 
	private final String OPENBOLD = "<b>"; 
	private final String CLOSEBOLD = "</b>"; 
	
	public ViewText(int width, int high) {
		this.high = high;
		this.width = width;
		setLayout(null);
		setFont(new Font("Consolas", 0, 16));
		setForeground(Color.BLACK);
	}

	public void setPosition(int positionX, int positionY) {
		setBounds(positionX, positionY, width, high);
	}
	
	public void addTextLn(String text){
		setText(getText()+ OPENSECTION + text + CLOSESECTION);		
	}
	
	public void addTextBold(String text){
		setText(getText()+ OPENBOLD + text + CLOSEBOLD);		
	}
	
	public void openText(){
		setText(OPEN);
	}
	
	public void closeText(){
		setText(getText() + CLOSE);
	}
	
	public void addText(String text){
		setText(getText() + text);
	}

}
