package com.onlymuxia.test.studygef.cmds;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.onlymuxia.test.studygef.models.Employe;
import com.onlymuxia.test.studygef.models.Service;

public class EmployeCreateCommand extends Command {
	private Service srv;
	private Employe emp;

	public EmployeCreateCommand() {
		super();
		srv = null;
		emp = null;
	}

	public void setService(Object s) {
		if (s instanceof Service)
			this.srv = (Service) s;
	}

	public void setEmploye(Object e) {
		if (e instanceof Employe)
			this.emp = (Employe) e;
	}

	public void setLayout(Rectangle r) {
		if (emp == null)
			return;
		emp.setLayout(r);
	}

	@Override
	public boolean canExecute() {
		if (srv == null || emp == null)
			return false;
		return true;
	}

	@Override
	public void execute() {
		srv.addChild(emp);
	}

	@Override
	public boolean canUndo() {
		if (srv == null || emp == null)
			return false;
		return srv.contains(emp);
	}

	@Override
	public void undo() {
		srv.removeChild(emp);
	}
}
