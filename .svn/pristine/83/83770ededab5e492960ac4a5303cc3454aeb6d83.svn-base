package com.onlymuxia.test.studygef;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.

	// public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
	// super(configurer);
	// }

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected IWorkbenchAction makeAction(IWorkbenchWindow window, ActionFactory af) {
		IWorkbenchAction action = af.create(window);
		register(action);
		return action;
	}

	protected void makeActions(IWorkbenchWindow window) {
		makeAction(window, ActionFactory.UNDO);
		makeAction(window, ActionFactory.REDO);
		makeAction(window, ActionFactory.COPY);
		makeAction(window, ActionFactory.PASTE);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
	}

}
