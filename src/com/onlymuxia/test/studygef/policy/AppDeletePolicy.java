package com.onlymuxia.test.studygef.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.onlymuxia.test.studygef.cmds.DeleteCommand;

public class AppDeletePolicy extends ComponentEditPolicy {

	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		DeleteCommand command = new DeleteCommand();
		command.setModel(getHost().getModel());
		command.setParentModel(getHost().getParent().getModel());
		return command;
	}
}