package com.onlymuxia.test.studygef.parts;

import java.beans.PropertyChangeEvent;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.onlymuxia.test.studygef.figues.EntrepriseFigure;
import com.onlymuxia.test.studygef.models.Entreprise;
import com.onlymuxia.test.studygef.models.Node;
import com.onlymuxia.test.studygef.policy.AppEditLayoutPolicy;

public class EntreprisePart extends AppAbstractEditPart {
	@Override
	protected IFigure createFigure() {
		IFigure figure = new EntrepriseFigure();
		return figure;
	}

	protected void refreshVisuals() {
		EntrepriseFigure figure = (EntrepriseFigure) getFigure();
		Entreprise model = (Entreprise) getModel();
		figure.setName(model.getName());
		figure.setAddress(model.getAddress());
		figure.setCapital(model.getCapital());
	}

	public List<Node> getModelChildren() {
		return ((Entreprise) getModel()).getChildrenArray();
	}

	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new AppEditLayoutPolicy());
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
		if (evt.getPropertyName().equals(Node.PROPERTY_ADD))
			refreshChildren();
		if (evt.getPropertyName().equals(Node.PROPERTY_REMOVE))
			refreshChildren();
		if (evt.getPropertyName().equals(Node.PROPERTY_RENAME))
			refreshVisuals();
		if (evt.getPropertyName().equals(Entreprise.PROPERTY_CAPITAL))
			refreshVisuals();
	}

}
