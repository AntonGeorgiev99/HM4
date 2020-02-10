package fmi.informatics.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CustomDialog extends JDialog implements ActionListener, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	
	private String typedText;
	private JTextField textField;
	private JOptionPane optionPane;
	
	private String okLabel = "Ok";
	private String SortDescending = "РЎРѕСЂС‚РёСЂР°Р№ РїРѕ РЅРёР·С…РѕРґСЏС‰ СЂРµРґ";
	private String cancelLabel = "Cancel";

	private PersonDataGUI parentGui;

	public CustomDialog(String text, PersonDataGUI parent) {
		setTitle("Р�Р·Р±РѕСЂ РЅР° СЃРѕСЂС‚РёСЂР°РЅРµ");

		this.parentGui = parent;
		this.textField = new JTextField(2);

	
		Object[] array = {text, textField};
		Object[] options = {SortDescending, okLabel, cancelLabel};

		optionPane = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE, 
				JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);

		
		setContentPane(optionPane);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				optionPane.setValue(new Integer(JOptionPane.CLOSED_OPTION));
			}
		});

		addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent ce) {
				textField.requestFocusInWindow();
			}
		});

		textField.addActionListener(this);
		
		optionPane.addPropertyChangeListener(this);
	} // end CustomDialog constructor

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();

		if (isVisible() && (evt.getSource() == optionPane)
				&& (JOptionPane.VALUE_PROPERTY.equals(propertyName) || 
						JOptionPane.INPUT_VALUE_PROPERTY.equals(propertyName))) {
			
			Object value = optionPane.getValue();

			if (value == JOptionPane.UNINITIALIZED_VALUE) {
				return;
			}

			
			optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);
			boolean isDesc = false;
			if (value.equals(okLabel)) isDesc = false;
			if (value.equals(SortDescending)) isDesc = true;
			if (textField.getText() != null && !textField.getText().isEmpty()) {

				typedText = textField.getText();

				int intValue = 0;
				try {
					intValue = Integer.parseInt(typedText);
					if (intValue >= 1 && intValue <= 5) {

						parentGui.sortTable(intValue, parentGui.table, PersonDataGUI.people, isDesc);
						clearAndHide();
					} else {
						textField.selectAll();

						JOptionPane.showMessageDialog(CustomDialog.this,
								"РЎСЉР¶Р°Р»СЏРІР°Рј, СЃС‚РѕР№РЅРѕСЃС‚С‚Р°: " + typedText + " РЅРµ Рµ РІР°Р»РёРґРЅР°!",
								"Р“СЂРµС€РєР°", JOptionPane.ERROR_MESSAGE);

						typedText = null;
						textField.requestFocusInWindow();
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(CustomDialog.this, "Р’СЉРІРµР»Рё СЃС‚Рµ: " + typedText + " РІРјРµСЃС‚Рѕ С‡РёСЃР»Рѕ!", "Р“СЂРµС€РєР°", JOptionPane.ERROR_MESSAGE);
					typedText = null;

				}

			} else {
				JOptionPane.showMessageDialog(CustomDialog.this,
						"РЎСЉР¶Р°Р»СЏРІР°РјРµ, С‚СЂСЏР±РІР° РґР° РґРѕР±Р°РІРёС‚Рµ СЃС‚РѕР№РЅРѕСЃС‚!",
						"Р“СЂРµС€РєР°", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		optionPane.setValue(okLabel);

	}

	private void clearAndHide() {
		textField.setText(null);
		setVisible(false);
	}
}
