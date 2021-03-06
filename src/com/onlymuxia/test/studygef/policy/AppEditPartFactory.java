package com.onlymuxia.test.studygef.policy;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.onlymuxia.test.studygef.models.*;
import com.onlymuxia.test.studygef.parts.EmployePart;
import com.onlymuxia.test.studygef.parts.EntreprisePart;
import com.onlymuxia.test.studygef.parts.HDepartmentPart;
import com.onlymuxia.test.studygef.parts.ServicePart;

public class AppEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		AbstractGraphicalEditPart part = null;
		if (model instanceof Entreprise) {
			part = new EntreprisePart();
		} else if (model instanceof Service) {
			part = new ServicePart();
		} else if (model instanceof Employe) {
			part = new EmployePart();
		}else if (model instanceof HDepartment) {
			part = new HDepartmentPart();
		}
		part.setModel(model);
		return part;
	}

}