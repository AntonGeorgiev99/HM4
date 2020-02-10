package fmi.informatics.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fmi.informatics.comparators.AgeComparator;
import fmi.informatics.comparators.EgnComparator;
import fmi.informatics.comparators.HeightComparator;
import fmi.informatics.comparators.NameComparator;
import fmi.informatics.comparators.PersonComparator;
import fmi.informatics.comparators.WeightComparator;
import fmi.informatics.extending.Person;
import fmi.informatics.extending.Professor;
import fmi.informatics.extending.Student;

public class PersonDataGUI {
	
	public static Person[] people;
	JTable table;
	PersonDataModel personDataModel;

	public static void main(String[] args) 
	{
		getPeople();
		PersonDataGUI gui = new PersonDataGUI();
		gui.createAndShowGUI();
	}
	
	public static void getPeople() 
	{
		people = new Person[8];
		for (int i = 0; i < 4; i++) 
		{
			Person student = Student.StudentGenerator.make();
			people[i] = student;
		}
		
		for (int i = 4; i < 8; i++) 
		{
			Person professor = Professor.ProfessorGenerator.make();
			people[i] = professor;
		}
	}
	

	
	public void createAndShowGUI() 
	{
		JFrame frame = new JFrame("РўР°Р±Р»РёС†Р° СЃ РґР°РЅРЅРё Р·Р° С…РѕСЂР°");
		frame.setSize(500, 500);
		JLabel label = new JLabel("РЎРїРёСЃСЉРє СЃ РїРѕС‚СЂРµР±РёС‚РµР»Рё", JLabel.CENTER);
		personDataModel = new PersonDataModel(people);
		table = new JTable(personDataModel);
		JScrollPane scrollPane = new JScrollPane(table);
		JButton buttonSortAge = new JButton("РЎРѕСЂС‚РёСЂР°Р№ РїРѕ РіРѕРґРёРЅРё");
		JButton buttonSort = new JButton("РЎРѕСЂС‚РёСЂР°Р№");
		
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(label, BorderLayout.SOUTH);
		container.add(scrollPane, BorderLayout.CENTER);
		
		container.add(buttonSortAge, BorderLayout.BEFORE_FIRST_LINE);
		container.add(buttonSort, BorderLayout.SOUTH);
		
		buttonSortAge.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				Arrays.sort(people);
				table.repaint();
			}
		});
		
	
		final JDialog sortDialog = new CustomDialog(getSortText(), this);
		
		
		buttonSort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sortDialog.pack();
				sortDialog.setVisible(true);
			}
		});
		
		frame.setVisible(true);
	}
	
	public void sortTable(int intValue, JTable table, Person[] people, boolean isDesc) {
		PersonComparator comparator = null;
		switch (intValue) {
			case 1: 
				comparator = new NameComparator(isDesc);
				break;
			case 2: 
				comparator = new EgnComparator(isDesc);
				break;
			case 3:
				comparator = new HeightComparator(isDesc);
				break;
			case 4: 
				comparator = new WeightComparator(isDesc);
				break;
			case 5:
				comparator = new AgeComparator(isDesc);
				break;
		}

		if (comparator == null) 
		{ 
			Arrays.sort(people);
		} else {
			Arrays.sort(people, comparator);
		}
		
		table.repaint();	
	}
	
	private static String getSortText() 
	{
		return "РњРѕР»СЏ, РІСЉРІРµРґРµС‚Рµ С†РёС„СЂР°С‚Р° РЅР° РєРѕР»РѕРЅР°С‚Р°, РїРѕ РєРѕСЏС‚Рѕ РґР° СЃРµ СЃРѕСЂС‚РёСЂР°С‚ РґР°РЅРЅРёС‚Рµ: \n" +
				" 1 - Р�РјРµ \n" +
				" 2 - Р•Р“Рќ \n" +
				" 3 - Р’РёСЃРѕС‡РёРЅР° \n" +
				" 4 - РўРµРіР»Рѕ \n" +
				" 5 - Р“РѕРґРёРЅРё \n"; 
	}
}
