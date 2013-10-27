package com.view;

import javax.swing.JLabel;

public class Label extends JLabel{
	int high = 20;
	int width;
	
	public Label(String Text){
		setLayout(null);
		setText(Text);
		dimension(Text);
	}
	
	public void setPosition(int positionX, int positionY){
		setBounds(positionX,positionY,width,high);
	}
	
	private void dimension(String Text){
		width = Text.length() + Text.length() * 5;
	}
}
