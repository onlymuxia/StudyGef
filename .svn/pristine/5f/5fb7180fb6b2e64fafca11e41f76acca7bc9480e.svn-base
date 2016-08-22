package com.onlymuxia.test.studygef.editor;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.requests.CreationFactory;

import com.onlymuxia.test.studygef.models.NodeCreationFactory;

public class MyTemplateTransferDropTargetListener extends TemplateTransferDropTargetListener {
	public MyTemplateTransferDropTargetListener(EditPartViewer viewer) {
		super(viewer);
	}

	@Override
	protected CreationFactory getFactory(Object template) {
		return new NodeCreationFactory((Class<?>) template);
	}
}