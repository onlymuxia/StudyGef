package com.onlymuxia.test.studygef.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import com.onlymuxia.test.studygef.editor.GefEditor;
import com.onlymuxia.test.studygef.editor.GefEditorInput;

public class OpenHandle extends AbstractHandler implements ISelectionListener {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		// window.getSelectionService().addSelectionListener(this);

		IEditorInput input = new GefEditorInput("Test");
		IWorkbenchPage page = window.getActivePage();
		try {
			page.openEditor(input, GefEditor.ID, true);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		System.out.println("Change:" + part.getTitle() + "-->" + part.toString());
		System.out.println("Selection:" + selection.toString());
	}

}
