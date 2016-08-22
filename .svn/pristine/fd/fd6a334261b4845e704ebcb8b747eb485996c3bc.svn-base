package com.onlymuxia.test.studygef.parts;

import java.beans.PropertyChangeEvent;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.onlymuxia.test.studygef.figues.ServiceFigure;
import com.onlymuxia.test.studygef.models.*;
import com.onlymuxia.test.studygef.policy.AppDeletePolicy;
import com.onlymuxia.test.studygef.policy.AppEditLayoutPolicy;
import com.onlymuxia.test.studygef.policy.AppRenamePolicy;

public class ServicePart extends AppAbstractEditPart {
	@Override
	protected IFigure createFigure() {
		IFigure figure = new ServiceFigure();
		return figure;
	}

	protected void refreshVisuals() {
		ServiceFigure figure = (ServiceFigure) getFigure();
		Service model = (Service) getModel();
		figure.setName(model.getName());
		figure.setEtage(model.getEtage());
		figure.setLayout(model.getLayout());
	}

	public List<Node> getModelChildren() {
		return ((Service) getModel()).getChildrenArray();
	}

	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new AppEditLayoutPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AppDeletePolicy());
		installEditPolicy(EditPolicy.NODE_ROLE, new AppRenamePolicy());

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Node.PROPERTY_LAYOUT)) {
			refreshVisuals();
		}
		if (evt.getPropertyName().equals(Node.PROPERTY_ADD))
			refreshChildren();
		if (evt.getPropertyName().equals(Node.PROPERTY_REMOVE))
			refreshChildren();

		if (evt.getPropertyName().equals(Node.PROPERTY_RENAME))
			refreshVisuals();

	}

}