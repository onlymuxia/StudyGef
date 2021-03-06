package com.onlymuxia.test.studygef.parts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.onlymuxia.test.studygef.figues.EmployeFigure;
import com.onlymuxia.test.studygef.models.*;
import com.onlymuxia.test.studygef.policy.AppDeletePolicy;

public class EmployePart extends AppAbstractEditPart {
	@Override
	protected IFigure createFigure() {
		IFigure figure = new EmployeFigure();
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AppDeletePolicy());

	}

	protected void refreshVisuals() {
		EmployeFigure figure = (EmployeFigure) getFigure();
		Employe model = (Employe) getModel();
		figure.setName(model.getName());
		figure.setFirstName(model.getPrenom());
		figure.setLayout(model.getLayout());
	}

	public List<Node> getModelChildren() {
		return new ArrayList<Node>();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Node.PROPERTY_LAYOUT))
			refreshVisuals();
	}
}