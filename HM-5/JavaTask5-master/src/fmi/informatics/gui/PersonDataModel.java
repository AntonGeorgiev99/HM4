package fmi.informatics.gui;

import javax.swing.table.AbstractTableModel;

import fmi.informatics.extending.Person;

public class PersonDataModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private Person[] people;
	public PersonDataModel(Person[] people) {
		this.people = people;
	}

	@Override
	public int getColumnCount() {
		return 5; 
	}

	@Override
	public int getRowCount() {
		return people.length; 
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{ switch (columnIndex) 
		{
			case 0: return people[rowIndex].getName();
			case 1: return people[rowIndex].getEgn();
			case 2:	return people[rowIndex].getAge();
			case 3: return people[rowIndex].getHeight();
			case 4: return people[rowIndex].getWeight();
		} return null;
	}

	@Override
	public String getColumnName(int column) 
	{
		switch (column) 
		{
			case 0: return "Р�РјРµ";
			case 1: return "Р•Р“Рќ";
			case 2: return "Р“РѕРґРёРЅРё";
			case 3: return "Р’РёСЃРѕС‡РёРЅР°";
			case 4: return "РўРµРіР»Рѕ";
			default: return super.getColumnName(column);
		}
	}
}
