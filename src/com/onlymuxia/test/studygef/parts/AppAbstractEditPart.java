package com.onlymuxia.test.studygef.parts;

import java.beans.PropertyChangeListener;

import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.onlymuxia.test.studygef.models.Node;

/**
 * ��һ���࣬Ӧ���������༭ͼ�ν���İ�
 * @author Administrator
 *
 */
public abstract class AppAbstractEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener {
///���Ӽ�������
	public void activate() {
		super.activate();
		((Node) getModel()).addPropertyChangeListener(this);
	}

	public void deactivate() {
		((Node) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}

	
	@Override
	public void performRequest(Request req) {
		//˫��ѡ�ж�����������View
		if (req.getType().equals(RequestConstants.REQ_OPEN)) {
			try {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				page.showView(IPageLayout.ID_PROP_SHEET);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}

}