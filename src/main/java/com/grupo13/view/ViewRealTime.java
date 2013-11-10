package com.grupo13.view;

public enum ViewRealTime {
    INSTANCE;

	public void println(String line)
	{
	   System.out.println(line);
	}
	
	public void print(String line)
	{
	   System.out.print(line);
	}
	
	public void printTab(String line)
	{
	   System.out.printf("\t%s",line);
	}
	
	public void printTabln(String line)
	{
	   System.out.printf("\t%s\n",line);
	}
	
	public void printContent(String line)
	{
	   System.out.printf("(%s)",line);
	}
	
	public void printContentln(String line)
	{
	   System.out.printf("(%s)\n",line);
	}
}
