package com.grupo13.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TestImage extends JLabel{

	private static final long serialVersionUID = 1L;
	private String imageOk   = 
			new String("./src/main/java/com/grupo13/resources/TestOk.jpg");
	private String imageFail = 
			new String("./src/main/java/com/grupo13/resources/TestFail.jpg");
	
	public TestImage(){
		setBounds(0, 0, 20, 20);
	}
	
	public TestImage testImageOk(){
		ImageIcon testImage = new ImageIcon(imageOk);
		setIcon(testImage);
		return this;
	}
	
	public TestImage testImageFail(){
		ImageIcon testImage = new ImageIcon(imageFail);
		setIcon(testImage);
		return this;
	}

}
