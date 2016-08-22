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
 * 这一个类，应该是用来编辑图形界面的吧
 * @author Administrator
 *
 */
public abstract class AppAbstractEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener {
///增加监听功能
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
		//双击选中动作，打开属性View
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