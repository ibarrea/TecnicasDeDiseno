package com.grupo13.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import java.util.List;
import com.grupo13.model.TestResult;


public class TestReport extends JTextArea{
        

    private static final long serialVersionUID = 1L;
    
    private boolean isOkAllTest = true;
    private int countFail = 0;
    private int countAllTest = 0;
    
    private final String OK   = new String("OK  ");
    private final String FAIL = new String("FAIL");
    
    public TestReport(){
        setBackground(Color.white);                
        setFont(new Font("Consolas",Font.CENTER_BASELINE, 16));
        setForeground(Color.darkGray);
    }
    
    public void addItems(List<TestResult> tests){
        int Index = 1;
        String status;
        countAllTest = tests.size();
        for (TestResult testFail : tests) {
        	status = getStatus(testFail.isOK());
            if(Index > 1) {
            	setText(getText() + "\n");
            }
            setText(getText() +
            	Index++ + ". Status: " +
            	status + " Method: " +
            	testFail.getName() + " Messenger: " +
              	testFail.getMessage() + "  ");
        }
    }
    
    public boolean isOKAllTest(){
        return isOkAllTest;
    }
    
    public int getCountTestFail(){
        return countFail;
    }
    
    public int getCountAllTest(){
        return countAllTest;
    }
    
    private String getStatus(boolean isOk){
        if(isOk){
            return OK;
        }
        isOkAllTest = false;
        countFail++;
        return FAIL;
    }
}