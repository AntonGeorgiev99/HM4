package fmi.informatics.comparators;

import fmi.informatics.extending.Person;

public class NameComparator extends PersonComparator {
	byte isDescByte;
	public NameComparator(boolean isDesc) {
		if (isDesc == true){
			isDescByte = 1;
		} else{
			isDescByte = -1;
		}
	}

	@Override
	public int compare(Person person1, Person person2) {
		if (isDescByte == 1) sortOrder = -1;
		if (person1.getName().equals(person2.getName())) {
			return 0;
		} else {
			return (person1.getName().compareTo(person2.getName()) * sortOrder);
		}
	}
}
