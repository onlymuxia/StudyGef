package com.onlymuxia.test.studygef.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.onlymuxia.test.studygef.models.Employe;
import com.onlymuxia.test.studygef.models.Entreprise;
import com.onlymuxia.test.studygef.models.HDepartment;
import com.onlymuxia.test.studygef.models.Service;

public class AppTreeEditPartFactory implements EditPartFactory {
	/**
	 * 
	 */
	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		if (model instanceof Entreprise){
			part = new EntrepriseTreeEditPart();
		}
		else if (model instanceof Service){
			part = new ServiceTreeEditPart();
		}
		else if (model instanceof Employe){
			part = new EmployeTreeEditPart();
		}else if(model instanceof HDepartment){
			part = new HDepartmentEditPart();
		}
		if (part != null)
			part.setModel(model);
		return part;
	}
}