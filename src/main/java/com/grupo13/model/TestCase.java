package com.grupo13.model;

import java.util.ArrayList;
import java.util.List;

import com.grupo13.mock.dto.DtoTestCase;
import com.grupo13.mock.dto.DtoTestSuite;
import com.grupo13.mock.idto.IDtoTest;

public class TestCase extends TestComponent {

	private String message;
	private List<Assertion> assertions = new ArrayList<Assertion>();

	public List<Assertion> getAssertions() {
		return assertions;
	}

	public TestCase(String name) {
		super();
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String toString() {
		// int maxLength = (inputString.length() <
		// MAX_CHAR)?inputString.length():MAX_CHAR;
		// inputString = inputString.substring(0, maxLength);
		return String.format("%1$-" + 55 + "s", name) + "|"
				+ String.format("%1$-" + 10 + "s", isOK() ? "Pass" : "Failed")
				+ "|" + String.format("%1$-" + 30 + "s", message);
	}

	@Override
	public void run() {
		throw new UnsupportedOperationException();

	}

	@Override
	public void start() {
		for (Assertion assertion : assertions) {
			if (!assertion.isOk() || assertion.hasError()) {
				setMessage(assertion.getMessage());
				setError(assertion.hasError());
				setOK(false);
				return;
			}
		}

	}

	@Override
	public void loadDTO(IDtoTest dto) {
		// TODO Auto-generated method stub
		IDtoTest dtoTestSuite2 = new DtoTestCase(getMessage());
		((DtoTestSuite) dto).add(dtoTestSuite2);
		
	}
}
