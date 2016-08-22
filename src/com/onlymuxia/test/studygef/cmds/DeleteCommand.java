package com.onlymuxia.test.studygef.cmds;

import org.eclipse.gef.commands.Command;

import com.onlymuxia.test.studygef.models.Node;

public class DeleteCommand extends Command {
	private Node model;
	private Node parentModel;

	public void execute() {
		this.parentModel.removeChild(model);
	}

	public void setModel(Object model) {
		this.model = (Node) model;
	}

	public void setParentModel(Object model) {
		parentModel = (Node) model;
	}

	public void undo() {
		this.parentModel.addChild(model);
	}
}