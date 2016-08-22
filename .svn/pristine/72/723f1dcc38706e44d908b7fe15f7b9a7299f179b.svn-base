package com.onlymuxia.test.studygef.editor;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPathEditorInput;
import org.eclipse.ui.IPersistableElement;

public class GefEditorFileInput implements IPathEditorInput {
	public IPath path = null;

	public GefEditorFileInput(IPath name) {
		this.path = name;
	}

	@Override
	public boolean exists() {
		return (this.path != null);
	}

	public boolean equals(Object o) {
		if (!(o instanceof GefEditorFileInput))
			return false;
		return ((GefEditorFileInput) o).getName().equals(getName());
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.getMissingImageDescriptor();
	}

	@Override
	public String getName() {
		return this.path.toString();
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		return this.path.toString();
	}

	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPath getPath() {
		return path;
	}

}
