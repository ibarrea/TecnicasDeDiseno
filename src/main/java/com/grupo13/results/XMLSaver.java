package com.grupo13.results;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/* Clase ReportSaver: Recibe los resultados de un TestSuite
 * y lo guarda en un archivo xml. Hereda de ResultOutputter siendo un patron Strategy
 * segun el output que desee el usuario.
 * */

public class XMLSaver extends ResultOutputter {

	public void save() {

	}

	@Override
	public void produceResult() {

		try {

			Element rootElement = new Element("testsuites");
			Document doc = new Document(rootElement);
			doc.setRootElement(rootElement);

			doc.getRootElement().addContent(data.toXMLElement());

			XMLOutputter xmlOutput = new XMLOutputter();

			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter("testLogs/file.xml"));

		} catch (IOException io) {
			System.out.println(io.getMessage());
		}

	}
}