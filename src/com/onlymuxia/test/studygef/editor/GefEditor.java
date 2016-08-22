package com.onlymuxia.test.studygef.editor;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import com.onlymuxia.test.studygef.Activator;
import com.onlymuxia.test.studygef.controls.CopyNodeAction;
import com.onlymuxia.test.studygef.controls.PasteNodeAction;
import com.onlymuxia.test.studygef.controls.RenameAction;
import com.onlymuxia.test.studygef.models.*;
import com.onlymuxia.test.studygef.parts.AppTreeEditPartFactory;
import com.onlymuxia.test.studygef.policy.AppEditPartFactory;

public class GefEditor extends GraphicalEditorWithPalette {
	// public class GefEditor extends GraphicalEditor {
	public static final String ID = "com.onlymuxia.test.StudyGef.gefEditor";

	public GefEditor() {
		// Sets the GEF edit domain to the container.
		setEditDomain(new DefaultEditDomain(this));
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		System.out.println(12);
	}

	protected void configureGraphicalViewer() {
		double[] zoomLevels;
		ArrayList<String> zoomContributions;
		// super.configureGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new AppEditPartFactory());

		ScalableRootEditPart rootEditPart = new ScalableRootEditPart();
		viewer.setRootEditPart(rootEditPart);
		ZoomManager manager = rootEditPart.getZoomManager();
		getActionRegistry().registerAction(new ZoomInAction(manager));
		getActionRegistry().registerAction(new ZoomOutAction(manager));
		// La liste des zooms possible. 1 = 100%
		zoomLevels = new double[] { 0.25, 0.5, 0.75, 1.0, 1.5, 2.0, 2.5, 3.0, 4.0, 5.0, 10.0, 20.0 };
		manager.setZoomLevels(zoomLevels);
		// On ajoute certains zooms pr¨¦d¨¦finis
		zoomContributions = new ArrayList<String>();
		zoomContributions.add(ZoomManager.FIT_ALL);
		zoomContributions.add(ZoomManager.FIT_HEIGHT);
		zoomContributions.add(ZoomManager.FIT_WIDTH);
		manager.setZoomLevelContributions(zoomContributions);

		KeyHandler keyHandler = new KeyHandler();
		keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, 0),
				getActionRegistry().getAction(ActionFactory.DELETE.getId()));
		keyHandler.put(KeyStroke.getPressed('+', SWT.KEYPAD_ADD, 0),
				getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));

		keyHandler.put(KeyStroke.getPressed('-', SWT.KEYPAD_SUBTRACT, 0),
				getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));
		// On peut meme zoomer avec la molette de la souris.
		viewer.setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.NONE), MouseWheelZoomHandler.SINGLETON);

		viewer.setKeyHandler(keyHandler);

		keyHandler = new KeyHandler();
		keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, 0),
				getActionRegistry().getAction(ActionFactory.DELETE.getId()));
		keyHandler.put(KeyStroke.getPressed('+', SWT.KEYPAD_ADD, 0),
				getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));
		keyHandler.put(KeyStroke.getPressed('-', SWT.KEYPAD_SUBTRACT, 0),
				getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));
		viewer.setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.NONE), MouseWheelZoomHandler.SINGLETON);
		viewer.setKeyHandler(keyHandler);
	}

	public void buildContextMenu(IMenuManager menu) {
		IAction action;
		// ...
		action = getActionRegistry().getAction(ActionFactory.RENAME.getId());
		menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
	}

	protected void initializeGraphicalViewer() {

		GraphicalViewer viewer = getGraphicalViewer();
		model = CreateEntreprise();
		viewer.setContents(model);
		viewer.addDropTargetListener(new MyTemplateTransferDropTargetListener(viewer));

	}

	public Entreprise CreateEntreprise() {
		Entreprise psyEntreprise = new Entreprise();
		psyEntreprise.setName("Psykokwak Entreprise");
		psyEntreprise.setAddress("Quelque part sur terre");
		psyEntreprise.setCapital(100000);
		Service comptaService = new Service();
		comptaService.setName("Compta");
		comptaService.setEtage(2);
		comptaService.setLayout(new Rectangle(30, 50, 250, 150));
		Employe employeCat = new Employe();
		employeCat.setName("Debroua");
		employeCat.setPrenom("Cat");
		employeCat.setLayout(new Rectangle(25, 40, 60, 40));
		comptaService.addChild(employeCat);
		Employe employeJyce = new Employe();
		employeJyce.setName("Psykokwak");
		employeJyce.setPrenom("Jyce");
		employeJyce.setLayout(new Rectangle(100, 60, 60, 40));
		comptaService.addChild(employeJyce);
		Employe employeEva = new Employe();
		employeEva.setName("Longoria");
		employeEva.setPrenom("Eva");
		employeEva.setLayout(new Rectangle(180, 90, 60, 40));
		comptaService.addChild(employeEva);
		psyEntreprise.addChild(comptaService);
		Service rhService = new Service();
		rhService.setName("Ressources Humaine");

		rhService.setEtage(1);
		rhService.setLayout(new Rectangle(220, 230, 250, 150));
		Employe employePaul = new Employe();
		employePaul.setName("Dupond");
		employePaul.setPrenom("Paul");
		employePaul.setLayout(new Rectangle(40, 70, 60, 40));
		rhService.addChild(employePaul);
		Employe employeEric = new Employe();
		employeEric.setName("Durand");
		employeEric.setPrenom("Eric");
		employeEric.setLayout(new Rectangle(170, 100, 60, 40));
		rhService.addChild(employeEric);
		psyEntreprise.addChild(rhService);
		return psyEntreprise;
	}

	public Object getAdapter(Class type) {
		if (type == ZoomManager.class)
			return ((ScalableRootEditPart) getGraphicalViewer().getRootEditPart()).getZoomManager();
		if (type == IContentOutlinePage.class) {
			return new OutlinePage();
		}
		return super.getAdapter(type);
	}

	private Entreprise model;
	private KeyHandler keyHandler;

	protected class OutlinePage extends ContentOutlinePage {
		private ScrollableThumbnail thumbnail;
		private DisposeListener disposeListener;

		private SashForm sash;

		public OutlinePage() {
			super(new TreeViewer());
		}

		public void createControl(Composite parent) {
			sash = new SashForm(parent, SWT.VERTICAL);
			getViewer().createControl(sash);
			getViewer().setEditDomain(getEditDomain());
			getViewer().setEditPartFactory(new AppTreeEditPartFactory());
			getViewer().setContents(model);
			getSelectionSynchronizer().addViewer(getViewer());

			IActionBars bars = getSite().getActionBars();
			ActionRegistry ar = getActionRegistry();

			// Creation de la miniature.
			Canvas canvas = new Canvas(sash, SWT.BORDER);
			LightweightSystem lws = new LightweightSystem(canvas);
			thumbnail = new ScrollableThumbnail(
					(Viewport) ((ScalableRootEditPart) getGraphicalViewer().getRootEditPart()).getFigure());
			thumbnail.setSource(((ScalableRootEditPart) getGraphicalViewer().getRootEditPart())
					.getLayer(LayerConstants.PRINTABLE_LAYERS));
			lws.setContents(thumbnail);
			disposeListener = new DisposeListener() {
				@Override
				public void widgetDisposed(DisposeEvent e) {
					if (thumbnail != null) {
						thumbnail.deactivate();
						thumbnail = null;
					}
				}
			};

			bars.setGlobalActionHandler(ActionFactory.COPY.getId(), ar.getAction(ActionFactory.COPY.getId()));
			bars.setGlobalActionHandler(ActionFactory.PASTE.getId(), ar.getAction(ActionFactory.PASTE.getId()));
			getGraphicalViewer().getControl().addDisposeListener(disposeListener);
		}

		public void init(IPageSite pageSite) {
			super.init(pageSite);
			// On hook les actions de l'editeur sur la toolbar
			IActionBars bars = getSite().getActionBars();
			bars.setGlobalActionHandler(ActionFactory.UNDO.getId(),
					getActionRegistry().getAction(ActionFactory.UNDO.getId()));
			bars.setGlobalActionHandler(ActionFactory.REDO.getId(),
					getActionRegistry().getAction(ActionFactory.REDO.getId()));

			bars.setGlobalActionHandler(ActionFactory.DELETE.getId(),
					getActionRegistry().getAction(ActionFactory.DELETE.getId()));

			bars.updateActionBars();
			// On associe les raccourcis clavier de l'editeur a l'outline
			getViewer().setKeyHandler(keyHandler);

			ContextMenuProvider provider = new AppContextMenuProvider(getViewer(), getActionRegistry());
			getViewer().setContextMenu(provider);
		}

		public Control getControl() {
			return sash;
		}

		public void dispose() {
			// getSelectionSynchronizer().removeViewer(getViewer());
			// super.dispose();

			getSelectionSynchronizer().removeViewer(getViewer());
			if (getGraphicalViewer().getControl() != null && !getGraphicalViewer().getControl().isDisposed())
				getGraphicalViewer().getControl().removeDisposeListener(disposeListener);
			super.dispose();

		}
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		// Racine de la palette
		PaletteRoot root = new PaletteRoot();
		// Creation d'un groupe (pour organiser un peu la palette)
		PaletteGroup manipGroup = new PaletteGroup("Manipulation d'objets");
		root.add(manipGroup);
		// Ajout de l'outil de selection et de l'outil de selection groupe
		SelectionToolEntry selectionToolEntry = new SelectionToolEntry();
		manipGroup.add(selectionToolEntry);
		manipGroup.add(new MarqueeToolEntry());
		// Definition l'entree dans la palette qui sera utilise par defaut :
		// 1.lors de la premiere ouverture de la palette
		// 2.lorsqu'un element de la palette rend la main
		root.setDefaultEntry(selectionToolEntry);
		// return root;

		PaletteSeparator sep2 = new PaletteSeparator();
		root.add(sep2);
		// PaletteGroup instGroup = new PaletteGroup("Creation d'elemnts");
		// root.add(instGroup);
		// instGroup.add(new CreationToolEntry("Service", "Creation d'un service
		// type",
		// new NodeCreationFactory(Service.class),
		// null, null));
		// // ...
		// root.setDefaultEntry(selectionToolEntry);
		// //return root;
		PaletteGroup instGroup = new PaletteGroup("Creation d'elemnts");
		root.add(instGroup);
		instGroup.add(
				new CreationToolEntry("Service", "Creation d'un service type", new NodeCreationFactory(Service.class),
						AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/services-low.png"),
						AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/services-high.png")));
		instGroup.add(
				new CreationToolEntry("Employe", "Creation d'un employe model", new NodeCreationFactory(Employe.class),
						AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/employe-low.png"),
						AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/employe-high.png")));

		instGroup.add(new CombinedTemplateCreationEntry("Service", "Creation d'un service type", Service.class,
				new NodeCreationFactory(Service.class),
				AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/services-low.png"),
				AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/services-high.png")));
		instGroup.add(new CombinedTemplateCreationEntry("Employe", "Creation d'unemploye model", Employe.class,
				new NodeCreationFactory(Employe.class),
				AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/employe-low.png"),
				AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/employe-high.png")));

		return root;
	}

	@Override
	protected void initializePaletteViewer() {
		super.initializePaletteViewer();
		getPaletteViewer().addDragSourceListener(new TemplateTransferDragSourceListener(getPaletteViewer()));
	}

	public void createActions() {
		super.createActions();
		ActionRegistry registry = getActionRegistry();
		IAction action = new RenameAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());

		action = new CopyNodeAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new PasteNodeAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());

		;
	}

}
