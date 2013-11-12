package com.grupo13.model;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

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
		tags = new ArrayList<String>();
		message = "Ok!";
	}
	
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		int allowedNameLength = 40;
		int maxLength = (name.length() < allowedNameLength) ? name.length()
				: allowedNameLength;
		String inputString = name.substring(0, maxLength);
		String msg = status();
		return String.format("%1$-" + allowedNameLength + "s", inputString)
				+ "|" + String.format("%1$-" + 10 + "s", msg) + "|"
				+ String.format("%1$-" + 30 + "s", message);
	}

	private String status() {
		return isOK() ? "Pass" : (hasError() ? "Error" : "Failed");
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
		// LLamar al singleton y pasarle un DtoTestCase y pedirle porfavor q lo
		// imprima por consola

	}

	public boolean isTestCase() {
		return true;
	}

	@Override
	public Integer count() {
		return 1;
	}

	@Override
	public Integer countErrors() {
		return (error) ? 1 : 0;
	}

	@Override
	public Integer countFailures() {
		return ((!isOK) && (!error)) ? 1 : 0;
	}

	@Override
	public Element toXMLElement() {
		Element element = new Element("testcase");
		element.setAttribute("name", getName());
		element.setAttribute("status", status());
		element.addContent(new Element("skipped").setText(countSkipped().toString()));
		if (error) {
			Element error = new Element("error");
			error.setAttribute(new Attribute("message", message));
			element.addContent(error);

		} else if ((!isOK) && (!error)) {
			Element failure = new Element("failure");
			failure.setAttribute(new Attribute("message", message));
			element.addContent(failure);

		}
		return element;
	}

	@Override
	public Integer countSkipped() {
		return (skipped) ? 1 : 0;
	}

	@Override
	public void addTag(String tag) {
		tags.add(tag);
	}

	@Override
	public void skip() {
		skipped = true;
	}
	
	
}
