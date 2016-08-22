package com.onlymuxia.test.studygef.models;

import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.gef.requests.CreationFactory;

public class NodeCreationFactory implements CreationFactory {
	private Class<?> template;

	public NodeCreationFactory(Class<?> t) {
		this.template = t;
	}

	@Override
	public Object getNewObject() {
		if (template == null)
			return null;
		if (template == Service.class) {
			Service srv = new Service();
			srv.setEtage(42);
			srv.setName("Factorouf");
			return srv;
		} else if (template == Employe.class) {
			Employe emp = new Employe();
			emp.setPrenom("Halle");
			emp.setName("Berry");
			return emp;
		}
		return null;
	}

	@Override
	public Object getObjectType() {
		return template;
	}

}