package fmi.informatics.comparators;

import fmi.informatics.extending.Person;

public class WeightComparator extends PersonComparator {

	byte isDescByte;
	public WeightComparator(boolean isDesc) {
		if (isDesc == true){
			isDescByte = 1;
		} else{
			isDescByte = -1;
		}
	}

	@Override
	public int compare(Person person1, Person person2) {
		if (isDescByte == 1) sortOrder = -1;
		if (person1.getWeight() < person2.getWeight()) {
			return -1 * sortOrder;
		} else if (person1.getWeight() > person2.getWeight()) {
			return 1 * sortOrder;
		}
		
		return 0;
	}
}
