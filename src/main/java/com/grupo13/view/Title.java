package com.grupo13.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Title extends JLabel {

	private static final long serialVersionUID = 1L;
	private int high = 20;
	private int width;
	private final int PORCENT = 10;

	public Title(String text) {
		setLayout(null);
		setText(text);
		dimension(text);
		setFont(new Font("Consolas", 0, 16));
		setForeground(Color.BLACK);
	}

	public void setPosition(int positionX, int positionY) {
		setBounds(positionX, positionY, width, high);
	}

	private void dimension(String text) {
		width = text.length() + text.length() * PORCENT;
	}
}
