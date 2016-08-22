package com.onlymuxia.test.studygef.models;

import java.util.ArrayList;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.views.properties.ColorPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

public class NodePropertySource implements IPropertySource {
	private Node node;

	public NodePropertySource(Node node) {
		this.node = node;
	}

	/**
	 * Returns the property value when this property source is used as a value.
	 * We can return <tt>null</tt> here
	 */

	@Override
	public Object getPropertyValue(Object id) {
		if (id.equals(Node.PROPERTY_RENAME))
			return node.getName();
		if (id.equals(Service.PROPERTY_COLOR))
			// ColorCellEditor, renvoy�� comme ��diteur de cellule par
			// ColorPropertyDescriptor,
			// utilise la classe RGB de SWT pour lire et ��crire une couleur.
			return ((Service) node).getColor().getRGB();
		if (id.equals(Service.PROPERTY_FLOOR))
			return Integer.toString(((Service) node).getEtage());
		if (id.equals(Entreprise.PROPERTY_CAPITAL))
			return Integer.toString(((Entreprise) node).getCapital());
		if (id.equals(Employe.PROPERTY_FIRSTNAME))
			return (((Employe) node).getPrenom());
		return null;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		ArrayList<IPropertyDescriptor> properties = new ArrayList<IPropertyDescriptor>();
		if (node instanceof Employe)
			properties.add(new PropertyDescriptor(Node.PROPERTY_RENAME, "Name"));
		else
			properties.add(new TextPropertyDescriptor(Node.PROPERTY_RENAME, "Name"));
		if (node instanceof Service) {
			properties.add(new ColorPropertyDescriptor(Service.PROPERTY_COLOR, "Color"));
			properties.add(new TextPropertyDescriptor(Service.PROPERTY_FLOOR, "Etage"));
		} else if (node instanceof Entreprise) {
			properties.add(new TextPropertyDescriptor(Entreprise.PROPERTY_CAPITAL, "Capital"));
		} else if (node instanceof Employe) {
			properties.add(new PropertyDescriptor(Employe.PROPERTY_FIRSTNAME, "Prenom"));
		}
		return properties.toArray(new IPropertyDescriptor[0]);
	}

	// Returns if the property with the given id has been changed since its
	// initial default value.
	// We do not handle default properties, so we return <tt>false</tt>.
	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	/**
	 * Reset a property to its default value. Since we do not handle default
	 * properties, we do nothing.
	 */
	@Override
	public void resetPropertyValue(Object id) {
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		if (id.equals(Node.PROPERTY_RENAME))
			node.setName((String) value);
		else if (id.equals(Service.PROPERTY_COLOR)) {
			Color newColor = new Color(null, (RGB) value);
			((Service) node).setColor(newColor);
		} else if (id.equals(Service.PROPERTY_FLOOR)) {
			try {
				Integer floor = Integer.parseInt((String) value);
				((Service) node).setEtage(floor);
			} catch (NumberFormatException e) {
			}
		} else if (id.equals(Entreprise.PROPERTY_CAPITAL)) {
			try {
				Integer capital = Integer.parseInt((String) value);
				((Entreprise) node).setCapital(capital);
			} catch (NumberFormatException e) {
			}
		}
	}

	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return null;
	}

}