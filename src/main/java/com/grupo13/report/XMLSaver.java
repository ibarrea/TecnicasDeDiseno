package com.grupo13.report;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.grupo13.view.ResultOutputter;

public class XMLSaver extends ResultOutputter {

	public void save() {

	}

	@Override
	public void produceResult() {

		try {

			Element company = new Element("testsuites");
			Document doc = new Document(company);
			doc.setRootElement(company);

			doc.getRootElement().addContent(data.toXMLElement());

			XMLOutputter xmlOutput = new XMLOutputter();

			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter("testLogs/file.xml"));

		} catch (IOException io) {
			System.out.println(io.getMessage());
		}

	}
}
