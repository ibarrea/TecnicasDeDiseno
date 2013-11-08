package com.grupo13.model;

import java.util.ArrayList;
import java.util.List;

import com.grupo13.dto.DtoTestCase;
import com.grupo13.dto.DtoTestSuite;
import com.grupo13.idto.IDtoTest;


/* Clase TestCase: Almacena informacion de los tests individuales que definió
 * el cliente y que son ejecutados dentro del método run() de TestSuite.
 * Almacena una lista de Assertion que son las ejecutadas dentro del test.
 * */
public class TestCase extends TestComponent {

	private String message;
	private List<Assertion> assertions = new ArrayList<Assertion>();

	public List<Assertion> getAssertions() {
		return assertions;
	}

	public TestCase(String name) {
		super();
		this.name = name;
		message = "Ok!";
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		int allowedNameLength = 40;
		int maxLength = (name.length() < allowedNameLength) ? name.length() : allowedNameLength;
		String inputString = name.substring(0, maxLength);
		String msg = isOK() ? "Pass" :(hasError()?"Error":"Failed");
		return String.format("%1$-" + allowedNameLength + "s", inputString) + "|"
				+ String.format("%1$-" + 10 + "s", msg)
				+ "|" + String.format("%1$-" + 30 + "s", message);
	}

	@Override
	public void run() {
		throw new UnsupportedOperationException();

	}

	@Override
	public void start() {
		setExecuted(true);
		for (Assertion assertion : assertions) {
			if (!assertion.isOk()) {
				setMessage(assertion.getMessage());
				setError(assertion.hasError());
				setOK(false);
				return;
			}
		}
		//LLamar al singleton y pasarle un DtoTestCase y pedirle porfavor q lo imprima por consola

	}

	@Override
	public void loadDTO(IDtoTest dto) {
		IDtoTest dtoTestCase = new DtoTestCase(hasError(),isOK(),toString());
		((DtoTestSuite) dto).add(dtoTestCase);
		
	}
	
	public boolean isTestCase() {
		return true;
	}
}
