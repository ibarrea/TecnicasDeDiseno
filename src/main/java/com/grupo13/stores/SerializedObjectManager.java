package com.grupo13.stores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.grupo13.model.TestComponent;

public class SerializedObjectManager extends PersistenceManager {

	private static String fileName = "testLogs/testResult-serializedObjectFormat.data";
	
	@Override
	public void storeResult() {
		// Write to disk with FileOutputStream
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Write object with ObjectOutputStream
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Write object out to disk
		try {
			objectOutputStream.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public TestComponent loadResult() {
		// Read from disk using FileInputStream
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Read object using ObjectInputStream
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Read an object
		Object obj = null;
		try {
			obj = objectInputStream.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (obj instanceof TestComponent) {
			data = (TestComponent) obj;
		}
		
		return data;
	}
}
