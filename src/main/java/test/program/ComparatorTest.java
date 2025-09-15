package test.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Pet2 implements Comparator<Object> {
	private int petId;
	private String petType;

	Pet2(int argPetNewId, String argPetNewType) {
		petId = argPetNewId;
		this.petType = argPetNewType;
	}

	public String toString() {
		return getPetType();
	}

	public int getPetId() {
		return petId;
	}

	public String getPetType() {
		return petType;
	}

	public Pet2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Object o1, Object o2) {
		Pet2 pet = (Pet2)o1;
		Pet2 petAnother = (Pet2)o2;
		int result = 0;
		//use Integer class's natural ordering
		Integer pId = new Integer(pet.getPetId());
		Integer pAnotherId = new Integer(petAnother.getPetId());

		result = pId.compareTo(pAnotherId);
		//if ids are same compare by petType
		if(result == 0) {
			result= pet.getPetType().compareTo(petAnother.getPetType());
		}
		return result;
	}

}

public class ComparatorTest {

	public static void main(String[] args) {
		List<Pet2> list = new ArrayList<Pet2>();
		list.add(new Pet2(2, "Dog"));
		list.add(new Pet2(1, "Parrot"));
		list.add(new Pet2(2, "Cat"));

		Collections.sort(list,new Pet2()); // sorts using compare method

		for (Iterator<Pet2> iter = list.iterator(); iter.hasNext();) {
			Pet2 element = (Pet2) iter.next();
			System.out.println(element);
		}
	}

}
