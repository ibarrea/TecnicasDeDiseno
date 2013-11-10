package com.grupo13.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import com.grupo13.idto.IDtoTest;
import com.grupo13.view.ResultOutputter;

/* Clase ReportSaver: Recibe los resultados de un TestSuite por medio de un DTO
 * y lo guarda en un archivo.
 * */
public class ReportSaver extends ResultOutputter {
	
	public void save () {


	}

	@Override
	public void produceResult() {
		PrintWriter writer = null;
		java.util.Date date= new java.util.Date();
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HHmmss");
		try {
			String fileName = "testResult-" + dateFormater.format(date) + ".txt";
			File file = new File("testLogs/" + fileName);
			file.getParentFile().mkdirs();
			writer = new PrintWriter(file, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.println("Run: " + data.getNumberOfTestCase());
		writer.println("Errors: " + data.getNumberOfErrors());
		writer.println("Failures: " + data.getNumberOfFailures());
		data.setPath("");
		writer.println(data.getMessage());
		writer.close();
		
	}
	

}
