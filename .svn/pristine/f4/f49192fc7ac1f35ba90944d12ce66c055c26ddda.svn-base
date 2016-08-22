package com.onlymuxia.test.studygef.parts;

import java.beans.PropertyChangeEvent;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.onlymuxia.test.studygef.models.Node;
import com.onlymuxia.test.studygef.models.Service;
import com.onlymuxia.test.studygef.policy.AppDeletePolicy;
import com.onlymuxia.test.studygef.policy.AppRenamePolicy;

public class ServiceTreeEditPart extends AppAbstractTreeEditPart {
	protected List<Node> getModelChildren() {
		return ((Service) getModel()).getChildrenArray();
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AppDeletePolicy());
		installEditPolicy(EditPolicy.NODE_ROLE, new AppRenamePolicy());
	}

	public void refreshVisuals() {
		Service model = (Service) getModel();
		setWidgetText(model.getName());
		setWidgetImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT));
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Node.PROPERTY_ADD))
			refreshChildren();
		if (evt.getPropertyName().equals(Node.PROPERTY_REMOVE))
			refreshChildren();
	}

}