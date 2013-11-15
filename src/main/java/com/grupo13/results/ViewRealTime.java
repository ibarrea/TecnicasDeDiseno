package com.grupo13.results;

/*
 * Clase ViewRealTime: Recibe objetos o strings y los imprime por consola,
 * permite que se ejecutado en cualquier momento y desde distintos contextos, esto
 * se debe a que está implementado con el patron Singleton.
 */

public enum ViewRealTime {
	INSTANCE;

	public void println(String line) {
		System.out.println(line);
	}
	
	public void println(Object object) {
		System.out.println(object.toString());
	}

	public void print(String line) {
		System.out.print(line);
	}

	public void printTab(Object object) {
		System.out.printf("\t%s", object.toString());
	}

	public void printTab(String line) {
		System.out.printf("\t%s", line);
	}
	
	public void printTabln(String line) {
		System.out.printf("\t%s\n", line);
	}
	
	public void printTabln(Object object) {
		System.out.printf("\t%s\n", object.toString());
	}

	public void printContent(String line) {
		System.out.printf("(%s)", line);
	}

	public void printContentln(String line) {
		System.out.printf("(%s)\n", line);
	}
}
