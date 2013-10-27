package com.view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.iview.IPanel;
import com.iview.ITestView;
import com.model.TestFail;

public class Panel extends JPanel implements IPanel{
	private int high  = 300;
	private int width = 800;
	
	private Label headerText;
	private StatusBar statusBar = new StatusBar(width);
	private TestConsole testConsole = new TestConsole();
	
	public Panel(ArrayList<TestFail> tests, int total){
		setLayout(null);
		setBackground(Color.WHITE);
		if(tests.size() != 0){
			headerText = new Label("Passed: " + (total - tests.size())
					+ "/" + total + " Test/s");
			addPanelFailed();
			addItems(tests);
		}
		else{
			headerText = new Label("Passed all Test/s");
			addPanelValid();
		}
		addHeader();	
	}

	
	public void setPosition(int positionX, int positionY){
		setBounds(positionX,positionY,width,high);
	}
	
	public View createTestView(){
		return new View(this, high, width);
	}
	
	private void addHeader(){
		headerText.setPosition(40, 0);
		add(headerText);
	}
	
	private void addPanelFailed(){
		statusBar.setPosition(0, high);
		statusBar.failedState();
		add(statusBar);
	}
	
	private void addPanelValid(){
		statusBar.setPosition(0, high);
		statusBar.validState();
		add(statusBar);
	}
	
	private void addItems(ArrayList<TestFail> tests){
		JScrollPane scrpllPane = new JScrollPane (testConsole);
		scrpllPane.setBounds(0,40,width,200);
		add(scrpllPane);
		testConsole.addItems(tests);
	}


	
	class View extends JFrame implements ITestView{
		private int high;
		private int width;
		private Panel panel;

		public View(Panel panel, int high, int width){
			this.high = high;
			this.width = width;
			setLayout(null);
			panel.setPosition(0, 0);
			this.panel = panel;
			add(panel);
		}
		
		public void showTestView(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0,0,width,high);
			setResizable(false);
			setVisible(true);
		}
	}
	
}
