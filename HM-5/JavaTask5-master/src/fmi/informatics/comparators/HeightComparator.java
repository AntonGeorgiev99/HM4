package fmi.informatics.comparators;

import fmi.informatics.extending.Person;

public class HeightComparator extends PersonComparator {
	byte isDescByte;
	public HeightComparator(boolean isDesc) {
		if (isDesc == true){
			isDescByte = 1;
		} else{
			isDescByte = -1;
		}
	}

	@Override
	public int compare(Person person1, Person person2) {
		if (isDescByte == 1) sortOrder = -1;
		if (person1.getHeight() < person2.getHeight()) {
			return -1 * sortOrder;
		} else if (person1.getHeight() > person2.getHeight()) {
			return 1 * sortOrder;
		}
		
		return 0;
	}
}
