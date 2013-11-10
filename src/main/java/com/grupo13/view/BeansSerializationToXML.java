package com.grupo13.view;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;

public class BeansSerializationToXML {

	public void serializeObjectToXML(String xmlFileLocation,
    		Object objectToSerialize) throws Exception {
        FileOutputStream os = new FileOutputStream(xmlFileLocation);
        XMLEncoder encoder = new XMLEncoder(os);
        encoder.writeObject(objectToSerialize);
        encoder.close();
    }
}
