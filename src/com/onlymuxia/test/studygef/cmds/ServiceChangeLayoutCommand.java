package com.onlymuxia.test.studygef.cmds;

import org.eclipse.draw2d.geometry.Rectangle;

import com.onlymuxia.test.studygef.models.Service;

public class ServiceChangeLayoutCommand extends AbstractLayoutCommand {
	private Service model;
	private Rectangle layout;

	public void execute() {
		model.setLayout(layout);
	}

	public void setConstraint(Rectangle rect) {
		this.layout = rect;
	}

	// public void setModel(Object model) {
	// this.model = (Service) model;
	// }
	//
	private Rectangle oldLayout;

	public void setModel(Object model) {
		this.model = (Service) model;
		// On sauvegarde l'ancien layout avant de le changer.

		this.oldLayout = ((Service) model).getLayout();
	}

	// M��thode h��rit�� appel�� lors de l'action undo.
	public void undo() {
		this.model.setLayout(this.oldLayout);
	}

}