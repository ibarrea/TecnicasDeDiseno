package com.grupo13.model;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

import com.grupo13.results.ViewRealTime;

/* Clase TestCase: Almacena informacion de los tests individuales que defini�
 * el cliente y que son ejecutados dentro del m�todo run() de TestSuite.
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
	
	public TestCase(String componentName, String superSuite) {
		super(superSuite);
		this.name = componentName;
		message = "Ok!";
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String toString() {
		int allowedNameLength = 40;
		int maxLength = (name.length() < allowedNameLength) ? name.length()
				: allowedNameLength;
		String inputString = name.substring(0, maxLength);
		String msg = status();
		return String.format("%1$-" + allowedNameLength + "s", inputString) + "|"
				+ String.format("%1$" + 6 + "s", ellapsedTime.toString())+"ms |" + String.format("%1$-" + 7 + "s", msg) + "|"
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
		startTimer();
		setExecuted(true);
		setAssertions();
		endTimer();
		checkTimeOut();
		show();
	}

	private void show() {
		ViewRealTime.INSTANCE.printTabln(this);
	}

	public boolean isTestCase() {
		return true;
	}

	@Override
	public Integer countTests() {
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
		element.setAttribute("time", ellapsedTime.toString());
		element.addContent(new Element("skipped").setText(countSkipped().toString()));
		if (error) {
			Element error = new Element("error");
			error.setAttribute(new Attribute("message", message));
			element.addContent(error);

		} else if (!isOK) {
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
	public void skip() {
		skipped = true;
	}

	private void setAssertions() {
		for (Assertion assertion : assertions) {
			if ( ! assertion.isOk()) {
				setMessage(assertion.getMessage());
				setError(assertion.hasError());
				setOK(false);
				break;
			}
		}
	}
	
	private void checkTimeOut() {
		if (this.ellapsedTime > this.timeOutError) {
			System.out.println("*** TIMEOUT *** (" + this.getName() + "): " + this.ellapsedTime + " > " + this.timeOutError);
			for (Assertion assertion : assertions) {
				assertion.fail();
			}
			setAssertions();
		}
	}
}
