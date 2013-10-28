package com.grupo13.view;

import java.awt.Color;
import javax.swing.JPanel;

public class StatusBar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int high = 50;
	private int width;
	
	public StatusBar(int width){
		setLayout(null);
		this.width = width;
	}
	
	public void validState(){
		setBackground(Color.GREEN);
	}
	
	public void failedState(){
		setBackground(Color.RED);
	}
	
	public void setPosition(int positionX, int positionY){
		setBounds(positionX,positionY - high,width,high);
	}
	
}