package com.onlymuxia.test.studygef.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPathEditorInput;
import org.eclipse.ui.IPersistableElement;

public class GefEditorInput implements IEditorInput {
	public String name = null;

	public GefEditorInput(String name) {
		this.name = name;
	}

	public boolean equals(Object o) {
		if (!(o instanceof GefEditorInput))
			return false;
		return ((GefEditorInput) o).getName().equals(getName());
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.getMissingImageDescriptor();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		return this.name;
	}

	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists() {
		return (this.name != null);
	}

}
