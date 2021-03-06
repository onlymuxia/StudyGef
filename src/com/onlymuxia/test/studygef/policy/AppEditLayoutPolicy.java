package com.onlymuxia.test.studygef.policy;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.onlymuxia.test.studygef.cmds.AbstractLayoutCommand;
import com.onlymuxia.test.studygef.cmds.EmployeChangeLayoutCommand;
import com.onlymuxia.test.studygef.cmds.EmployeCreateCommand;
import com.onlymuxia.test.studygef.cmds.ServiceChangeLayoutCommand;
import com.onlymuxia.test.studygef.cmds.ServiceCreateCommand;
import com.onlymuxia.test.studygef.figues.EmployeFigure;
import com.onlymuxia.test.studygef.figues.ServiceFigure;
import com.onlymuxia.test.studygef.parts.EmployePart;
import com.onlymuxia.test.studygef.parts.EntreprisePart;
import com.onlymuxia.test.studygef.parts.ServicePart;

public class AppEditLayoutPolicy extends XYLayoutEditPolicy {
	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {

		AbstractLayoutCommand command = null;
		if (child instanceof EmployePart) {
			command = new EmployeChangeLayoutCommand();
		} else if (child instanceof ServicePart) {
			command = new ServiceChangeLayoutCommand();
		}
		command.setModel(child.getModel());
		command.setConstraint((Rectangle) constraint);
		return command;
	}

	protected Command getCreateCommand(CreateRequest request) {
		if (request.getType() == REQ_CREATE && getHost() instanceof EntreprisePart) {
			ServiceCreateCommand cmd = new ServiceCreateCommand();
			cmd.setEntreprise(getHost().getModel());
			cmd.setService(request.getNewObject());
			Rectangle constraint = (Rectangle) getConstraintFor(request);
			constraint.x = (constraint.x < 0) ? 0 : constraint.x;
			constraint.y = (constraint.y < 0) ? 0 : constraint.y;
			constraint.width = (constraint.width <= 0) ? ServiceFigure.SERVICE_FIGURE_DEFWIDTH : constraint.width;
			constraint.height = (constraint.height <= 0) ? ServiceFigure.SERVICE_FIGURE_DEFHEIGHT : constraint.height;
			cmd.setLayout(constraint);
			return cmd;
		} else if (request.getType() == REQ_CREATE && getHost() instanceof ServicePart) {
			EmployeCreateCommand cmd = new EmployeCreateCommand();
			cmd.setService(getHost().getModel());
			cmd.setEmploye(request.getNewObject());
			Rectangle constraint = (Rectangle) getConstraintFor(request);
			constraint.x = (constraint.x < 0) ? 0 : constraint.x;
			constraint.y = (constraint.y < 0) ? 0 : constraint.y;
			constraint.width = (constraint.width <= 0) ? EmployeFigure.EMPLOYE_FIGURE_DEFWIDTH : constraint.width;
			constraint.height = (constraint.height <= 0) ? EmployeFigure.EMPLOYE_FIGURE_DEFHEIGHT : constraint.height;
			cmd.setLayout(constraint);
			return cmd;
		}
		return null;
	}
}