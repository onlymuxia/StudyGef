package com.onlymuxia.test.studygef.cmds;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.onlymuxia.test.studygef.models.Entreprise;
import com.onlymuxia.test.studygef.models.Service;

public class ServiceCreateCommand extends Command {
	private Entreprise en;
	private Service srv;

	public ServiceCreateCommand() {
		super();
		en = null;
		srv = null;
	}

	public void setService(Object s) {
		if (s instanceof Service)
			this.srv = (Service) s;
	}

	public void setEntreprise(Object e) {
		if (e instanceof Entreprise)
			this.en = (Entreprise) e;
	}

	public void setLayout(Rectangle r) {
		if (srv == null)
			return;
		srv.setLayout(r);
	}

	@Override
	public boolean canExecute() {
		if (srv == null || en == null)
			return false;
		return true;
	}

	@Override
	public void execute() {
		en.addChild(srv);
	}

	@Override
	public boolean canUndo() {
		if (en == null || srv == null)
			return false;
		return en.contains(srv);
	}

	@Override
	public void undo() {
		en.removeChild(srv);
	}
}