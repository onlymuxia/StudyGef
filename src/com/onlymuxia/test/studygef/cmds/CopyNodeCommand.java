package com.onlymuxia.test.studygef.cmds;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.Clipboard;

import com.onlymuxia.test.studygef.models.Employe;
import com.onlymuxia.test.studygef.models.Node;
import com.onlymuxia.test.studygef.models.Service;

public class CopyNodeCommand extends Command {
	private ArrayList<Node> list = new ArrayList<Node>();

	public boolean addElement(Node node) {
		if (!list.contains(node)) {
			return list.add(node);
		}
		return false;
	}

	@Override
	public boolean canExecute() {
		if (list == null || list.isEmpty())
			return false;
		// Iterator<Node>
		java.util.Iterator<Node> it = list.iterator();
		while (it.hasNext()) {
			if (!isCopyableNode(it.next()))
				return false;
		}
		return true;
	}

	@Override
	public void execute() {
		if (canExecute())
			Clipboard.getDefault().setContents(list);
	}

	@Override
	public boolean canUndo() {
		return false;
	}

	public boolean isCopyableNode(Node node) {
		if (node instanceof Service || node instanceof Employe)
			return true;
		return false;
	}
}