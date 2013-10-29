package com.grupo13.view;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.grupo13.iview.IPanel;
import com.grupo13.iview.ITestView;
import com.grupo13.model.TestResult;

public class Panel extends JPanel implements IPanel{

	private static final long serialVersionUID = 1L;
	private int high     =  300;
	private int highBody =  200;
	private int width    = 1000;

	private Label headerText = new Label("Passed all Test/s");
	private StatusBar statusBar = new StatusBar(width);
	private TestConsole testConsole = new TestConsole();
	private JScrollPane scrpllPane = new JScrollPane (testConsole);
	private JPanel testPass = new JPanel();

	
	public Panel(List<TestResult> tests){
		iniTestComponents();
		testConsole.addItems(tests);
		addTestPanel();
		addTestComponents();
	}


	public void setPosition(int positionX, int positionY){
		setBounds(positionX,positionY,width,high);
	}
	
	public View createTestView(){
		return new View(this, high, width);
	}
	
	private void iniTestComponents(){
		setLayout(null);
		setBackground(Color.WHITE);
		testPass.setLayout(null);
		testPass.setBackground(Color.WHITE);
		testPass.setBounds(5, 1, 20, 20);
		headerText.setPosition(40, 0);
		statusBar.setPosition(0, high);

		scrpllPane.setBounds(100,40,width - 150, highBody);
	}


	private void addTestComponents(){
		add(headerText);
		add(statusBar);
		add(scrpllPane);
		add(testPass);
	}
	

	private void addTestPanel(){
		TestImage jpg = new TestImage();
		if(testConsole.isOKAllTest()){
			testPass.add(jpg.testImageOk());
			statusBar.validState();
		}
		else{
			testPass.add(jpg.testImageFail());
			statusBar.failedState();
			headerText.setText("Passed: "   +
				(testConsole.getCountAllTest() -
				testConsole.getCountTestFail()) + "/" +
				testConsole.getCountAllTest() + " Test/s");
		}
	}
	

	
	class View extends JFrame implements ITestView{

		private static final long serialVersionUID = 1L;
		private int high;
		private int width;

		public View(Panel panel, int high, int width){
			this.high = high;
			this.width = width;
			setLayout(null);
			setTitle("TestCase");
			panel.setPosition(0, 0);
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
