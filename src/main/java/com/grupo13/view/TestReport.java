package com.grupo13.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import java.util.List;
import com.grupo13.model.TestCase;


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
    
    public void addItems(List<TestCase> tests){
        int Index = 1;
        String status;
        String msg;
        countAllTest = tests.size();
        for (TestCase testFail : tests) {
        	status = getStatus(testFail.isOK());
        	msg = testFail.isOK()?"":" Message: " +testFail.getMessage();
            if(Index > 1) {
            	setText(getText() + "\n");
            }
            setText(getText() +
            	Index++ + ". Status: " +
            	status + " Method: " +
            	testFail.getName() + msg + "   ");
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