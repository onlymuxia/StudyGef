package com.onlymuxia.test.studygef.policy;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

import com.onlymuxia.test.studygef.cmds.RenameCommand;

public class AppRenamePolicy extends AbstractEditPolicy {

	public Command getCommand(Request request) {
		if (request.getType().equals("rename"))
			return createRenameCommand(request);
		return null;
	}

	protected Command createRenameCommand(Request renameRequest) {
		RenameCommand command = new RenameCommand();
		command.setModel(getHost().getModel());
		command.setNewName((String) renameRequest.getExtendedData().get("newName"));
		return command;
	}

}