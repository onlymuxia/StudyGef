package com.onlymuxia.test.studygef.parts;

import java.beans.PropertyChangeEvent;
import java.util.List;

import org.eclipse.draw2d.IFigure;

import com.onlymuxia.test.studygef.models.Entreprise;
import com.onlymuxia.test.studygef.models.Node;

public class EntrepriseTreeEditPart extends AppAbstractTreeEditPart {
	protected List<Node> getModelChildren() {
		return ((Entreprise) getModel()).getChildrenArray();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Node.PROPERTY_ADD))
			refreshChildren();
		if (evt.getPropertyName().equals(Node.PROPERTY_REMOVE))
			refreshChildren();
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub

	}
}
