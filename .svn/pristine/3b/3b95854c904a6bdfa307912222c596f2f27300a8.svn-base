package com.onlymuxia.test.studygef.cmds;

import org.eclipse.draw2d.geometry.Rectangle;

import com.onlymuxia.test.studygef.models.Employe;

public class EmployeChangeLayoutCommand extends AbstractLayoutCommand {
	private Employe model;
	private Rectangle layout;

	public void execute() {
		model.setLayout(layout);
	}

	public void setConstraint(Rectangle rect) {
		this.layout = rect;
	}

	// public void setModel(Object model) {
	// this.model = (Employe) model;
	// }

	private Rectangle oldLayout;

	public void setModel(Object model) {
		this.model = (Employe) model;
		// On sauvegarde l'ancien layout avant de le changer.
		this.oldLayout = ((Employe) model).getLayout();
	}

	// M¨¦thode h¨¦rit¨¦ appel¨¦ lors de l'action undo.
	public void undo() {
		this.model.setLayout(this.oldLayout);
	}

}