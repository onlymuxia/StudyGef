package com.onlymuxia.test.studygef.models;

import org.eclipse.draw2d.geometry.Rectangle;

public class Employe extends Node implements Cloneable {
	public static final String PROPERTY_FIRSTNAME = "EmployePrenom";

	private String prenom;

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	// @Override
	// public Object clone() throws CloneNotSupportedException {
	// Employe obj = new Employe();
	// obj.prenom = prenom;
	// return obj;
	// }

	@Override
	public Object clone() throws CloneNotSupportedException {
		Employe emp = new Employe();
		emp.setName(this.getName());
		emp.setParent(this.getParent());
		emp.setPrenom(this.prenom);
		emp.setLayout(new Rectangle(getLayout().x + 10, getLayout().y + 10, getLayout().width, getLayout().height));
		return emp;
	}
}