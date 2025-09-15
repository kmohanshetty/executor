package test.design.pattern.creational.immutable;

import java.util.Date;
/*
 * 1) All the fields must be private and preferably final
   2) Ensure the class cannot be overridden - make the class final, or use static factories and keep constructors private
   3) Fields must be populated from the Constructor/Factory
   4) Don't provide any setters for the fields
   5) Watch out for collections. Use Collections.unmodifiable*. Also, collections should contain only immutable Objects
   6) All the getters must provide immutable objects or use defensive copying
   7) Don't provide any methods that change the internal state of the Object
 */
public final class TestImmutable {
	public static void main(String [] args){
		ImmutableClass immutableClass = new ImmutableClass("ABC", 101, new Date());
		System.out.println(immutableClass);
	}
	
}

final class ImmutableClass {
	private final String name;//immutable
	private final int regNo;//immutable
	private final Date nowDate;
	
	public ImmutableClass(String name, int regNo,Date nowDate) {
		this.name = name;
		this.regNo = regNo;
		this.nowDate = nowDate;
	}

	public String getName() {
		return name;
	}

	public int getRegNo() {
		return regNo;
	}
	
	public Date getNowDate(){
		return new Date(nowDate.getTime());
	}
	
	/*public void tryModify(String name, int regNo,Date nowDate){
		this.name = name;
		this.regNo = regNo;
		this.nowDate = nowDate;
	}*/

	@Override
	public String toString() {
		return "ImmutableClass [name=" + name + ", regNo=" + regNo + " nowDate="+ nowDate + "]";
	}
	
	
}