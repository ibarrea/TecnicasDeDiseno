package com.view;

import javax.swing.JLabel;

public class Label extends JLabel{
	private int high = 20;
	private int width;
	
	public Label(String text){
		setLayout(null);
		setText(text);
		dimension(text);
	}
	
	public void setPosition(int positionX, int positionY){
		setBounds(positionX,positionY,width,high);
	}
	
	private void dimension(String text){
		width = text.length() + text.length() * 5;
	}
}
